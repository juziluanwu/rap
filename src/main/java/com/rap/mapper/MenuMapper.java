package com.rap.mapper;

import com.rap.entity.Menu;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper
public interface MenuMapper {

    int insert(Menu record);

    List<Menu> list(Integer pid);

    int update(Menu record);
}
