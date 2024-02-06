package com.ceshi.demo.controller;


import com.alibaba.fastjson.JSON;

import com.ceshi.demo.bean.cartproduct;
import com.ceshi.demo.mapper.CartMapper;
import com.ceshi.demo.mapper.CartimageMapper;
import com.ceshi.demo.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cart")
// 解决前端跨域请求问题
@CrossOrigin
public class CartimageController {


    @Autowired
    private CartimageMapper cartimageMapper;


    @GetMapping("image")
//   查
    public String getimageProducts(@RequestParam int id){

        String sql="SELECT shoppingcart.id as id, user_id,product_id,quantity,image,name,price FROM product,shoppingcart where shoppingcart.user_id="+id+" and product.id = shoppingcart.product_id";
        List<cartproduct> product =this.cartimageMapper.queryByCondition(sql);

        R r = R.ok().data("product",product);


        return JSON.toJSONString(r);


    }




}
