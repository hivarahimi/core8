package com.snap.food.model.dao;

import com.snap.food.model.domain.Food;
import com.snap.food.model.domain.Order;

import java.io.File;
import java.io.IOException;

public class OrderDao extends Dao<Integer, Order> {

    private static final File O_FILE = new File("C:\\Users\\orders.data");

    public OrderDao() throws IOException, ClassNotFoundException {
        super(O_FILE);
    }
}
