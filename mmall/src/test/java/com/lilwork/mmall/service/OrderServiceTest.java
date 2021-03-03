package com.lilwork.mmall.service;

import com.lilwork.mmall.entity.OrderBean;
import com.lilwork.mmall.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.servlet.ModelAndView;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class OrderServiceTest {

    @Autowired
    private OrderService  orderService;

    @Test
    public void test1(){
        OrderBean order =  new OrderBean();
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