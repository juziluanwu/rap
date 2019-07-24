package com.rap.service;

import com.rap.entity.Project;

import java.util.List;

public interface ProjectService {
    void insert(Project project);

    List<Project> list();
}
