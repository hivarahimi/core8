package com.snap.food.model.dao;

import com.snap.food.model.domain.User;

import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.stream.Collectors;

public class UserDao extends Dao<Integer, User>{

    private static final File U_FILE = new File("C:\\Users\\users.data");

    public UserDao() throws IOException, ClassNotFoundException {
        super(U_FILE);
    }

    public Collection<User> getByName(String name) {

        return getAll().stream()
                .filter(user -> user.getName().contains(name))
                .collect(Collectors.toList());
    }
}
