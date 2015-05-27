package com.zhang.dao;

import com.zhang.entity.User;

/**
 * Created by zhanglong on 2015/5/26.
 */
public interface IUserDao {

    public void saveUser(User user);

    public User getById(String userId);

    public void updateUser(User user);

    public void deleteUser(String userId);
}
