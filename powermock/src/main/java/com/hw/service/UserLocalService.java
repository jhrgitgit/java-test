package com.hw.service;

import com.common.User;
import com.hw.dao.UserDao;

public class UserLocalService {


    public int queryUserCount() {
        UserDao userDao = new UserDao();
        return userDao.getCount();
    }

    public void saveUser(User user) {
        UserDao userDao = new UserDao();
        userDao.insertUser(user);
    }
}
