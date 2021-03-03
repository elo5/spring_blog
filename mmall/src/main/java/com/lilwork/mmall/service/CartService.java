package com.lilwork.mmall.service;

import com.lilwork.mmall.entity.Cart;
import com.baomidou.mybatisplus.extension.service.IService;
import com.lilwork.mmall.vo.CartVO;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author lil
 * @since 2021-03-02
 */
public interface CartService extends IService<Cart> {

    public List<CartVO> findAllCartVOByUserId(Integer userId);

}
