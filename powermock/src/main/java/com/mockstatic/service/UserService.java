package com.mockstatic.service;

import com.common.User;
import com.mockstatic.dao.UserDao;

public class UserService {


    public int queryUserCount() {
        return UserDao.getCount();
    }

    public void saveUser(User user) {
        UserDao.insertUser(user);
    }
}
