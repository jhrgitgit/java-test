package com.matcher.service;

import com.matcher.dao.UserDao;

public class UserService {


    public String queryByName(String username) {
        UserDao userDao = new UserDao();
        return userDao.query(username);
    }
}
