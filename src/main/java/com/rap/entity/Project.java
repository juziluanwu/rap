package com.rap.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Project {
    private Integer id;
    private String name;
    private String remark;
    private Integer type;
}
