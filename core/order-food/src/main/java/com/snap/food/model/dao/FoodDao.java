package com.snap.food.model.dao;

import com.snap.food.model.domain.Food;
import com.snap.food.model.domain.User;

import java.io.File;
import java.io.IOException;

public class FoodDao extends Dao<Integer, Food> {

    private static final File F_FILE = new File("C:\\Users\\foods.data");

    public FoodDao() throws IOException, ClassNotFoundException {
        super(F_FILE);
    }
}
