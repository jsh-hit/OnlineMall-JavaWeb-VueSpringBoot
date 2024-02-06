package com.ceshi.demo.controller;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

import com.ceshi.demo.bean.ordersimage;
import com.ceshi.demo.mapper.ordersimageMapper;
import com.ceshi.demo.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/ordersimage")
// 解决前端跨域请求问题
@CrossOrigin
public class ordersimageController {
    @Autowired
    private ordersimageMapper ordersimageMapper;


    @GetMapping("userid")
//   查
    public String getuseridOrders(@RequestParam int id){


        String sql="SELECT orders.id as id,user_id,product_id,shipping_id,payment,postage,orders.status as status," +
                "pay_time,orders.store_id as store_id,logistics_company,quantity,product.name as name,product.image as image FROM orders,product" +
                " where user_id="+id +" and orders.product_id=product.id";


        List list =this.ordersimageMapper.queryByCondition(sql);

        R r = R.ok().data("order", list);

        return JSON.toJSONString(r);
    }






}
