package com.lilwork.blog.service.impl;

import com.lilwork.blog.entity.Logs;
import com.lilwork.blog.mapper.LogsMapper;
import com.lilwork.blog.service.LogsService;
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
public class LogsServiceImpl extends ServiceImpl<LogsMapper, Logs> implements LogsService {

}
