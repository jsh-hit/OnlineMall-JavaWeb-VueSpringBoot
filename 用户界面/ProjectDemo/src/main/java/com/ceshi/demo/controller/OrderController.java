package com.ceshi.demo.controller;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ceshi.demo.bean.cartproduct;
import com.ceshi.demo.bean.orders;

import com.ceshi.demo.mapper.OrderMapper;
import com.ceshi.demo.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@CrossOrigin
//跨域
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private OrderMapper OrderMapper;
    @GetMapping("all")
//   查
    public String getOrders(){


        List list = OrderMapper.selectList(null);
        R r = R.ok().data("items",list);

        return JSON.toJSONString(r);
//        return "测试";
    }

    @GetMapping("get")
//   查
    public String getidOrders(@RequestParam int id){

//        QueryWrapper<emp> query =new QueryWrapper<emp>();
//
//        // 多个条件
//        query.eq("empno",eno);

        orders orders = OrderMapper.selectById(id);

        R r = R.ok().data("order", orders);

        return JSON.toJSONString(r);
    }


    @PostMapping("add")
//   增
    public String addOrder(@RequestBody orders add){
//@RequestParam int eno,@RequestParam String ename,@RequestParam String job,@RequestParam double salary
        // select * from user (对象和表名一致 对应） ：查表
        // User person = new User() 创建对象

        int tian = OrderMapper.insert(add);
        if(tian > 0) {


            R r = R.ok();

            return JSON.toJSONString(r);
//        return "测试";
        }

        R r = R.error();

        return JSON.toJSONString(r);



    }

    @PostMapping("delid")

//   增
    public String delOrder(@RequestParam int id){

        int shan = OrderMapper.deleteById(id);

        if(shan > 0) {
            R r = R.ok();

            return JSON.toJSONString(r);
        }
        R r = R.error();

        return JSON.toJSONString(r);

    }




    @PostMapping(value = "/update")
    public String updatebyid(@RequestBody orders update){


        if(  this.OrderMapper.updateById(update) >0)
        {
            R r = R.ok();
            return JSON.toJSONString(r);
        }


        R r = R.error();

        return JSON.toJSONString(r);

    }
}
