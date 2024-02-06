package com.ceshi.demo.controller;


import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

import com.ceshi.demo.bean.shipping;

import com.ceshi.demo.mapper.ShippingMapper;
import com.ceshi.demo.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/shipping")
// 解决前端跨域请求问题
@CrossOrigin
public class shippingController {


    @Autowired
    private ShippingMapper shippingMapper;


    @GetMapping("userid")
//   查
    public String getaddress(@RequestParam int id){

     QueryWrapper<shipping> query =new QueryWrapper<shipping>();

        // 多个条件
        query.eq("user_id",id);

        List list = shippingMapper.selectList(query);


        R r = R.ok().data("address",list);

        return JSON.toJSONString(r);


    }


    @PostMapping("del")
//   查
    public String delete(@RequestParam int id){

        int shan = shippingMapper.deleteById(id);

        if(shan>0) {
            R r = R.ok();

            return JSON.toJSONString(r);
        }
        R r = R.error();

        return JSON.toJSONString(r);

    }


    @PostMapping("update")
//   查
    public String update(@RequestBody shipping update){

        if(  this.shippingMapper.updateById(update) >0)
        {
            R r = R.ok();
            return JSON.toJSONString(r);
        }


        R r = R.error();

        return JSON.toJSONString(r);

    }


    @PostMapping("add")
//   查
    public String add(@RequestBody shipping add){

        if(  this.shippingMapper.insert(add)>0)
        {
            R r = R.ok();
            return JSON.toJSONString(r);
        }


        R r = R.error();

        return JSON.toJSONString(r);

    }
}
