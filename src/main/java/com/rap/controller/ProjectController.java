package com.rap.controller;

import com.rap.entity.Project;
import com.rap.entity.Result;
import com.rap.enums.ErrorEnum;
import com.rap.service.ProjectService;
import com.rap.utils.ResultUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/project")
public class ProjectController {
    @Autowired
    private ProjectService projectService;

    @GetMapping("/list")
    public Result list(@RequestParam(value = "name", required = false) String name,
                       @RequestParam(value = "type", required = false) Integer type) {
        Map<String, Object> param = new HashMap<>();
        param.put("name", name);
        param.put("type", type);
        return ResultUtils.result(ErrorEnum.SUCCESS, projectService.list(param));
    }

    @GetMapping("/childproject")
    public Result childproject(@RequestParam(value = "name", required = false) String name,
                       @RequestParam("fid") Integer fid) {
        Map<String, Object> param = new HashMap<>();
        param.put("name", name);
        param.put("fid", fid);
        return ResultUtils.result(ErrorEnum.SUCCESS, projectService.childproject(param));
    }

    @GetMapping("/tree")
    public Result tree(@RequestParam(value = "pid") Integer pid) {
        return ResultUtils.result(ErrorEnum.SUCCESS, projectService.tree(pid));
    }
    @GetMapping("/info/{id}")
    public Result info(@PathVariable("id") Integer id) {
        return ResultUtils.result(ErrorEnum.SUCCESS, projectService.info(id));
    }

    @PostMapping("/save")
    public Result save(@RequestBody Project record) {

        return ResultUtils.result(ErrorEnum.SUCCESS, projectService.insert(record));
    }

    @PostMapping("/update")
    public Result update(@RequestBody Project record) {
        return projectService.update(record);

    }

    @PostMapping("/delete/{id}")
    public Result delete(@PathVariable("id") Integer id) {
        projectService.delete(id);
        return ResultUtils.result(ErrorEnum.SUCCESS, "删除成功");
    }
}
