package com.snap.food.model.domain;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

public class User implements Serializable, Entity<Integer> {

    private Integer id;
    private String username;
    private String name;
    private String family;
    private String address;
    private String phone;
    private List<Integer> orderIds;


    @Override
    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public Class entityType() {
        return User.class;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFamily() {
        return family;
    }

    public void setFamily(String family) {
        this.family = family;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public List<Integer> getOrderIds() {
        return orderIds;
    }

    public void setOrderIds(List<Integer> orderIds) {
        this.orderIds = orderIds;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", name='" + name + '\'' +
                ", family='" + family + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", orderIds=" + orderIds +
                '}';
    }
}
