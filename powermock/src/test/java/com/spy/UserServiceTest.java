package com.spy;

import com.spy.service.UserService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatcher;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import static org.mockito.Matchers.argThat;

/**
 * spy 真正执行内部方法
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest(UserService.class)
public class UserServiceTest {


    @Test
    public void testfoo() throws Exception {

        UserService userService = PowerMockito.spy(new UserService());
        String arg = "hello";
        PowerMockito.doNothing().when(userService).foo(arg);

        userService.foo("world");
    }
    @Test
    public void testCheck() throws Exception {

        UserService userService = PowerMockito.spy(new UserService());
        PowerMockito.doReturn(true).when(userService,"checkExist","aa");
        assertTrue(userService.exist("aa"));
    }

}
