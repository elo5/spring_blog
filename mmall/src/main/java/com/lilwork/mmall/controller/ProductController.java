package com.lilwork.mmall.controller;


import com.lilwork.mmall.entity.User;
import com.lilwork.mmall.service.CartService;
import com.lilwork.mmall.service.ProductCategoryService;
import com.lilwork.mmall.service.ProductService;
import com.lilwork.mmall.vo.CartVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author lil
 * @since 2021-03-02
 */
@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService service;
    @Autowired
    private ProductCategoryService productCategoryService;
    @Autowired
    private CartService cartService;


    @GetMapping("/list/{type}/{id}")
    public ModelAndView list(
            @PathVariable("type") String type,
            @PathVariable("id") Integer id,
            HttpSession session){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("productList");
        modelAndView.addObject("productList",service.findByCategoryId(type,id));
        modelAndView.addObject("list", productCategoryService.getAllProductCategoryVO());
        User user = (User)session.getAttribute("user");
        modelAndView.addObject("cartList", user == null ? new ArrayList<CartVO>() :cartService.findAllCartVOByUserId(user.getId()));

        return modelAndView;
    }

    @GetMapping("/findById/{id}")
    public ModelAndView findById(@PathVariable("id") Integer id, HttpSession session){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("productDetail");
        modelAndView.addObject("product", service.getById(id));
        modelAndView.addObject("list", productCategoryService.getAllProductCategoryVO());
        User user = (User)session.getAttribute("user");
        modelAndView.addObject("cartList", user == null ? new ArrayList<CartVO>() :cartService.findAllCartVOByUserId(user.getId()));
        return modelAndView;
    }

    @GetMapping("/removeCart/{id}")
    public String removeCart(@PathVariable("id") Integer id){
        cartService.removeById(id);
        return "redirect:/cart/findAllCart";
    }

}

