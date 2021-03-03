package com.lilwork.mmall.exception;

import com.lilwork.mmall.enums.ResultEnum;

/**
 * unchecked 不用去处理的异常，交给JVM去处理， 继承RuntimeException
 * checked 需要捕获 ，继承Exception
 */
public class MMallException extends RuntimeException {
    public MMallException(String error){
        super(error);
    }

    public MMallException(ResultEnum resultEnum){
        super(resultEnum.getMsg());
    }
}
