package com.lilwork.mmall.service;

import com.lilwork.mmall.entity.Product;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author lil
 * @since 2021-03-02
 */
public interface ProductService extends IService<Product> {

    List<Product> findByCategoryId(String type,Integer id);

}
