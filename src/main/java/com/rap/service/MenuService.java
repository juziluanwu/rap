package com.rap.service;

import com.rap.entity.Menu;

import java.util.List;

public interface MenuService {
    void insert(Menu menu);

    List<Menu> list(Integer pid);

    void update(Menu menu);
}
