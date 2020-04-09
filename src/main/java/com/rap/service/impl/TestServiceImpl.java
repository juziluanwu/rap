package com.rap.service.impl;

import com.rap.entity.Detail;
import com.rap.entity.Test;
import com.rap.mapper.TestMapper;
import com.rap.service.Test1Service;
import com.rap.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.Random;
import java.util.stream.Stream;

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
        Stream.iterate(0, i -> i + 1).limit(100).forEach(i -> {
            new Thread(() -> {
                a();
            }).start();
        });

    }

    @Transactional(rollbackFor = Exception.class)
    public void a() {

        int random = new Random().nextInt(100) + 1;
        Test test = testMapper.selectForUpdate(176);
        BigDecimal amount = new BigDecimal(random);
        testMapper.updateAmount(176, amount.negate());
        Detail detail = new Detail();
        detail.setAmount(amount);
        detail.setTestid(176);
        detail.setEndamount(test.getAmount().subtract(amount));
//        testMapper.insertdetail(detail);
        testMapper.insertdetail1(detail);

    }

    @Transactional(rollbackFor = Exception.class)
    public void b() {

        Test t = new Test();
        t.setName("2");
        testMapper.insert(t);
        int i = 1 / 0;

    }
}
