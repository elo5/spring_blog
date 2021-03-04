package com.lilwork.blog.handler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;
import java.util.Calendar;

/**
 * 相当于拦截器的作用
 */
@Component
public class MyMetaOjectHandler implements MetaObjectHandler {
    @Override
    public void insertFill(MetaObject metaObject) {
        long  i = Calendar.getInstance().getTimeInMillis()/1000;
        this.setFieldValByName("created", (int)i, metaObject);
        this.setFieldValByName("modified", (int)i, metaObject);
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        long  i = Calendar.getInstance().getTimeInMillis()/1000;
        this.setFieldValByName("modified", (int)i, metaObject);
    }
}
