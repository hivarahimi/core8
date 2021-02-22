package com.snap.food.controller;

import com.snap.food.model.dao.FoodDao;
import com.snap.food.model.dao.OrderDao;
import com.snap.food.model.dao.UserDao;
import com.snap.food.model.domain.Food;
import com.snap.food.model.domain.Order;
import com.snap.food.model.domain.User;

public class IdGenerator {

    private UserDao userDao;
    private OrderDao orderDao;
    private FoodDao foodDao;

    public IdGenerator(UserDao userDao, OrderDao orderDao, FoodDao foodDao) {
        this.userDao = userDao;
        this.orderDao = orderDao;
        this.foodDao = foodDao;
    }

    public int nextUserId() {
        int id = 0;
        for (User user : userDao.getAll()) {
            if (user.getId() > id)
                id = user.getId();
        }

        return id + 1;
    }

    public int nextOrderId() {
        int id = 0;

        for (Order order : orderDao.getAll()) {
            if (order.getId() > id)
                id = order.getId();
        }

        return id + 1;
    }

    public int nextFoodId() {
        int id = 0;

            for (Food food : foodDao.getAll()) {
                if (food.getId() > id)
                    id = food.getId();
            }


        return id + 1;
    }


}
