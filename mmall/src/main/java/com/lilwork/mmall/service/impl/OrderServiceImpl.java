package com.lilwork.mmall.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.lilwork.mmall.entity.*;
import com.lilwork.mmall.mapper.CartMapper;
import com.lilwork.mmall.mapper.OrdersMapper;
import com.lilwork.mmall.mapper.OrderDetailMapper;
import com.lilwork.mmall.mapper.UserAddressMapper;
import com.lilwork.mmall.service.OrderService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author lil
 * @since 2021-03-02
 */
@Service
public class OrderServiceImpl extends ServiceImpl<OrdersMapper, Orders> implements OrderService {

    @Autowired
    private UserAddressMapper userAddressMapper;
    @Autowired
    private CartMapper cartMapper;
    @Autowired
    private OrdersMapper ordersMapper;
    @Autowired
    private OrderDetailMapper orderDetailMapper;

    @Override
    public boolean save(Orders orders, User user, String address, String remark) {

        //判断是否是新地址,是则需存入数据库,旧的default改为0，user使用新地址
        if (orders.getUserAddress().equals("newAddress")){
            UserAddress userAddress = new UserAddress();
            userAddress.setAddress(address);
            userAddress.setRemark(remark);
            userAddress.setIsdefault(1);
            userAddress.setUserId(user.getId());
            userAddressMapper.insert(userAddress);

            QueryWrapper wrapper = new QueryWrapper();
            wrapper.eq("address", address);
            UserAddress defaultOrgin = userAddressMapper.selectOne(wrapper);
            defaultOrgin.setIsdefault(0);
            userAddressMapper.updateById(defaultOrgin);
            orders.setUserAddress(address);
        }

        // 存储order_bean
        orders.setUserId(user.getId());
        orders.setLoginName(user.getLoginName());
        String seriaNumer = null;
        try {
            StringBuffer result = new StringBuffer();
            for (int  i = 0;  i< 32; i++){
                result.append(Integer.toHexString(new Random().nextInt(16)));
            }
            seriaNumer =  result.toString().toUpperCase();

        }catch (Exception e){
            e.printStackTrace();
        }
        orders.setSerialnumber(seriaNumer);
        ordersMapper.insert(orders);

        //存储order_detail
        QueryWrapper cartWrapper = new QueryWrapper();
        cartWrapper.eq("user_id", user.getId());
        List<Cart> cartList = cartMapper.selectList(cartWrapper);
        List<OrderDetail> orderDetailList = new ArrayList<>();
        for (Cart cart : cartList){
            OrderDetail detail = new OrderDetail();
            BeanUtils.copyProperties(cart, detail);
            detail.setId(null);
            orderDetailList.add(detail);
            detail.setOrderId(orders.getId());
            orderDetailMapper.insert(detail);
        }

        //清空购物车
        QueryWrapper delWrapper = new QueryWrapper();
        delWrapper.eq("user_id",user.getId());
        cartMapper.delete(delWrapper);
        return true;
    }
}
