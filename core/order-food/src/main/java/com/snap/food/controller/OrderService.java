package com.snap.food.controller;

import com.snap.food.exception.AlreadyExistException;
import com.snap.food.model.dao.FoodDao;
import com.snap.food.model.dao.OrderDao;
import com.snap.food.model.dao.UserDao;
import com.snap.food.model.domain.Order;
import com.snap.food.model.domain.User;

import java.io.IOException;

public class OrderService {
    UserDao userDao;
    FoodDao foodDao ;
    OrderDao orderDao ;

    private IdGenerator idGenerator;

    public OrderService(UserDao userDao, FoodDao foodDao, OrderDao orderDao, IdGenerator idGenerator) {
        this.userDao = userDao;
        this.foodDao = foodDao;
        this.orderDao = orderDao;
        this.idGenerator = idGenerator;
    }
    public Order register(Order order) throws IOException, AlreadyExistException {
        return orderDao.create(order);
    }
}
