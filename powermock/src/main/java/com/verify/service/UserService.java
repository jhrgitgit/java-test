package com.verify.service;

import com.common.User;
import com.verify.dao.UserDao;

public class UserService {

    public void saveOrUpdate(User user) {
        UserDao userDao = new UserDao();

        if (userDao.getCount(user) > 0) {
            userDao.updateUser();
        } else {
            userDao.insertUser(user);
        }
    }
}
