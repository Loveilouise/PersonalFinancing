package com.example.louise.personalfinancing.model;

import java.io.Serializable;

/**
 * Created by Louise喵 on 2019/4/19.
 */

public class UserOut implements Serializable {
    private int id;
    private String money,category,note,time,password;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getMoney() {
        return money;
    }

    public void setMoney(String money) {
        this.money = money;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }


    @Override
    public String toString() {
        return "UserOut{" +
                "id=" + id +
                ",category='" +category + '\'' +
                ",money='" + money + '\'' +
                ", time=" + time  +'\'' +
                ", note=" + note+
                ", password=" +password +'}';
    }

}
