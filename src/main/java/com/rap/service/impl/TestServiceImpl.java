package com.rap.service.impl;

import com.rap.entity.Test;
import com.rap.mapper.TestMapper;
import com.rap.service.Test1Service;
import com.rap.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.math.BigDecimal;

@Service
public class TestServiceImpl implements TestService {
    @Autowired
    private TestMapper testMapper;
    @Resource
    private Test1Service test1Service;
    @Resource
    private TestService testService;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void test() {
        Test vo = new Test();
        vo.setId(45);
        vo.setAmount(new BigDecimal(10));
        testMapper.update(vo);

       int i= testMapper.updateById(new BigDecimal(100),45,1);
    }

    //    /@Transactional(rollbackFor = Exception.class)
    public void a() {
        Test t = new Test();
        t.setName("1");
        testMapper.insert(t);
    }

    @Transactional(rollbackFor = Exception.class)
    public void b() {

        Test t = new Test();
        t.setName("2");
        testMapper.insert(t);
        int i = 1 / 0;

    }
}
