package com.ceshi.demo.bean;

public class product {

    private  int id;
    private int status ;
    private int category_id;
    private String name;
    private String subtitle;
    private String image;
    private double price;
    private int stock;
    private String  detail;
    private  int  store_id;
    private int sales;

    public product(int id, int status, int category_id, String name, String subtitle, String image, double price, int stock, String detail, int store_id, int sales) {
        this.id = id;
        this.status = status;
        this.category_id = category_id;
        this.name = name;
        this.subtitle = subtitle;
        this.image = image;
        this.price = price;
        this.stock = stock;
        this.detail = detail;
        this.store_id = store_id;
        this.sales = sales;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getCategory_id() {
        return category_id;
    }

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public int getStore_id() {
        return store_id;
    }

    public void setStore_id(int store_id) {
        this.store_id = store_id;
    }

    public int getSales() {
        return sales;
    }

    public void setSales(int sales) {
        this.sales = sales;
    }
}

