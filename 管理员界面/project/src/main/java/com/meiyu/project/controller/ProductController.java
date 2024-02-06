package com.meiyu.project.controller;


import com.alibaba.fastjson.JSON;
import com.meiyu.project.bean.Orders;
import com.meiyu.project.bean.Product;
import com.meiyu.project.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/product")
@CrossOrigin
public class ProductController {
    @Autowired
    private ProductMapper productMapper;

    @PostMapping("/list")
    public String listProducts() {
        List<Product> list = productMapper.selectList(null);
        Map map = new HashMap();
        map.put("code", 20000);
        map.put("data", list);
//        System.out.println(list.get(1).getId());
//        System.out.println(list.get(1).getName());
//        System.out.println(list.get(1).getImage());
        return JSON.toJSONString(map);
    }

    @PostMapping("/delete")
    public String deleteProduct(@RequestBody Product product) {
        int num = productMapper.deleteById(product.getId());
        Map map = new HashMap();
        map.put("code", 20000);
        map.put("data", num);
        return JSON.toJSONString(map);
    }

    @PostMapping("/add")
    public String addProduct(@RequestBody Product product) {
        int num = productMapper.insert(product);
        Map map = new HashMap();
        map.put("code", 20000);
        map.put("data", num);
        return JSON.toJSONString(map);
    }

    @GetMapping("/searchByCategory")
    public String searchByCategory(@RequestParam int categoryId) {
        Map<String,Object> cmap = new HashMap<>();
        cmap.put("category_id", categoryId);
        List<Product> list = productMapper.selectByMap(cmap);
        Map map = new HashMap();
        map.put("code",20000);
        map.put("data",list);
        return JSON.toJSONString(map);
    }

    @PostMapping("/modify")
    public String modifyById(@RequestBody Product product) {
        int num = productMapper.updateById(product);
        Map map = new HashMap();
        map.put("code", 20000);
        map.put("data", product);
        return JSON.toJSONString(map);
    }

    @GetMapping("/get")
    public String getById(@RequestParam int id) {
        Product product = productMapper.selectById(id);
        Map map = new HashMap();
        map.put("code", 20000);
        map.put("data", product);
        return JSON.toJSONString(map);
    }

    @GetMapping("/getCategory")
    public String getCategory(int productId) {
        Product product = productMapper.selectById(productId);
        int categoryId = product.getCategoryId();
        Map map = new HashMap();
        map.put("code", 20000);
        map.put("data", categoryId);
        return JSON.toJSONString(map);
    }
}
