package com.ceshi.demo.bean;

public class shipping {

    private int id;
    private  String user_id;
    private String name;
    private String phone;
    private String address;

    public shipping(int id, String user_id, String name, String phone, String address) {
        this.id = id;
        this.user_id = user_id;
        this.name = name;
        this.phone = phone;
        this.address = address;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
