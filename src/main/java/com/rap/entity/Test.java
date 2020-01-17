package com.rap.entity;

import lombok.Data;
import tk.mybatis.mapper.annotation.Version;

import java.math.BigDecimal;

@Data
public class Test {
    private Integer id;
    private String name;
    @Version
    private Integer versionum;
    private BigDecimal amount;
}
