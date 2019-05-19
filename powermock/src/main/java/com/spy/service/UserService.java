package com.spy.service;

import com.spy.dao.UserDao;

public class UserService {


    public void foo(String arg) {
        log();
    }

    private void log() {
        System.out.println("I am console log.");
    }


    public boolean exist(String username) {
        return checkExist(username);
    }


    public boolean checkExist(String username) {
        throw new UnsupportedOperationException();
    }
}
