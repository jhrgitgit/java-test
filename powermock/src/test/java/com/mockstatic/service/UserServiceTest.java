package com.mockstatic.service;

import com.common.User;
import com.mockstatic.dao.UserDao;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

/**
 * 测试静态
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest({UserService.class, UserDao.class})
public class UserServiceTest {

    @Test
    public void testQueryCount() {
        PowerMockito.mockStatic(UserDao.class);
//        PowerMockito.doReturn(10).when(dao).getCount();
        PowerMockito.when(UserDao.getCount()).thenReturn(10);
        UserService userService = new UserService();
        int result = userService.queryUserCount();
        Assert.assertEquals(10, result);
    }

    @Test
    public void testSaveUser() {
        PowerMockito.mockStatic(UserDao.class);
        User user = new User();
        PowerMockito.doNothing().when(UserDao.class);
        UserService userService = new UserService();
        userService.saveUser(user);

        PowerMockito.verifyStatic();

    }


}
