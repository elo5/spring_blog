package com.lilwork.mmall.controller;


import com.lilwork.mmall.entity.Cart;
import com.lilwork.mmall.entity.User;
import com.lilwork.mmall.service.CartService;
import com.lilwork.mmall.vo.CartVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
@RequestMapping("/cart")
public class CartController {

    @Autowired
    private CartService cartService;

    @GetMapping("/add/{productId}/{price}/{quantity}") //http://localhost:9099/cart/add/768/5896/3
    public String add(
            @PathVariable("productId") Integer productId,
            @PathVariable("price") Float price,
            @PathVariable("quantity") Integer quantity,
            HttpSession session)

    {
//        ModelAndView modelAndView = new ModelAndView();

        User user = (User)session.getAttribute("user");
        Cart cart = new Cart();
        cart.setQuantity(quantity);
        cart.setProductId(productId);
        cart.setCost(quantity * price);
        cart.setUserId(user.getId());

        try {
            boolean result = cartService.save(cart);
            if (result){
//                modelAndView.setViewName("settlement1");
//                return "settlement1";
                return "redirect:/cart/findAllCart";
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        return "redirect:/productCategory/list";
    }

    @GetMapping("/findAllCart")
    public ModelAndView findAllCart(HttpSession session){

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("settlement1");
        User user = (User) session.getAttribute("user");
        modelAndView.addObject("cartList", user == null ? new ArrayList<CartVO>() :cartService.findAllCartVOByUserId(user.getId()));

        return modelAndView;

    }


}

