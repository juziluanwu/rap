package com.rap.service.impl;

import com.rap.entity.Project;
import com.rap.mapper.ProjectMapper;
import com.rap.service.ProjectService;
import org.springframework.beans.PropertyAccessException;
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
    public Project insert(Project project) {
        project.setVersion(1);
        projectMapper.insert(project);
        return project;
    }

    @Override
    public void update(Project project) {
        Project oldp = projectMapper.selectById(project.getId());
        if(oldp != null && !oldp.getVersion().equals(project.getVersion())){

        }

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

    @Override
    public void delete(Integer id) {
        List<Integer> list = new ArrayList<>();
        list.add(id);
        digui(list,id);
        projectMapper.batchdelete(list);
    }

    private void digui(List<Integer> list,Integer id){
        List<Project> child = projectMapper.selectByProductid(id);
        if(child != null && !child.isEmpty()){
            for(Project project:child){
                list.add(project.getId());
                digui(list,project.getId());
            }
        }
    }
}
