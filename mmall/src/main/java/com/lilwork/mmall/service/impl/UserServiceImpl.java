package com.lilwork.mmall.service.impl;

import com.lilwork.mmall.entity.User;
import com.lilwork.mmall.mapper.UserMapper;
import com.lilwork.mmall.service.UserService;
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
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
