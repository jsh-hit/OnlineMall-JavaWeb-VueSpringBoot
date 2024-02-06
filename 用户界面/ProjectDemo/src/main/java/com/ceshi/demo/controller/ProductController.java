package com.ceshi.demo.controller;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ceshi.demo.bean.product;
import com.ceshi.demo.mapper.ProductMapper;
import com.ceshi.demo.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
//跨域
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductMapper ProductMapper;
    @GetMapping("all")
//   查
    public String getProducts(){

        List list = ProductMapper.selectList(null);
        R r = R.ok().data("items",list);

        return JSON.toJSONString(r);
//        return "测试";
    }

    @GetMapping("get")
//   查
    public String getidProducts(@RequestParam int id){

//        QueryWrapper<emp> query =new QueryWrapper<emp>();
//
//        // 多个条件
//        query.eq("empno",eno);

        product product = ProductMapper.selectById(id);

        R r = R.ok().data("product",product);

        return JSON.toJSONString(r);
    }




    @GetMapping("hot")
//   查
    public String gethotProducts(){

        QueryWrapper<product> query =new QueryWrapper<product>();

        // 多个条件

        String sql="SELECT * FROM product ORDER BY sales DESC LIMIT 10";
        List<product> product=this.ProductMapper.queryByCondition(sql);

        R r = R.ok().data("product",product);


        return JSON.toJSONString(r);
    }

    @GetMapping("search")
//   查
    public String searchProducts(@RequestParam String search){



        QueryWrapper<product> query =new QueryWrapper<product>();

        // 多个条件

        String sql="SELECT * FROM product where name like '%"+search+"%'";
        List<product> product=this.ProductMapper.queryByCondition(sql);

        R r = R.ok().data("product",product);


        return JSON.toJSONString(r);
    }

    @GetMapping("category")
//   查
    public String categoryProducts(@RequestParam String category){




        String sql="SELECT product.id,product.status,product.category_id,product.name,product.subtitle," +
                "product.image,product.price,product.stock,product.detail,product.store_id,product.sales" +
                " FROM category,product where category.name ='"+category+" '"+
                " and category.id=product.category_id";

       List<product> list =this.ProductMapper.queryByCondition(sql);

        R r = R.ok().data("product",list);


        return JSON.toJSONString(r);
    }

    @PostMapping("add")
//   增
    public String addProduct(@RequestBody product add){
//@RequestParam int eno,@RequestParam String ename,@RequestParam String job,@RequestParam double salary
        // select * from user (对象和表名一致 对应） ：查表
        // User person = new User() 创建对象


        int tian = ProductMapper.insert(add);
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
    public String delProduct(@RequestParam int id){

        int shan = ProductMapper.deleteById(id);

        if(shan > 0) {
            R r = R.ok();

            return JSON.toJSONString(r);
        }
        R r = R.error();

        return JSON.toJSONString(r);

    }




    @PostMapping(value = "/update")
    public String updatebyid(@RequestBody product update){





        if(  this.ProductMapper.updateById(update) >0)
        {
            R r = R.ok();
            return JSON.toJSONString(r);
        }


        R r = R.error();

        return JSON.toJSONString(r);

    }
}
