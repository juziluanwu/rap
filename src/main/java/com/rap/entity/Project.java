package com.rap.entity;

import lombok.Data;

@Data
public class Project {
    private Integer id;
    private String name;
    private Integer fid;
    private Integer type;
    private String url;
    private String remark;
    private String requestparam;
    private String responseparam;
    private Integer version;
    private Integer pid;
    private Integer iftype;
    private String creator;
}
