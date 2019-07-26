package com.rap.controller;

import com.rap.entity.Detail;
import com.rap.entity.Result;
import com.rap.enums.ErrorEnum;
import com.rap.service.DetailService;
import com.rap.utils.ResultUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/menu")
public class DetailController {
    @Autowired
    private DetailService detailService;

    @GetMapping("/list")
    public Result list(@RequestParam(value = "name", required = false) String name) {
        return ResultUtils.result(ErrorEnum.SUCCESS, detailService.list(name));
    }

    @GetMapping("/info/{id}")
    public Result info(@PathVariable("id") Integer id) {
        return ResultUtils.result(ErrorEnum.SUCCESS, detailService.info(id));
    }

    @PostMapping("/save")
    public Result save(@RequestBody Detail record) {
        detailService.insert(record);
        return ResultUtils.result(ErrorEnum.SUCCESS, "新增成功");
    }

    @PostMapping("/update")
    public Result update(@RequestBody Detail record) {
        detailService.update(record);
        return ResultUtils.result(ErrorEnum.SUCCESS, "修改成功");
    }
}
