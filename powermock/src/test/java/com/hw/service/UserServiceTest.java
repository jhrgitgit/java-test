package com.hw.service;

import com.common.User;
import com.hw.dao.UserDao;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.powermock.api.mockito.PowerMockito;

public class UserServiceTest {
    @Mock
    private UserDao userDao;

    @Test
    public  void testQueryCountWithPowerMock(){
        UserDao dao = PowerMockito.mock(UserDao.class);
//        PowerMockito.doReturn(10).when(dao).getCount();
        PowerMockito.when(dao.getCount()).thenReturn(10);
        UserService userService = new UserService(dao);
        int result = userService.queryUserCount();
        Assert.assertEquals(10,result);
    }

    @Test
    public  void testSaveUserWithPowerMock(){
        UserDao dao = PowerMockito.mock(UserDao.class);
        User user = new User();
        PowerMockito.doNothing().when(dao).insertUser(user);
        UserService userService = new UserService(dao);
        userService.saveUser(user);

        Mockito.verify(dao).insertUser(user);
    }


    @Ignore
    @Test
    public  void testQueryCountWithMockito(){
        MockitoAnnotations.initMocks(this);
        UserService userService = new UserService(userDao);
        Mockito.when(userDao.getCount()).thenReturn(10);

        int result = userService.queryUserCount();
        Assert.assertEquals(10,result);


    }
}
