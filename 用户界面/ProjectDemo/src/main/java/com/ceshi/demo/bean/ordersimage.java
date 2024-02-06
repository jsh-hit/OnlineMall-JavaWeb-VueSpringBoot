package com.ceshi.demo.bean;

public class ordersimage {


    private int id;
    private int user_id;
    private  int product_id;
    private int shipping_id;
    private double payment;
    private int postage;
    private int status;
    private String pay_time;
    private int store_id;
    private String logistics_company;
    private int quantity;
    private String name;
    private String image;

    public ordersimage(int id, int user_id, int product_id, int shipping_id, double payment, int postage, int status, String pay_time, int store_id, String logistics_company, int quantity, String name, String image) {
        this.id = id;
        this.user_id = user_id;
        this.product_id = product_id;
        this.shipping_id = shipping_id;
        this.payment = payment;
        this.postage = postage;
        this.status = status;
        this.pay_time = pay_time;
        this.store_id = store_id;
        this.logistics_company = logistics_company;
        this.quantity = quantity;
        this.name = name;
        this.image = image;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public int getShipping_id() {
        return shipping_id;
    }

    public void setShipping_id(int shipping_id) {
        this.shipping_id = shipping_id;
    }

    public double getPayment() {
        return payment;
    }

    public void setPayment(double payment) {
        this.payment = payment;
    }

    public int getPostage() {
        return postage;
    }

    public void setPostage(int postage) {
        this.postage = postage;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getPay_time() {
        return pay_time;
    }

    public void setPay_time(String pay_time) {
        this.pay_time = pay_time;
    }

    public int getStore_id() {
        return store_id;
    }

    public void setStore_id(int store_id) {
        this.store_id = store_id;
    }

    public String getLogistics_company() {
        return logistics_company;
    }

    public void setLogistics_company(String logistics_company) {
        this.logistics_company = logistics_company;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
