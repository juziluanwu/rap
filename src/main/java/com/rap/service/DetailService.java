package com.rap.service;

import com.rap.entity.Detail;

import java.util.List;

public interface DetailService {
    void insert(Detail detail);

    List<Detail> list(String name);

    Detail info(Integer id);

    void update(Detail detail);
}
