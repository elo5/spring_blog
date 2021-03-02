package com.lilwork.mmall.service;

import com.lilwork.mmall.entity.ProductCategory;
import com.baomidou.mybatisplus.extension.service.IService;
import com.lilwork.mmall.vo.ProductCategoryVO;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author lil
 * @since 2021-03-02
 */
public interface ProductCategoryService extends IService<ProductCategory> {

    public List<ProductCategoryVO> getAllProductCategoryVO();

}
