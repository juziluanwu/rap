package com.rap.service.impl;

import com.rap.entity.Test;
import com.rap.exceptions.GlobleException;
import com.rap.mapper.TestMapper;
import com.rap.service.Test1Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class Test1ServiceImpl implements Test1Service {
    @Autowired
    private TestMapper testMapper;

    public void a() {
        Test t = new Test();
        t.setName("1");
        testMapper.insert(t);
    }

    @Transactional(rollbackFor = Exception.class)
    public void b() {
     try {
        Test t = new Test();
        t.setName("2");
        testMapper.insert(t);
        int i = 1 / 0;
        } catch (Exception e) {
            throw new GlobleException("算术异常");
        }
    }
}
