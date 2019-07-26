package com.rap.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Menu {
    private Integer id;
    private String name;
    private Integer pid;
    private Integer type;
    private Integer fid;
}
