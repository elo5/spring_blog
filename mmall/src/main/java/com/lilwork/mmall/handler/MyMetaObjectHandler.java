package com.lilwork.mmall.handler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * 相当于拦截器的作用
 */
@Component
public class MyMetaObjectHandler implements MetaObjectHandler {
    @Override
    public void insertFill(MetaObject metaObject) {

//        SimpleDateFormat dt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//
//        this.setFieldValByName("create_time", dt.format(new Date()), metaObject);
//        this.setFieldValByName("update_time", dt.format(new Date()), metaObject);

        this.setFieldValByName("createTime", LocalDateTime.now(), metaObject);
        this.setFieldValByName("updateTime", LocalDateTime.now(), metaObject);
    }

    @Override
    public void updateFill(MetaObject metaObject) {
//        SimpleDateFormat dt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        this.setFieldValByName("update_time", dt.format(new Date()), metaObject);
        this.setFieldValByName("updateTime", LocalDateTime.now(), metaObject);
    }
}
