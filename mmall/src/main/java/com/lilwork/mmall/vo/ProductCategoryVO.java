package com.lilwork.mmall.vo;

import lombok.Data;

import java.util.List;

@Data
public class ProductCategoryVO {
    private Integer id;
    private String name;
    private List<ProductCategoryVO> children;
    private String bannerImg;
    private String topImg;

    public ProductCategoryVO(Integer id, String name){
        this.id = id;
        this.name = name;
    }

//    public ProductCategoryVO(Integer id, String name, String bannerImg, String topImg){
//        this.id = id;
//        this.name = name;
//        this.bannerImg = bannerImg;
//        this.topImg = topImg;
//    }

}
