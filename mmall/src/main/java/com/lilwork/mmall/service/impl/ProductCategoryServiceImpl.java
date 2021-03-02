package com.lilwork.mmall.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.lilwork.mmall.entity.ProductCategory;
import com.lilwork.mmall.mapper.ProductCategoryMapper;
import com.lilwork.mmall.service.ProductCategoryService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lilwork.mmall.vo.ProductCategoryVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author lil
 * @since 2021-03-02
 */
@Service
public class ProductCategoryServiceImpl extends ServiceImpl<ProductCategoryMapper, ProductCategory> implements ProductCategoryService {

    @Autowired
    private ProductCategoryMapper productCategoryMapper;

    @Override
    public List<ProductCategoryVO> getAllProductCategoryVO() {
//        //实体类转VO
//        List<ProductCategory> productCategories = productCategoryMapper.selectList(null);
//        List<ProductCategoryVO> productCategoryVOS = new ArrayList<>();
//        for (ProductCategory productCategory : productCategories){
//            ProductCategoryVO productCategoryVO = new ProductCategoryVO();
//            BeanUtils.copyProperties(productCategory, productCategoryVO);
//            productCategoryVOS.add(productCategoryVO);
//        }
//        return productCategoryVOS;

        //一级分类
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("type",1);
        List<ProductCategory> levelOne = productCategoryMapper.selectList(wrapper);
//        List<ProductCategoryVO> productCategoryVOSLevelOne = new ArrayList<>();
//        for (ProductCategory productCategory : levelOne){
//            ProductCategoryVO productCategoryVO = new ProductCategoryVO();
//            BeanUtils.copyProperties(productCategory, productCategoryVO);
//            productCategoryVOSLevelOne.add(productCategoryVO);
//        }
        List<ProductCategoryVO> vOSLevelOne = levelOne.stream().map(e -> new ProductCategoryVO(e.getId(), e.getName())).collect(Collectors.toList());

        //二级分类
        wrapper = new QueryWrapper();
        wrapper.eq("type",2);
        List<ProductCategory> levelTwo = productCategoryMapper.selectList(wrapper);
        List<ProductCategoryVO> vOSLevelTwo = levelTwo.stream().map(e -> new ProductCategoryVO(e.getId(), e.getName())).collect(Collectors.toList());


        //三级分类
        wrapper = new QueryWrapper();
        wrapper.eq("type",3);
        List<ProductCategory> levelThree = productCategoryMapper.selectList(wrapper);
        List<ProductCategoryVO> vOSLevelThree = levelThree.stream().map(e -> new ProductCategoryVO(e.getId(), e.getName())).collect(Collectors.toList());


        return null;
    }
}
