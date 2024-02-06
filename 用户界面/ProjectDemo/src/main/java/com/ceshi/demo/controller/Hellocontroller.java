package com.ceshi.demo.controller;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ceshi.demo.bean.user;
import com.ceshi.demo.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/hello")
// 解决前端跨域请求问题
@CrossOrigin
public class Hellocontroller {

    @Autowired // 自动注入
    private UserMapper userMapper;


    // 访问地址（本地）: http://localhost:8080/ceshi
    // http://baidu.com
    @GetMapping(value = "/get")
    public String testGet(){
        return "测试GetMapping....";
    }
    @PostMapping(value = "/post")
    public String testPost(){
        return "测试PostMapping.....";
    }
    @PutMapping(value = "/put")
    public String testPut(){
        return "测试PutMapping.....";
    }
    @DeleteMapping(value = "/del")
    public String testDelete(){
        return "测试DeleteMapping.....";
    }
    @PatchMapping (value = "/patch")
    public String testPatch(){
        return "测试PatchMapping.....";
    }
    @RequestMapping (value = "/req",method = RequestMethod.GET)
    public String testRequest(){
        return "测试RequestMapping.....";
    }

    @RequestMapping(value="/login",method=RequestMethod.POST)
    public String login(@RequestParam String name,@RequestParam String
            pwd){
        return "接收的账号:"+name+",密码:"+pwd;
    }
    //根据姓氏查询用户列表信息
    @RequestMapping(value="/query")
    public String queryUsers(@RequestParam(value="uname",required =
            false,defaultValue = "张") String userName){
        return "参数："+userName;
    }
    //根据id查询用户详情
    @RequestMapping(value="/detail/{id}",method= RequestMethod.GET)
    public String queryDetail(@PathVariable String id){
        return "接收到的参数是："+id;
    }

    @ResponseBody
    @RequestMapping(value="/queryAll",method = RequestMethod.GET)
    public String getData(){
//封装查询结果
        Map<String,Object> map = new HashMap<String,Object>();
        try{
            map.put("status",200);
//查询的用户列表数据
//            List<t_product> userList = new ArrayList<t_product>();
//            userList.add(new t_product(1001,"admin"));
//            userList.add(new t_product(1002,"jains"));
//            userList.add(new t_product(1003,"tony"));
//            map.put("data",userList);
        }catch (Exception ex){
            map.put("status",500);
            map.put("data",null);
        }
        return JSON.toJSONString(map);
    }


    @GetMapping(value = "/mapper")
    public String testmapper(){

   // select * from user (对象和表名一致 对应） ：查表
        // User person = new User() 创建对象
        // QueryWrapper 查询条件 sql语句
        QueryWrapper<user> query =new QueryWrapper<user>();

        // 多个条件
        query.lt("id",3).or().eq("name","张三");

        // and 条件 i相当于 query
//        query.lt("id",3).and(i->i.eq("name","张三"));
        List<user> l=userMapper.selectList(query);
        return  JSON.toJSONString(l);

    }

    @GetMapping(value = "/delbyId")
    public String delbuid(@RequestParam int id){

        // select * from user (对象和表名一致 对应） ：查表
        // User person = new User() 创建对象
       int shan = userMapper.deleteById(id);
       if(shan > 0) {
           return "删除成功";
       }
        return "删除失败，无对应id值";

    }

    @GetMapping(value = "/add")
    public String add(){

        // select * from user (对象和表名一致 对应） ：查表
        // User person = new User() 创建对象
//        User add = new User(null,null,null,null, null, null);
//        int tian = userMapper.insert(add);
//        if(tian > 0) {
//            return "添加成功";
//        }
        return "添加失败";

    }


    @GetMapping(value = "/update")
    public String updatebyid(@RequestParam long id,@RequestParam String name){

        // select * from user (对象和表名一致 对应） ：查表
//        // User person = new User() 创建对象
//        UpdateWrapper<User> updatebyid = new UpdateWrapper<User>();
//        updatebyid.eq("id",id);



//       User add = new User(id,name,null,null);
//
//
//        if(   this.userMapper.updateById(add) >0)
//        {
//            return "根据id更新成功";
//        }
       return "根据id更新失败";





    }





}
