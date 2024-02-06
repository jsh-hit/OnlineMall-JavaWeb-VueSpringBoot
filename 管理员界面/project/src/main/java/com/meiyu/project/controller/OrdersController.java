package com.meiyu.project.controller;

import com.alibaba.fastjson.JSON;
import com.meiyu.project.bean.Orders;
import com.meiyu.project.bean.Orderstr;
import com.meiyu.project.mapper.OrdersMapper;
import com.sun.org.apache.xpath.internal.operations.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@RestController
@RequestMapping("/orders")
@CrossOrigin
public class OrdersController {
    @Autowired
    private OrdersMapper ordersMapper;

    @GetMapping("/list")
    private String listOrders() {
        List<Orders> list = ordersMapper.selectList(null);
        List<Orderstr> listr = new ArrayList<>();
        for (Orders orders : list) {
            Orderstr orderstr = new Orderstr();
            orderstr.setId(orders.getId());
            orderstr.setProductId(orders.getProductId());
            orderstr.setUserId(orders.getUserId());
            orderstr.setShippingId(orders.getShippingId());
            orderstr.setPayment(orders.getPayment());
            orderstr.setPostage(orders.getPostage());
            orderstr.setStatus(orders.getStatus());
            orderstr.setStoreId(orders.getStoreId());
            orderstr.setLogisticsCompany(orders.getLogisticsCompany());
            orderstr.setQuantity(orders.getQuantity());
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String date = formatter.format(orders.getPayTime());
            orderstr.setPayTime(date);
            listr.add(orderstr);
        }
        Map map = new HashMap();
        map.put("code", 20000);
        map.put("data", listr);
        return JSON.toJSONString(map);
    }

    @PostMapping("/delete")
    private String deleteOrders(@RequestBody Orderstr orderstr) {
        int num = ordersMapper.deleteById(orderstr.getId());
        Map map = new HashMap();
        map.put("code", 20000);
        map.put("data", num);
        return JSON.toJSONString(map);
    }

    @PostMapping("/modify")
    private String modifyOrders(@RequestBody Orderstr orderstr) throws ParseException {
        Orders orders = new Orders();
        orders.setId(orderstr.getId());
        orders.setProductId(orderstr.getProductId());
        orders.setUserId(orderstr.getUserId());
        orders.setShippingId(orderstr.getShippingId());
        orders.setPayment(orderstr.getPayment());
        orders.setPostage(orderstr.getPostage());
        orders.setStatus(orderstr.getStatus());
        orders.setStoreId(orderstr.getStoreId());
        orders.setLogisticsCompany(orderstr.getLogisticsCompany());
        SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = sdf.parse(orderstr.getPayTime());
        orders.setPayTime(date);
        int num = ordersMapper.updateById(orders);
        Map map = new HashMap();
        map.put("code", 20000);
        map.put("data", orderstr);
        return JSON.toJSONString(map);
    }

    @GetMapping("calculate")
    public String calculateMoney() {
        List<Orders> list = ordersMapper.selectList(null);
        double money = 0;
        for (Orders orders : list) {
            money += orders.getPayment();
        }
        Map map = new HashMap();
        map.put("code", 20000);
        map.put("data", money);
        return JSON.toJSONString(map);
    }
}
