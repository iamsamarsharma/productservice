package com.samar.sprincloud.restclients;


import com.samar.sprincloud.model.dto.CouponDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("COUPON-SERVICE")
public interface CouponClient {
    @GetMapping("couponapi/coupons/{code}")
    CouponDto getCoupon(@PathVariable("code") String code);
}
