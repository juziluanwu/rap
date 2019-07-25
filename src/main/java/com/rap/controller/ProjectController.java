package com.rap.controller;

import com.rap.entity.Project;
import com.rap.entity.Result;
import com.rap.enums.ErrorEnum;
import com.rap.service.ProjectService;
import com.rap.utils.ResultUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/project")
public class ProjectController {
    @Autowired
    private ProjectService projectService;

    @GetMapping("/list")
    public Result list(@RequestParam(value = "info",required = false)String info) {
        return ResultUtils.result(ErrorEnum.SUCCESS, projectService.list(info));
    }

    @PostMapping("/save")
    public Result save(@RequestBody Project record) {
        projectService.insert(record);
        return ResultUtils.result(ErrorEnum.SUCCESS, "新增成功");
    }
    @PostMapping("/update")
    public Result update(@RequestBody Project record) {
        projectService.update(record);
        return ResultUtils.result(ErrorEnum.SUCCESS, "修改成功");
    }
}
