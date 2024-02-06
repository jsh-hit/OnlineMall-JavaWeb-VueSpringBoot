package com.ceshi.demo.controller;


import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.ceshi.demo.bean.cartproduct;
import com.ceshi.demo.bean.shoppingcart;
import com.ceshi.demo.bean.user;
import com.ceshi.demo.mapper.CartMapper;
import com.ceshi.demo.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/shoppingcart")
// 解决前端跨域请求问题
@CrossOrigin
public class CartController {

    @Autowired
    private CartMapper cartMapper;


    @PostMapping("update")
//   查
    public String updatecart(@RequestBody shoppingcart update){

        if(  this.cartMapper.updateById(update) >0)
        {
            R r = R.ok();
            return JSON.toJSONString(r);
        }


        R r = R.error();

        return JSON.toJSONString(r);


    }



    @PostMapping("add")
//   查
    public String addcart(@RequestBody shoppingcart add){

        if(  this.cartMapper.insert(add)>0)
        {
            R r = R.ok();
            return JSON.toJSONString(r);
        }


        R r = R.error();

        return JSON.toJSONString(r);


    }

    @PostMapping("delete")
//   查
    public String deletecart(@RequestParam int  id){

        if(  this.cartMapper.deleteById(id)>0)
        {
            R r = R.ok();
            return JSON.toJSONString(r);
        }


        R r = R.error();

        return JSON.toJSONString(r);


    }




//
//    @PostMapping("quantity")
////   查
//    public String updatequantity(@RequestParam int id,@RequestParam int quantity){
//
//
//        UpdateWrapper<shoppingcart> updateWrapper = new UpdateWrapper<shoppingcart>();
////修改语句
//        updateWrapper.set("quantity", quantity);
//
////        updateWrapper.eq("id",id);
//        shoppingcart cart = cartMapper.selectById(id);
//
//
//       int update = cartMapper.update(cart,updateWrapper);
//
//        if( update > 0) {
//            R r = R.ok();
//
//            return JSON.toJSONString(r);
//        }
//        R r = R.error();
//
//        return JSON.toJSONString(r);
//
//
//    }

}
