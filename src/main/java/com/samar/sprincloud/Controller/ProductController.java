package com.samar.sprincloud.Controller;

import com.netflix.discovery.converters.Auto;
import com.samar.sprincloud.model.Product;
import com.samar.sprincloud.model.dto.CouponDto;
import com.samar.sprincloud.repo.ProductRepo;
import com.samar.sprincloud.restclients.CouponClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/productapi")
public class ProductController {
    @Autowired
    CouponClient couponClient;

    @Autowired
    private ProductRepo productRepo;

    @PostMapping("/products")
    public Product create(@RequestBody Product product) {
        CouponDto couponDto = couponClient.getCoupon(product.getCouponCode());
        product.setPrice(product.getPrice().subtract(couponDto.getDiscount()));
        return productRepo.save(product);
    }
}
