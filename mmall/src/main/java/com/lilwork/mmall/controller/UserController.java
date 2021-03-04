package com.lilwork.mmall.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.lilwork.mmall.entity.User;
import com.lilwork.mmall.enums.GenderEnum;
import com.lilwork.mmall.service.CartService;
import com.lilwork.mmall.service.UserService;
import com.lilwork.mmall.vo.CartVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
@RequestMapping("/user")
public class UserController {


    @Autowired
    private UserService userService;

    @Autowired
    private CartService cartService;

    @PostMapping("/login")
    public String login(String loginName, String password, HttpSession session){

        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("login_name",  loginName);
        queryWrapper.eq("password",  password);
        User user = userService.getOne(queryWrapper);
        if (user == null) return "login";
        session.setAttribute("user", user);
        return "redirect:/productCategory/list";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session){
        session.invalidate();
        return "login";
    }

    @PostMapping("/register")
    public String register(User user, Model model){
        user.setGender(GenderEnum.WOMAN);
        user.setFileName("2.jpg");
        boolean result = false;
        try {
            result = userService.save(user);
        }catch (Exception e){
            model.addAttribute("error", user.getLoginName() + "已存在");
        }
        return result ? "login" : "register";
    }

    @GetMapping("/userInfo")
    public ModelAndView userInfo(HttpSession session){

        User user = (User)session.getAttribute("user");

//        if (user == null){
//            return new ModelAndView( "redirect:/login");
//        }

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("userInfo");

        modelAndView.addObject("cartList", cartService.findAllCartVOByUserId(user.getId()));
        return modelAndView;
    }
}

