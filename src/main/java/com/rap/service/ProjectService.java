package com.rap.service;

import com.rap.entity.Project;
import com.rap.entity.Result;

import java.util.List;
import java.util.Map;

public interface ProjectService {
    Project insert(Project project);

    List<Project> list( Map<String,Object> param );

    List<Project> childproject( Map<String,Object> param );

    Project info(Integer id);

    Result update(Project project);

    List<Project> tree(Integer pid);

    void delete(Integer id);
}
