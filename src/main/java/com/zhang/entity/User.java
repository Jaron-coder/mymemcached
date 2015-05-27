package com.zhang.entity;

import com.google.code.ssm.api.CacheKeyMethod;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by zhanglong on 2015/5/26.
 */

/**
 * @CacheKeyMethod
 *      In SSM, you are able to identify 'key objects'. These are the objects that Simple-Spring-Memcached will rely upon to generate a (non-namespaced) unique key for
 * referring to values within the cache. For any given key object, it will first be checked if any of its methods are annotated with @CacheKeyMethod. If a @CacheKeyMethod is found,
 * and it conforms to the required signature (no-arg, with an output of type String), this is the method that will be relied upon to generate a unique key. If there is no conforming @CacheKeyMethod,
 * then the basic Object.toString() method will be used.

        Key can be generated using more than one key object. The (non-namespaced) unique key
   is a concatenation of single keys generated from each key object and joined using '/'.
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


   // @CacheKeyMethod
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

    @CacheKeyMethod
    public String toString() {
        return userId;
    }
}
