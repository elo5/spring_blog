package com.lilwork.blog.service.impl;

import com.lilwork.blog.entity.Users;
import com.lilwork.blog.mapper.UsersMapper;
import com.lilwork.blog.service.UsersService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author lil
 * @since 2021-03-04
 */
@Service
public class UsersServiceImpl extends ServiceImpl<UsersMapper, Users> implements UsersService {

}
