package com.lilwork.mmall.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.lilwork.mmall.entity.Cart;
import com.lilwork.mmall.entity.Product;
import com.lilwork.mmall.enums.ResultEnum;
import com.lilwork.mmall.exception.MMallException;
import com.lilwork.mmall.mapper.CartMapper;
import com.lilwork.mmall.mapper.ProductMapper;
import com.lilwork.mmall.service.CartService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lilwork.mmall.vo.CartVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author lil
 * @since 2021-03-02
 */
@Service
@Slf4j
public class CartServiceImpl extends ServiceImpl<CartMapper, Cart> implements CartService {

    @Autowired
    private CartMapper cartMapper;
    @Autowired
    private ProductMapper productMapper;

    @Override
    public boolean save(Cart entity) {

        //扣库存
        Product product = productMapper.selectById(entity.getProductId());
        Integer stock = product.getStock() - entity.getQuantity();
        if (stock < 0){
            log.error("【添加购物车】库存不足！ stock={}", stock);
            throw new MMallException(ResultEnum.STOCK_ERROR);
        }
        product.setStock(stock);
        productMapper.updateById(product);
        if (cartMapper.insert(entity) == 1){
            return true;
        }
        return false;
    }

    @Override
    public List<CartVO> findAllCartVOByUserId(Integer userId) {
        List<CartVO> cartVOList = new ArrayList<>();

        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("user_id", userId);
        List<Cart> cartList = cartMapper.selectList(wrapper);

        for (Cart cart : cartList){
            CartVO cartVO = new CartVO();
            BeanUtils.copyProperties(cart, cartVO);
            Product product = productMapper.selectById(cart.getProductId());
            cartVO.setName(product.getName());
            cartVO.setFileName(product.getFileName());
            cartVO.setPrice(product.getPrice());
            cartVO.setStock(product.getStock());
            cartVOList.add(cartVO);
        }

        return cartVOList;
    }
}
