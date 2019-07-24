package com.rap.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Result {
	private Boolean success;
    private Integer errCode;
    private String errMsg;
    private Object Data;
}
