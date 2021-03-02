package com.lilwork.mmall.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.lilwork.mmall.entity.User;
import com.lilwork.mmall.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;

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
@RequestMapping("/user")
public class UserController {


    @Autowired
    private UserService userService;

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
}

