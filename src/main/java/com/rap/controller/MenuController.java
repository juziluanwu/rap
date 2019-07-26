package com.rap.controller;

import com.rap.entity.Menu;
import com.rap.entity.Result;
import com.rap.enums.ErrorEnum;
import com.rap.service.MenuService;
import com.rap.utils.ResultUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/menu")
public class MenuController {
    @Autowired
    private MenuService menuService;

    @GetMapping("/list/{pid}")
    public Result list(@PathVariable("pid")Integer pid) {
        return ResultUtils.result(ErrorEnum.SUCCESS, menuService.list(pid));
    }

    @PostMapping("/save")
    public Result save(@RequestBody Menu record) {
        menuService.insert(record);
        return ResultUtils.result(ErrorEnum.SUCCESS, "新增成功");
    }
    @PostMapping("/update")
    public Result update(@RequestBody Menu record) {
        menuService.update(record);
        return ResultUtils.result(ErrorEnum.SUCCESS, "修改成功");
    }
}
