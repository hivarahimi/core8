package com.snap.food.controller;

import com.snap.food.exception.AlreadyExistException;
import com.snap.food.exception.NotFoundException;
import com.snap.food.model.dao.FoodDao;
import com.snap.food.model.dao.OrderDao;
import com.snap.food.model.dao.UserDao;
import com.snap.food.model.domain.User;

import java.io.IOException;

public class UserService {

    UserDao userDao;
    FoodDao foodDao ;
    OrderDao orderDao ;

    private IdGenerator idGenerator;

    public UserService(UserDao userDao, FoodDao foodDao, OrderDao orderDao, IdGenerator idGenerator) {
        this.userDao = userDao;
        this.foodDao = foodDao;
        this.orderDao = orderDao;
        this.idGenerator = idGenerator;
    }

    public User login(int id) throws NotFoundException {
        return userDao.getById(id);
    }

    public User register(User user) throws IOException, AlreadyExistException {
        return userDao.create(user);
    }
}
