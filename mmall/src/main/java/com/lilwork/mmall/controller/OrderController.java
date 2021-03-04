package com.lilwork.mmall.controller;


import com.lilwork.mmall.entity.Orders;
import com.lilwork.mmall.entity.User;
import com.lilwork.mmall.service.CartService;
import com.lilwork.mmall.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

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

    @Autowired
    private CartService cartService;

    @PostMapping("/settlement3")
    public ModelAndView settlement3(
            Orders orders,
            HttpSession session,
            String address,
            String remark){

        User user = (User) session.getAttribute("user");
        orderService.save(orders,user,address,remark);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("settlement3");
        modelAndView.addObject("cartList",cartService.findAllCartVOByUserId(user.getId()));
        modelAndView.addObject("orders",orders);
        return modelAndView;
    }

}

