package com.zhang.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by zhanglong on 2015/6/1.
 */

@RestController
public class UserController {

    @RequestMapping("/")
    public String index(){
        return "Greetings from Spring Boot!";
    }

}
