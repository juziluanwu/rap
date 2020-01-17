package com.rap.controller;

import com.rap.entity.Result;
import com.rap.enums.ErrorEnum;
import com.rap.service.TestService;
import com.rap.utils.ResultUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/test")
public class TestController {
    @Resource
    private TestService testService;

    @GetMapping("/test")
    public Result tree() {
        testService.test();
        return ResultUtils.result(ErrorEnum.SUCCESS, "");
    }
}
