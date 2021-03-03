package com.lilwork.mmall.service.impl;

import com.lilwork.mmall.entity.User;
import com.lilwork.mmall.mapper.UserMapper;
import com.lilwork.mmall.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserServiceImplTest {

    @Autowired
    private UserService service;

    @Test
    public void test1(){

        User u = new User();
        u.setGender(1);
        u.setEmail("elo5@qq.com");
        u.setIdentityCode("320602195811111111");
        u.setMobile("18911111111");
        u.setUserName("哈哈");
        u.setLoginName("lil");
        u.setPassword("123qwe");


        boolean result = service.save(u);

        int i = 0;

        if (result) i = 10;


    }

}