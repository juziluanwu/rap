package com.rap.service;

import com.rap.entity.Project;

import java.util.List;
import java.util.Map;

public interface ProjectService {
    Project insert(Project project);

    List<Project> list( Map<String,Object> param );

    Project info(Integer id);

    void update(Project project);

    List<Project> tree(Integer pid);

    void delete(Integer id);
}
