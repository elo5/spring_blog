package com.lilwork.mmall.controller;


import com.lilwork.mmall.entity.OrderBean;
import com.lilwork.mmall.entity.User;
import com.lilwork.mmall.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.Random;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author lil
 * @since 2021-03-02
 */
@Controller
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("/settlement3")
    public ModelAndView settlement3(
//            @PathVariable("selectAddress")
                    String selectAddress,
//            @PathVariable("cost")
                    Float cost,
//            @PathVariable("cost") Float cost,
            HttpSession session){
//        ModelAndView  modelAndView  = new ModelAndView();
        OrderBean order =  new OrderBean();
        order.setCost(cost);
        order.setUserAddress(selectAddress);
        User user = (User) session.getAttribute("user");
        order.setUserId(user.getId());
        order.setLoginName(user.getLoginName());
        orderService.save(order);
//        return modelAndView;
        String seriaNumer = null;
        try {
            StringBuffer result = new StringBuffer();
            for (int  i = 0;  i< 32; i++){
                result.append(Integer.toHexString(new Random().nextInt(16)));
            }
            seriaNumer =  result.toString().toUpperCase();
            order.setSerialnumber(seriaNumer);
        }catch (Exception e){
            e.printStackTrace();
        }

        return null;
    }

}

