package com.hw.service;

import com.common.User;
import com.hw.dao.UserDao;

public class UserService {

    private UserDao userDao;

    public UserService (UserDao userDao){
        this.userDao = userDao;
    }


    public int queryUserCount(){
        return userDao.getCount();
    }

    public void saveUser(User user){
        userDao.insertUser(user);
    }
}
