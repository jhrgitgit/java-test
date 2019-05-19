package com.construction;

import com.common.User;
import com.construction.dao.UserDao;
import com.construction.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

/**
 * 测试参数
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest({UserService.class})
public class UserServiceTest {


    @Test
    public void testSave() throws Exception {

        UserDao userDao = PowerMockito.mock(UserDao.class);
        String username = "aa";
        String password = "bb";
        PowerMockito.whenNew(UserDao.class).withArguments(username,password).thenReturn(userDao);
        PowerMockito.doNothing().when(userDao).insert();
        UserService userService = new UserService();
        userService.save(username,password);

        Mockito.verify(userDao).insert();


    }
}
