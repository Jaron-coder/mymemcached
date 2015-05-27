package com.zhang.dao.test;

import com.zhang.dao.IUserDao;
import com.zhang.entity.User;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.annotation.Resource;

/**
 * Created by zhanglong on 2015/5/26.
 */
public class UserDaoTest {

    private static IUserDao iUserDao;

    @BeforeClass
    public static void init() {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        iUserDao = (IUserDao) context.getBean("iUserDao");
    }


    @Test
    public void saveUserTest() {

        User user = new User();

        user.setUsername("zhangsan-李四");
        user.setPassword("123456789");

        iUserDao.saveUser(user);

        User user1 = new User();

        user1.setUsername("zhangsan2-李四");
        user1.setPassword("1234567890");

        iUserDao.saveUser(user1);
    }

    @Test
    public void updateUserTest() {
        User user = new User();
        user.setUserId("1");
        user.setUsername("zhang-aaaaa");
        user.setPassword("123456789");
        iUserDao.updateUser(user);
    }

    @Test
    public void getUserTest() {
       User user= iUserDao.getById("1");
        System.out.print("从缓存中获取的值为："+user.getUsername());
    }
    @Test
    public void deleteUserTest() {
        iUserDao.deleteUser("1");
    }

}
