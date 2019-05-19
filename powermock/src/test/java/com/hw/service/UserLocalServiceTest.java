package com.hw.service;

import com.common.User;
import com.hw.dao.UserDao;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.junit.Assert.fail;
import static org.powermock.api.mockito.PowerMockito.*;

/**
 * mock 局部变量
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest({UserLocalService.class})
public class UserLocalServiceTest {

    @Test
    public void testQueryUserCount() {
        try {
            UserLocalService userService = new UserLocalService();
            UserDao userDao = mock(UserDao.class);
            whenNew(UserDao.class).withNoArguments().thenReturn(userDao);
            doReturn(10).when(userDao).getCount();
            int result = userService.queryUserCount();
            Assert.assertEquals(10, result);
        } catch (Exception e) {
            fail();
            e.printStackTrace();
        }
    }

    @Test
    public  void testSaveUser(){
        try {
            User user = new User();
            UserLocalService userService = new UserLocalService();
            UserDao userDao = mock(UserDao.class);
            whenNew(UserDao.class).withAnyArguments().thenReturn(userDao);
            doNothing().when(userDao).insertUser(user);
            userService.saveUser(user);

            Mockito.verify(userDao,Mockito.times(1)).insertUser(user);
        } catch (Exception e) {
            fail();
            e.printStackTrace();
        }
    }

}
