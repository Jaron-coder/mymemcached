package com.zhang.entity;

import com.google.code.ssm.api.CacheKeyMethod;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by zhanglong on 2015/5/26.
 */

@Entity
@Table(name = "tab_user")
public class User implements Serializable{
    private static final long serialVersionUID = -7020619477594468968L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String userId;

    @Column(name = "username", length = 12,columnDefinition = "string")
    private String username;

    @Column(name = "password", length = 12,columnDefinition = "string")
    private String password;


    @CacheKeyMethod
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
