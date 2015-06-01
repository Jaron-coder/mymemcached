package com.zhang.dao.test;

import com.zhang.dao.IUserDao;
import com.zhang.entity.User;
import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by zhanglong on 2015/5/28.
 */
public class UserDaoImplTest extends TestCase {

    private IUserDao iUserDao;

    @Before
    public void setUp() throws Exception {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        iUserDao = (IUserDao) context.getBean("iUserDao");
    }

    @Test
    public void testSaveUser() throws Exception {

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
    public void testGetById() throws Exception {
        User user= iUserDao.getById("2");
        System.out.print("从缓存中获取的值为："+user.getUsername());
    }

    @Test
    public void testUpdateUser() throws Exception {
        User user = new User();
        user.setUserId("1");
        user.setUsername("zhang-qqq");
        user.setPassword("123456789");
        iUserDao.updateUser(user);
    }

    @Test
    public void testDeleteUser() throws Exception {
        iUserDao.deleteUser("1");
    }
}