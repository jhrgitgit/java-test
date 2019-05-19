package com.verify;

import com.common.User;
import com.verify.dao.UserDao;
import com.verify.service.UserService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

/**
 * 测试verify
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest({UserService.class})
public class UserServiceTest {


    @Test
    public void testSaveOrUpdateUser() throws Exception {
        User user = PowerMockito.mock(User.class);

        UserDao userDao = PowerMockito.mock(UserDao.class);
        PowerMockito.whenNew(UserDao.class).withAnyArguments().thenReturn(userDao);
        PowerMockito.when(userDao.getCount(user)).thenReturn(0);
        UserService userService = new UserService();
        userService.saveOrUpdate(user);

        Mockito.verify(userDao).insertUser(user);
        Mockito.verify(userDao,Mockito.never()).updateUser();

    }

    @Test
    public void testSaveOrUpdateUser2() throws Exception {
        User user = PowerMockito.mock(User.class);

        UserDao userDao = PowerMockito.mock(UserDao.class);
        PowerMockito.whenNew(UserDao.class).withAnyArguments().thenReturn(userDao);
        PowerMockito.when(userDao.getCount(user)).thenReturn(1);
        UserService userService = new UserService();
        userService.saveOrUpdate(user);

        Mockito.verify(userDao,Mockito.never()).insertUser(user);
        Mockito.verify(userDao).updateUser();

    }
}
