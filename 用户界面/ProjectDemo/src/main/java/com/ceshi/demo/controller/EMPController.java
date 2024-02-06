package com.ceshi.demo.controller;


import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.ceshi.demo.bean.emp;
import com.ceshi.demo.mapper.EmpMapper;
import com.ceshi.demo.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
//跨域
@RequestMapping("/emp")
public class EMPController {
    @Autowired
    private EmpMapper empMapper;
    @GetMapping("all")
//   查
    public String getEmps(){

        List list = empMapper.selectList(null);
        R r = R.ok().data("items",list);

        return JSON.toJSONString(r);
//        return "测试";
    }

    @GetMapping("get")
//   查
    public String getidEmps(@RequestParam int eno){

//        QueryWrapper<emp> query =new QueryWrapper<emp>();
//
//        // 多个条件
//        query.eq("empno",eno);

       emp EMP = empMapper.selectById(eno);

        R r = R.ok().data("emp",EMP);

        return JSON.toJSONString(r);
    }


    @PostMapping("add")
//   增
    public String addEmps(@RequestBody emp add){
//@RequestParam int eno,@RequestParam String ename,@RequestParam String job,@RequestParam double salary
        // select * from user (对象和表名一致 对应） ：查表
        // User person = new User() 创建对象


        int tian = empMapper.insert(add);
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
    public String delEmps(@RequestParam int eno){


        UpdateWrapper<emp> delbyid = new UpdateWrapper<emp>();
        delbyid.eq("empno",eno);

        int shan = empMapper.delete(delbyid);

        if(shan > 0) {
            R r = R.ok();

            return JSON.toJSONString(r);
        }
        R r = R.error();

        return JSON.toJSONString(r);

    }


//    @GetMapping("eno")
////   增
//    public String enos(){
//
//        List list = (empMapper.selectList(null)).;
////        R r = R.ok().data("items",list);
//
//        return JSON.toJSONString();
////
//
//
//    }


    @PostMapping(value = "/update")
    public String updatebyid(@RequestBody emp update){

        // select * from user (对象和表名一致 对应） ：查表
        // User person = new User() 创建对象
//        UpdateWrapper<emp> updatebyid = new UpdateWrapper<emp>();
//        updatebyid.eq("empno",id);




        if(  this.empMapper.updateById(update) >0)
        {
            R r = R.ok();
            return JSON.toJSONString(r);
        }


        R r = R.error();

        return JSON.toJSONString(r);

    }
}
