package com.ceshi.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ceshi.demo.bean.product;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface ProductMapper extends BaseMapper<product> {

    @Select("${sql}")
    List<product> queryByCondition(@Param("sql") String sql);
}