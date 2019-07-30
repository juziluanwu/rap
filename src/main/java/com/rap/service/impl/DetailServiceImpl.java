package com.rap.service.impl;

import com.rap.entity.Detail;
import com.rap.entity.Menu;
import com.rap.mapper.DetailMapper;
import com.rap.mapper.MenuMapper;
import com.rap.service.DetailService;
import com.rap.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DetailServiceImpl implements DetailService {
    @Autowired
    private DetailMapper detailMapper;

    @Override
    public List<Detail> list(String  name) {
        return detailMapper.list(name);
    }
    public Detail info(Integer id){
        return detailMapper.selectById(id);
    }

    @Override
    public void insert(Detail detail) {
        detail.setVersion(1);
        detailMapper.insert(detail);
    }

    @Override
    public void update(Detail detail) {
        detailMapper.update(detail);
    }
}
