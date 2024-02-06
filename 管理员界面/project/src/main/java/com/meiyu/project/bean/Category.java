package com.meiyu.project.bean;

import com.baomidou.mybatisplus.annotation.TableId;

public class Category {
    @TableId
    private int id;
    private String name;
    private int status;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getStatus() {
        return status;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
