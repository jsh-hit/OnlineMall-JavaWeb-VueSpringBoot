package com.ceshi.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ceshi.demo.bean.user;
import org.springframework.stereotype.Component;

@Component
public interface UserMapper extends BaseMapper<user> {
}