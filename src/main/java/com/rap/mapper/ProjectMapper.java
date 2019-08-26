package com.rap.mapper;

import com.rap.entity.Project;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
@Mapper
public interface ProjectMapper {

    int insert(Project record);

    List<Project> list(Map<String,Object> param);

    int update(Project record);

    Project selectById(Integer id);

    List<Project> selectByProductid(Integer pid);

    int batchdelete(@Param("list") List<Integer> list);
}
