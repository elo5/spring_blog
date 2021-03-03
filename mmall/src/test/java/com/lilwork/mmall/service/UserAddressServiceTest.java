package com.lilwork.mmall.service;

import com.lilwork.mmall.entity.UserAddress;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootTest
class UserAddressServiceTest {

    @Autowired
    private UserAddressService userAddressService;

    @Test
    public void test1(){
        Map<String, Object> map  = new HashMap<>();
        map.put("user_id",10);
        List<UserAddress> list = userAddressService.listByMap(map);
        list.forEach(System.out::println);
        System.out.println(list);

    }

}