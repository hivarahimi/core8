package com.snap.food.model.domain;

import java.io.Serializable;

public class Food  implements Serializable, Entity<Integer> {
    private Integer id;
    private String foodName;
    private Integer price;

    @Override
    public Integer getId() {
        return this.id;
    }

    @Override
    public Class entityType() {
        return Food.class;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }
}
