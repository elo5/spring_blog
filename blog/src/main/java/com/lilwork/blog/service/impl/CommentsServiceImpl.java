package com.lilwork.blog.service.impl;

import com.lilwork.blog.entity.Comments;
import com.lilwork.blog.mapper.CommentsMapper;
import com.lilwork.blog.service.CommentsService;
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
public class CommentsServiceImpl extends ServiceImpl<CommentsMapper, Comments> implements CommentsService {

}
