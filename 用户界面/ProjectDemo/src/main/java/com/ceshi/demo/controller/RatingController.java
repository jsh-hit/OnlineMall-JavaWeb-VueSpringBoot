package com.ceshi.demo.controller;


import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ceshi.demo.bean.product;
import com.ceshi.demo.bean.rating;
import com.ceshi.demo.mapper.ProductMapper;
import com.ceshi.demo.mapper.RatingMapper;
import com.ceshi.demo.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
//跨域
@RequestMapping("/rating")
public class RatingController {

    @Autowired
    private RatingMapper ratingMapper;


    @GetMapping("get")
//   查
    public String getproductrating(@RequestParam int id){

       QueryWrapper<rating> query =new QueryWrapper<rating>();

      query.eq("product_id",id);

        List list = ratingMapper.selectList(query);

        R r = R.ok().data("rating",list);

        return JSON.toJSONString(r);
    }

}
