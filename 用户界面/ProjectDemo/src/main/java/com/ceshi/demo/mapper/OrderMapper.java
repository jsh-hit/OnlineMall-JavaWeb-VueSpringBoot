package com.ceshi.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ceshi.demo.bean.cartproduct;
import com.ceshi.demo.bean.orders;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public interface OrderMapper extends BaseMapper<orders> {

    @Select("${sql}")
    List<orders> queryByCondition(@Param("sql") String sql);
}