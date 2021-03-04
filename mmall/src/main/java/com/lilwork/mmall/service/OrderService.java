package com.lilwork.mmall.service;

import com.lilwork.mmall.entity.Orders;
import com.baomidou.mybatisplus.extension.service.IService;
import com.lilwork.mmall.entity.User;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author lil
 * @since 2021-03-02
 */
public interface OrderService extends IService<Orders> {

    public boolean save(Orders order, User user, String address, String remark);

}
