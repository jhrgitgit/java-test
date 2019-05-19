package com.matcher;

import com.matcher.dao.UserDao;
import com.matcher.service.UserService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.internal.runners.statements.Fail;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatcher;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.junit.Assert.fail;
import static org.mockito.Matchers.argThat;


@RunWith(PowerMockRunner.class)
@PrepareForTest({UserService.class})
public class UserServiceTest {


    @Test
    public void testFind() throws Exception {

        UserDao userDao = PowerMockito.mock(UserDao.class);
        PowerMockito.whenNew(UserDao.class).withAnyArguments().thenReturn(userDao);

        PowerMockito.when(userDao.query(argThat(new MyMatcher()))).thenReturn("bb");

        PowerMockito.when(userDao.query("aa")).thenReturn("bb");
        UserService userService = new UserService();
        String result = userService.queryByName("aa");
        Assert.assertEquals("bb", result);


        String result2 = userService.queryByName("cc");
        Assert.assertEquals("bb", result2);
//        Assert.assertEquals("bb", userService.queryByName("ee"));
    }

    @Test
    public void testFindWithAnswer() throws Exception {

        UserDao userDao = PowerMockito.mock(UserDao.class);
        PowerMockito.whenNew(UserDao.class).withAnyArguments().thenReturn(userDao);

        PowerMockito.when(userDao.query(Mockito.anyString())).then(invocation ->{
            String arg = (String) invocation.getArguments()[0];
            switch (arg) {
                case "aa":
                    return "aa";
                case "bb":
                    return "bb";
                default:
                    throw new RuntimeException("Not support " + arg);
            }
        });

        UserService userService = new UserService();
        Assert.assertEquals("aa", userService.queryByName("aa"));
        Assert.assertEquals("bb", userService.queryByName("bb"));
        try {
            String cc = userService.queryByName("cc");
            fail("never process");
        } catch (Exception e) {
            Assert.assertTrue(e instanceof RuntimeException);
        }

    }




    static class MyMatcher extends ArgumentMatcher<String> {

        @Override
        public boolean matches(Object o) {
            String ar = (String) o;
            switch (ar) {
                case "aa":
                case "bb":
                case "cc":
                case "dd":
                    return true;
                default:
                    return false;
            }
        }
    }
}
