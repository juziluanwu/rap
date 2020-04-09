package com.rap.utils;

import java.math.BigDecimal;

public class TestUtil {
    public static void  main(String[] args){
        BigDecimal a = new BigDecimal(1).divide(new BigDecimal(3));
        System.out.println(a);
    }
}
