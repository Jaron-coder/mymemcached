package com.zhang.dao.impl;

import com.google.code.ssm.api.*;
import com.zhang.dao.IUserDao;
import com.zhang.entity.User;
import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import javax.lang.model.element.NestingKind;

/**
 * Created by zhanglong on 2015/5/26.
 */
@Transactional
@Repository(value = "iUserDao")
public class UserDaoImpl implements IUserDao {
    private final Logger log=Logger.getLogger(getClass());

    private static final String NAMESPACE = "ns";

    @Inject
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        log.info("--------instance sessionFactory---------");
        this.sessionFactory = sessionFactory;
    }

    public void saveUser(User user) {
        log.info("--------invoke saveUser()---------");
        this.sessionFactory.getCurrentSession().save(user);
    }

    /**
     * 当执行getById查询方法时，系统首先会从缓存中获取userId对应的实体
     * 如果实体还没有被缓存，则执行查询方法并将查询结果放入缓存中
     */
    @ReadThroughSingleCache(namespace = NAMESPACE, expiration =3600)
    public User getById(@ParameterValueKeyProvider String userId) {
        log.info("--------invoke getById()---------");
        User entity = (User)this.sessionFactory.getCurrentSession().createQuery("FROM User u WHERE u.userId=?").setParameter(0, userId).uniqueResult();
        System.out.println("查询到的用户为：>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>  " + entity.getUsername());
        return entity;
    }

    /**
     * 当执行updateUser方法时，系统会更新缓存中userId对应的实体
     * 将实体内容更新成@*DataUpdateContent标签所描述的实体
     */

    @UpdateSingleCache(namespace = NAMESPACE,expiration = 3600)
    public void updateUser(@ParameterValueKeyProvider @ParameterDataUpdateContent User user) {
        log.info("--------invoke updateUser()---------");
        this.sessionFactory.getCurrentSession().update(user);
    }

    /**
     * 当执行deleteUser方法时，系统会删除缓存中userId对应的实体
     */
    @InvalidateSingleCache(namespace = NAMESPACE)
    public void deleteUser(@ParameterValueKeyProvider String userId) {
        log.info("--------invoke deleteUser()---------");
       this.sessionFactory.getCurrentSession().delete(userId,User.class);
    }
}
