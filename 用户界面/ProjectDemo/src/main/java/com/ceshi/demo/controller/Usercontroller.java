package com.ceshi.demo.controller;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ceshi.demo.bean.login;
//import com.chinahitech.springbootmp.bean.EleUser;
//import com.chinahitech.springbootmp.mapper.UserMapper;
//import org.springframework.beans.factory.annotation.Autowired;
import com.ceshi.demo.bean.user;
import com.ceshi.demo.mapper.UserMapper;
import com.ceshi.demo.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/user")
@CrossOrigin
public class Usercontroller {

    @Autowired
    private UserMapper userMapper;
    //   {username:zhangsan,password:123}
    @PostMapping("login")
//  前端传入的数据是JSON格式时，需要使用@RequestBody，并使用对象接收
    public String login(@RequestBody login user){
        System.out.println(user.getUsername());
        System.out.println(user.getPassword());

        QueryWrapper<user> query =new QueryWrapper<user>();

        // 多个条件
        query.eq("username",user.getUsername()).and(i->i.eq("password",user.getPassword()));

        // and 条件 i相当于 query
//        query.lt("id",3).and(i->i.eq("name","张三"));
       List<user> list =userMapper.selectList(query);

       if(list.size()==1)
       {
           R r = R.ok().data("token",list.get(0).getId());

           return JSON.toJSONString(r);
       }
       return JSON.toJSONString(R.error());

    }

    //@RequestParam 只能接收  &符号连接的数据  name=zhangsan&age=lisi
    @GetMapping("info")
    public String getUserInfo(@RequestParam  String token){

        R r = R.ok().data("name",userMapper.selectById(token).getUsername());

        r.data("avatar","https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif");
        return JSON.toJSONString(r);

    }


    @GetMapping("all")
//   查
    public String getusers(){

        List list = userMapper.selectList(null);
        R r = R.ok().data("items",list);

        return JSON.toJSONString(r);
//        return "测试";
    }

    @GetMapping("get")
//   查
    public String getidusers(@RequestParam int id){

//        QueryWrapper<emp> query =new QueryWrapper<emp>();
//
//        // 多个条件
//        query.eq("empno",eno);

        user user = userMapper.selectById(id);

        R r = R.ok().data("user",user);

        return JSON.toJSONString(r);
    }

    @GetMapping("name")
//   查
    public String getnameusers(@RequestParam String username){

        QueryWrapper<user> query =new QueryWrapper<user>();

        // 多个条件
        query.eq("username",username);

      List list = userMapper.selectList(query);
      if(!(list.size() ==0))
      {
          R r = R.ok().data("repeat","repeat");
          return JSON.toJSONString(r);
      }


        R r = R.ok().data("repeat","norepeat");
        return JSON.toJSONString(r);
    }

    @PostMapping("add")
//   增
    public String addusers(@RequestBody user add){
//@RequestParam int eno,@RequestParam String ename,@RequestParam String job,@RequestParam double salary
        // select * from user (对象和表名一致 对应） ：查表
        // User person = new User() 创建对象


        int tian = userMapper.insert(add);
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
    public String delusers(@RequestParam int id){


        int shan = userMapper.deleteById(id);

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
    public String updatebyid(@RequestBody user update){

        // select * from user (对象和表名一致 对应） ：查表
        // User person = new User() 创建对象
//        UpdateWrapper<emp> updatebyid = new UpdateWrapper<emp>();
//        updatebyid.eq("empno",id);




        if(  this.userMapper.updateById(update) >0)
        {
            R r = R.ok();
            return JSON.toJSONString(r);
        }


        R r = R.error();

        return JSON.toJSONString(r);

    }
}
