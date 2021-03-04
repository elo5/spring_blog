package com.lilwork.blog.service.impl;

import com.lilwork.blog.entity.Contents;
import com.lilwork.blog.mapper.ContentsMapper;
import com.lilwork.blog.service.ContentsService;
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
public class ContentsServiceImpl extends ServiceImpl<ContentsMapper, Contents> implements ContentsService {

}
