package com.lilwork.mmall.service.impl;

import com.lilwork.mmall.entity.Product;
import com.lilwork.mmall.service.ProductService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootTest
public class ProductServiceTest {

    @Autowired
    private ProductService service;

    @Test
    public void test(){

        Map<String, Object> map = new HashMap<>();
        map.put("categorylevelthree_id",655);
        List<Product> list = service.listByMap(map);

        list.forEach(System.out::println);

    }

    @Test
    public void test1(){
        System.out.println(service.getById(733));
    }
}
