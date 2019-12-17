package com.samar.sprincloud.model.dto;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;

@Getter
@Setter
public class CouponDto {

    private Long id;
    private String code;
    private BigDecimal discount;
    private String expDate;
}
