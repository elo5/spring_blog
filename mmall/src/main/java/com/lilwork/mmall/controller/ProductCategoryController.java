package com.lilwork.mmall.controller;


import com.lilwork.mmall.entity.User;
import com.lilwork.mmall.service.CartService;
import com.lilwork.mmall.service.ProductCategoryService;
import com.lilwork.mmall.vo.CartVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author lil
 * @since 2021-03-02
 */
@Controller
@RequestMapping("/productCategory")
public class ProductCategoryController {

    @Autowired
    private ProductCategoryService productCategoryService;
    @Autowired
    private CartService cartService;

    @GetMapping("/list")
    public ModelAndView list(HttpSession session){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("main");
        modelAndView.addObject("list", productCategoryService.getAllProductCategoryVO());
        User user = (User)session.getAttribute("user");
        modelAndView.addObject("cartList", user == null ? new ArrayList<CartVO>() :cartService.findAllCartVOByUserId(user.getId()));

        return modelAndView;
    }

}

