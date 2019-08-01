package com.rap.service.impl;

import com.rap.entity.Project;
import com.rap.mapper.ProjectMapper;
import com.rap.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class ProjectServiceImpl implements ProjectService {
    @Autowired
    private ProjectMapper projectMapper;

    @Override
    public List<Project> list(Map<String, Object> param) {
        return projectMapper.list(param);
    }

    public Project info(Integer id) {
        return projectMapper.selectById(id);
    }

    @Override
    public void insert(Project project) {
        project.setVersion(1);
        projectMapper.insert(project);
    }

    @Override
    public void update(Project project) {
        projectMapper.update(project);
    }

    @Override
    public List<Project> tree(Integer pid) {
        List<Project> tree = new ArrayList<>();
        Project project = projectMapper.selectById(pid);
        tree.add(project);
        List<Project> child = projectMapper.selectByProductid(pid);
        if (child != null && !child.isEmpty()) {
            tree.addAll(child);
        }
        return tree;
    }
}
