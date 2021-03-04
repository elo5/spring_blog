package com.lilwork.mmall.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;

public enum GenderEnum {
    WOMAN(0,"女"),
    MAN(1,"男");

    @EnumValue
    public Integer code;
    public String value;

    GenderEnum(Integer code, String value) {
        this.code = code;
        this.value = value;
    }


}
