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

        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("type",1);
        List<ProductCategory> orginal = productCategoryMapper.selectList(wrapper);
        List<ProductCategoryVO> voList = orginal.stream().map(e -> new ProductCategoryVO(e.getId(), e.getName())).collect(Collectors.toList());

        for (ProductCategoryVO vo : voList){
            vo.setBannerImg("banner0.png");
            vo.setTopImg("top0.png");
            wrapper =  new QueryWrapper();
            wrapper.eq("type", 2);
            wrapper.eq("parent_id", vo.getId());
            List<ProductCategory> l2 = productCategoryMapper.selectList(wrapper);
            List<ProductCategoryVO> voL2 = l2.stream().map(e -> new ProductCategoryVO(e.getId(), e.getName())).collect(Collectors.toList());
            vo.setChildren(voL2);

            for (ProductCategoryVO vo1 : voL2){
                wrapper =  new QueryWrapper();
                wrapper.eq("type", 3);
                wrapper.eq("parent_id", vo1.getId());
                List<ProductCategory> l3 = productCategoryMapper.selectList(wrapper);
                List<ProductCategoryVO> voL3 = l3.stream().map(e -> new ProductCategoryVO(e.getId(), e.getName())).collect(Collectors.toList());
                vo1.setChildren(voL3);
            }
        }

        return voList;
    }
}
