package com.rap.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Detail {
    private Integer id;
    private String name;
    private Integer menuid;
    private Integer type;
    private String url;
    private String remark;
    private String requestparam;
    private String responseparam;
    private Integer version;
}
