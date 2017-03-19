package cn.baochao.dto;

import java.io.Serializable;

/**
 * Created by huangbaochao on 2017/3/19 $version 1.0.
 */
public class PhoneDto implements Serializable{

    private int id;

    //颜色
    private String color;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "PhoneDto{" +
                "id=" + id +
                ", color='" + color + '\'' +
                '}';
    }

