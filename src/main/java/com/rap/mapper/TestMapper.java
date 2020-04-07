package com.rap.mapper;

import com.rap.entity.Detail;
import com.rap.entity.Test;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
@Mapper
public interface TestMapper {

    int insert(Test record);

    int update(Test record);

    int updateById(@Param("amount") BigDecimal amount, @Param("id") Integer id, @Param("versionnum") Integer versionnum);

    int updateAmount(@Param("id")Integer id,@Param("amount")BigDecimal amount);

    int insertdetail(Detail detail);
}
