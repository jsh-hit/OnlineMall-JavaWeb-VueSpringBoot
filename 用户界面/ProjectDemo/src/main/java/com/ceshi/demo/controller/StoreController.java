package com.ceshi.demo.controller;


import com.alibaba.fastjson.JSON;
import com.ceshi.demo.bean.store;
import com.ceshi.demo.mapper.StoreMapper;
import com.ceshi.demo.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
//跨域
@RequestMapping("/store")
public class StoreController {
    @Autowired
    private com.ceshi.demo.mapper.StoreMapper storeMapper;
    @GetMapping("all")
//   查
    public String getstores(){

        List list = storeMapper.selectList(null);
        R r = R.ok().data("items",list);

        return JSON.toJSONString(r);
//        return "测试";
    }

    @GetMapping("get")
//   查
    public String getidstores(@RequestParam int id){

//        QueryWrapper<emp> query =new QueryWrapper<emp>();
//
//        // 多个条件
//        query.eq("empno",eno);

        store store = storeMapper.selectById(id);

        R r = R.ok().data("store",store);

        return JSON.toJSONString(r);
    }


    @PostMapping("add")
//   增
    public String addstore(@RequestBody store add){
//@RequestParam int eno,@RequestParam String ename,@RequestParam String job,@RequestParam double salary
        // select * from user (对象和表名一致 对应） ：查表
        // User person = new User() 创建对象


        int tian = storeMapper.insert(add);
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
    public String delstore(@RequestParam int id){

        int shan = storeMapper.deleteById(id);

        if(shan > 0) {
            R r = R.ok();

            return JSON.toJSONString(r);
        }
        R r = R.error();

        return JSON.toJSONString(r);

    }




    @PostMapping(value = "/update")
    public String updatebyid(@RequestBody store update){





        if(  this.storeMapper.updateById(update) >0)
        {
            R r = R.ok();
            return JSON.toJSONString(r);
        }


        R r = R.error();

        return JSON.toJSONString(r);

    }
}



