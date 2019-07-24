package com.rap.mapper;

import com.rap.entity.Project;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper
public interface ProjectMapper {
    int insert(Project record);
    List<Project> list();
    int update(Project record);
}
