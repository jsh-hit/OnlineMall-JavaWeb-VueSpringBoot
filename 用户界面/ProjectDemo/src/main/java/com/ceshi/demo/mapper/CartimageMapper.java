package com.ceshi.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ceshi.demo.bean.cartproduct;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public interface CartimageMapper extends BaseMapper<cartproduct> {
//    List<cartproduct> queryByCondition(String sql);

    @Select("${sql}")
    List<cartproduct> queryByCondition(@Param("sql") String sql);
}


