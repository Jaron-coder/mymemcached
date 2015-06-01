package com.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.Arrays;

/**
 * Created by zhanglong on 2015/6/1.
 */
@SpringBootApplication
public class Application {

    public static void main(String[] args){
        ApplicationContext ac= SpringApplication.run(Application.class, args);
        System.out.println("Let's inspect the beans provided by Spring Boot:");

       String[] beanNames= ac.getBeanDefinitionNames();
        Arrays.sort(beanNames);

        for (String beanName : beanNames) {
            System.out.println(beanName);
        }
    }
}
