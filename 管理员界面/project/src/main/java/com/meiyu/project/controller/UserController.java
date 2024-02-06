package com.meiyu.project.controller;

import com.alibaba.fastjson.JSON;
import com.meiyu.project.bean.LogInfo;
import com.meiyu.project.bean.User;
import com.meiyu.project.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user")
@CrossOrigin
public class UserController {
    @Autowired
    private UserMapper userMapper;

    @PostMapping("/login")
    public String login(@RequestBody LogInfo logInfo) {
        Map map = new HashMap();
        Map<String,Object> nmap = new HashMap<>();
        nmap.put("username", logInfo.getUsername());
        List<User> list = userMapper.selectByMap(nmap);
        for (User u: list) {
            if (u.getPassword().equals(logInfo.getPassword())) {
                map.put("code",20000);
                break;
            }
            else{
                map.put("code",20001);
            }
        }
        HashMap token = new HashMap<>();
        token.put("token",logInfo.getUsername());
        map.put("data",token);
        map.put("info",logInfo);
        return JSON.toJSONString(map);
    }

    @GetMapping("/valid")
    public String validUsername(@RequestParam String str) {
        Map<String, Object> umap = new HashMap<>();
        umap.put("role", 0);
        List<User> list = userMapper.selectByMap(umap);
        boolean flag = false;
        for (User u: list) {
            if (u.getUsername().equals(str)) {
                flag = true;
            }
        }
        Map map = new HashMap();
        map.put("code", 20000);
        map.put("data", flag);
        return JSON.toJSONString(map);
    }

    @GetMapping("/info")
    public String getInfo(@RequestParam String token){
        HashMap map = new HashMap<>();
        map.put("code",20000);

        HashMap data = new HashMap<>();
        data.put("name","后台管理系统");
        data.put("avatar","http://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif");
        map.put("code",20000);
        map.put("data",data);

        return JSON.toJSONString(map);
    }
    @PostMapping("/get")
    public String getUserInfo(@RequestBody LogInfo logInfo){
        Map map = new HashMap();
        Map<String,Object> nmap = new HashMap<>();
        nmap.put("username", logInfo.getUsername());
        List<User> list = userMapper.selectByMap(nmap);
        User user = new User();
        for (User u: list){
            if (u.getPassword().equals(logInfo.getPassword())){
                user = u;
                break;
            }
        }
        map.put("code",20000);
        map.put("info",user);
        return JSON.toJSONString(map);
    }

    @GetMapping("/getById")
    public String getUserInfoById(@RequestParam int id){
        User user = userMapper.selectById(id);
        Map map = new HashMap();
        map.put("code",20000);
        map.put("data",user);
        return JSON.toJSONString(map);
    }

    @GetMapping("/admin")
    public String sendAdminInfo(@RequestParam String username) {
        Map<String, Object> pmap = new HashMap<>();
        pmap.put("username",username);
        List<User> list = userMapper.selectByMap(pmap);
        User user = new User();
        if (list.size()>0) {
            user = list.get(0);
        }
        Map map = new HashMap();
        map.put("code",20000);
        map.put("data",user);
        return JSON.toJSONString(map);
    }

    @PostMapping("/modify")
    public String modifyUser(@RequestBody User user) {
        int num = userMapper.updateById(user);
        Map map = new HashMap();
        map.put("code",20000);
        map.put("data",user);
        return JSON.toJSONString(map);
    }

    @PostMapping("/list")
    public String listUsers() {
        List<User> list = userMapper.selectList(null);
        Map map = new HashMap();
        map.put("code", 20000);
        map.put("data", list);
        return JSON.toJSONString(map);
    }

    @PostMapping("/delete")
    public String deletUser(@RequestBody User user) {
        int num = userMapper.deleteById(user.getId());
        Map map = new HashMap();
        map.put("code", 20000);
        map.put("data", num);
        return JSON.toJSONString(map);
    }

    @PostMapping("/add")
    public String addUser(@RequestBody User user) {
        int num = userMapper.insert(user);
        Map map = new HashMap();
        map.put("code", 20000);
        map.put("data", num);
        return JSON.toJSONString(map);
    }

    @GetMapping("/calculate")
    public String calculateUsers() {
        List<User> list = userMapper.selectList(null);
        int num = list.size();
        Map map = new HashMap();
        map.put("code", 20000);
        map.put("data", num);
        return JSON.toJSONString(map);
    }
}
