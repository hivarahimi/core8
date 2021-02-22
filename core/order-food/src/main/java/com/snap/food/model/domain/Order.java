package com.snap.food.model.domain;

import java.io.Serializable;
import java.time.Instant;

public class Order  implements Serializable, Entity<Integer> {

    private Integer id;
    private Instant registerDate;
    private Integer userId;
    private Integer foodId;

    @Override
    public Integer getId() {
        return null;
    }

    @Override
    public Class entityType() {
        return Order.class;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Instant getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(Instant registerDate) {
        this.registerDate = registerDate;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getFoodId() {
        return foodId;
    }

    public void setFoodId(Integer foodId) {
        this.foodId = foodId;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", registerDate=" + registerDate +
                ", userId=" + userId +
                ", foodId=" + foodId +
                '}';
    }
}
