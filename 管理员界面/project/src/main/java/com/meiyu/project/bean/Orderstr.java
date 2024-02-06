package com.meiyu.project.bean;

public class Orderstr {
    private int id;
    private int productId;
    private int userId;
    private int shippingId;
    private double payment;
    private int postage;
    private int status;
    private String payTime;
    private int storeId;
    private String logisticsCompany;
    private int quantity;

    public void setId(int id) {
        this.id = id;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setShippingId(int shippingId) {
        this.shippingId = shippingId;
    }

    public void setPayment(double payment) {
        this.payment = payment;
    }

    public void setPostage(int postage) {
        this.postage = postage;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public void setPayTime(String payTime) {
        this.payTime = payTime;
    }

    public void setStoreId(int storeId) {
        this.storeId = storeId;
    }

    public void setLogisticsCompany(String logisticsCompany) {
        this.logisticsCompany = logisticsCompany;
    }

    public int getId() {
        return id;
    }

    public int getProductId() {
        return productId;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getUserId() {
        return userId;
    }

    public int getShippingId() {
        return shippingId;
    }

    public double getPayment() {
        return payment;
    }

    public int getPostage() {
        return postage;
    }

    public int getStatus() {
        return status;
    }

    public String getPayTime() {
        return payTime;
    }

    public int getStoreId() {
        return storeId;
    }

    public String getLogisticsCompany() {
        return logisticsCompany;
    }

    public int getQuantity() {
        return quantity;
    }
}
