package com.ceshi.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import com.ceshi.demo.bean.ordersimage;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface ordersimageMapper extends BaseMapper<ordersimage> {
//    List<cartproduct> queryByCondition(String sql);

    @Select("${sql}")
    List<ordersimage> queryByCondition(@Param("sql") String sql);
}