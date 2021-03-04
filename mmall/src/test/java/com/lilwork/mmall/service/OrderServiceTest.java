package com.lilwork.mmall.service;

import com.lilwork.mmall.entity.Orders;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class OrderServiceTest {

    @Autowired
    private OrderService  orderService;

    @Test
    public void test1(){
        Orders order =  new Orders();
        order.setCost(10f);
        order.setUserAddress("科技园");
        order.setUserId(10);
        order.setLoginName("cgn");
        boolean result = orderService.save(order);

        if (result){
            int i  = 0;
        }
    }
}