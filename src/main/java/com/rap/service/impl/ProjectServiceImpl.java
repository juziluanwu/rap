package com.rap.service.impl;

import com.rap.entity.Project;
import com.rap.entity.Result;
import com.rap.enums.ErrorEnum;
import com.rap.mapper.ProjectMapper;
import com.rap.service.ProjectService;
import com.rap.utils.ResultUtils;
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

    @Override
    public List<Project> childproject(Map<String, Object> param) {
        param.put("type",1);
        List<Project> projects =  projectMapper.list(param);
        if(projects == null || projects.isEmpty()){
            projects= new ArrayList<>();
            //如果没有子项目
            Integer fid =(Integer)param.get("fid");
            Project project = projectMapper.selectById(fid);
            projects.add(project);
        }
        return projects;
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
    public Result update(Project project) {
        Project oldp = projectMapper.selectById(project.getId());
        if (oldp != null && !oldp.getVersion().equals(project.getVersion())) {
            return ResultUtils.fail("该接口已被修改，无法保存");
        }
        project.setVersion(project.getVersion() + 1);
        projectMapper.update(project);
        return ResultUtils.result(ErrorEnum.SUCCESS, "修改完成");
    }

    @Override
    public List<Project> tree(Integer pid) {
        Project project = projectMapper.selectById(pid);
        List<Project> tree = projectMapper.selectTreeByProductid(pid);
        if (tree == null) {
            tree = new ArrayList<>();
        }
        tree.add(project);
        return tree;
    }



    @Override
    public void delete(Integer id) {
        List<Integer> list = new ArrayList<>();
        list.add(id);
        digui(list, id);
        projectMapper.batchdelete(list);
    }

    private void digui(List<Integer> list, Integer id) {
        List<Project> child = projectMapper.selectByProductid(id);
        if (child != null && !child.isEmpty()) {
            for (Project project : child) {
                list.add(project.getId());
                digui(list, project.getId());
            }
        }
    }

}
