package com.rap.entity;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class Detail {
    private Integer id;
    private BigDecimal amount;
    private BigDecimal endamount;
    private Integer testid;
}
