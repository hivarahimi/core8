package com.snap.food.controller;

import com.snap.food.exception.AlreadyExistException;
import com.snap.food.model.dao.FoodDao;
import com.snap.food.model.domain.Food;
import com.snap.food.model.domain.User;

import java.io.IOException;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class FoodService {

    FoodDao foodDao ;

    public FoodService(FoodDao foodDao) {
        this.foodDao = foodDao;
    }

    public Food register(Food food) throws IOException, AlreadyExistException {
        return foodDao.create(food);
    }

    public Collection<Food> getAll() throws AlreadyExistException {
        return foodDao.getAll();
    }
}
