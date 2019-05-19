package com.mockfinal.service;

import com.mockfinal.dao.UserDao;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

/**
 * 测试final
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest({UserService.class,UserDao.class})
public class UserServiceTest {


    @Test
    public void testQueryCount() {
        UserDao userDao = PowerMockito.mock(UserDao.class);
//        PowerMockito.doReturn(10).when(dao).getCount();
        PowerMockito.when(userDao.getCount()).thenReturn(10);
        UserService userService = new UserService(userDao);
        int result = userService.queryUserCount();
        Assert.assertEquals(10, result);
    }

    /*@Test
    public void testSaveUser() {
        PowerMockito.mockStatic(UserDao.class);
        User user = new User();
        PowerMockito.doNothing().when(UserDao.class);
        UserService userService = new UserService();
        userService.saveUser(user);

        PowerMockito.verifyStatic();

    }*/


}
