package com.construction.service;

import com.construction.dao.UserDao;

public class UserService {


    public void save(String username, String password) {
        UserDao userDao = new UserDao(username, password);
        userDao.insert();
    }
}
