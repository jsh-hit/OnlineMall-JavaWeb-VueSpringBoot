package com.meiyu.project.controller;

import com.alibaba.fastjson.JSON;
import com.meiyu.project.bean.Category;
import com.meiyu.project.mapper.CategoryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/category")
@CrossOrigin
public class CategoryController {
    @Autowired
    private CategoryMapper categoryMapper;

    @PostMapping("/list")
    public String listCategories() {
        List<Category> list = categoryMapper.selectList(null);
        Map map = new HashMap();
        map.put("code", 20000);
        map.put("data", list);
        return JSON.toJSONString(map);
    }

    @PostMapping("/delete")
    public String deleteCategory(@RequestBody Category category) {
        int num = categoryMapper.deleteById(category.getId());
        Map map = new HashMap();
        map.put("code", 20000);
        map.put("data", num);
        return JSON.toJSONString(map);
    }

    @PostMapping("/add")
    public String addCategory(@RequestBody Category category) {
        int num = categoryMapper.insert(category);
        Map map = new HashMap();
        map.put("code", 20000);
        map.put("data", num);
        return JSON.toJSONString(map);
    }

    @PostMapping("/modify")
    public String modifyCategory(@RequestBody Category category) {
        int num = categoryMapper.updateById(category);
        Map map = new HashMap();
        map.put("code", 20000);
        map.put("data", category);
        return JSON.toJSONString(map);
    }

    @GetMapping("/calculate")
    public String calculateCategories() {
        int count = 0;
        List<Category> list = categoryMapper.selectList(null);
        for (Category c : list) {
            if (c.getStatus() == 1) {
                count++;
            }
        }
        Map map = new HashMap();
        map.put("code", 20000);
        map.put("data", count);
        return JSON.toJSONString(map);
    }

    @GetMapping("/getName")
    public String getCategoryName(int id) {
        Category category = categoryMapper.selectById(id);
        String name = category.getName();
        Map map = new HashMap();
        map.put("code", 20000);
        map.put("data", name);
        return JSON.toJSONString(map);
    }
}
