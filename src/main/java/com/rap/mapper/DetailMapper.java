package com.rap.mapper;

import com.rap.entity.Detail;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper
public interface DetailMapper {

    int insert(Detail record);

    List<Detail> list(String name);

    int update(Detail record);

    Detail info(Integer id);
}
