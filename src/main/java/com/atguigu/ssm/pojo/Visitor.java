package com.atguigu.ssm.pojo;

import java.sql.Time;
import java.util.Date;

public class Visitor {
    private Integer id;
    private String visName;
    private String idCard;
    private String phone;
    private String date;
    private String time;

    public Visitor() {
    }

    public Visitor(Integer id, String visName, String idCard, String phone, String date, String time) {
        this.id = id;
        this.visName = visName;
        this.idCard = idCard;
        this.phone = phone;
        this.date = date;
        this.time = time;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getVisName() {
        return visName;
    }

    public void setVisName(String visName) {
        this.visName = visName;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "Visitor{" +
                "id=" + id +
                ", visName='" + visName + '\'' +
                ", idCard='" + idCard + '\'' +
                ", phone='" + phone + '\'' +
                ", date='" + date + '\'' +
                ", time='" + time + '\'' +
                '}';
    }
}
