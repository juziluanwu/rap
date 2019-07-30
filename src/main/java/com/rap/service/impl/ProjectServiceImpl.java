package com.rap.service.impl;

import com.rap.entity.Project;
import com.rap.mapper.ProjectMapper;
import com.rap.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProjectServiceImpl implements ProjectService {
    @Autowired
    private ProjectMapper projectMapper;

    @Override
    public List<Project> list(String info) {
        return projectMapper.list(info);
    }

    @Override
    public void insert(Project project) {
        project.setType(1);
        projectMapper.insert(project);
    }

    @Override
    public void update(Project project) {
        projectMapper.update(project);
    }
}
