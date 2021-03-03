package com.lilwork.mmall.service.impl;

import com.lilwork.mmall.entity.OrderBean;
import com.lilwork.mmall.mapper.OrderBeanMapper;
import com.lilwork.mmall.service.OrderService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author lil
 * @since 2021-03-02
 */
@Service
public class OrderServiceImpl extends ServiceImpl<OrderBeanMapper, OrderBean> implements OrderService {

}
