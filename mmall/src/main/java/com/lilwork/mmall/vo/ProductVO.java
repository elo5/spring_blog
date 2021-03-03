package com.lilwork.mmall.vo;

import lombok.Data;

@Data
public class ProductVO {

    private Integer id;
    private String name;
    private Float price;
    private String fileName;

    public ProductVO(Integer id, String name, Float price, String fileName){
        this.id = id;
        this.name = name;
        this.price = price;
        this.fileName = fileName;
    }

}
