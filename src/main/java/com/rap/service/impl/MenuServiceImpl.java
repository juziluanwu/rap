package com.rap.service.impl;

import com.rap.entity.Menu;
import com.rap.mapper.MenuMapper;
import com.rap.mapper.ProjectMapper;
import com.rap.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuServiceImpl implements MenuService {
    @Autowired
    private MenuMapper menuMapper;
    @Autowired
    private ProjectMapper projectMapper;

    @Override
    public List<Menu> list(Integer pid) {
        List<Menu> list = menuMapper.list(pid);
        if (list != null) {
            Menu m = projectMapper.selectById(pid);
            list.add(m);
        }

        return list;
    }

    @Override
    public void insert(Menu menu) {
        menuMapper.insert(menu);
    }

    @Override
    public void update(Menu menu) {
        menuMapper.update(menu);
    }
}
