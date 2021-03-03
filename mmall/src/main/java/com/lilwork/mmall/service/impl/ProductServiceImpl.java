package com.lilwork.mmall.service.impl;

import com.lilwork.mmall.entity.Product;
import com.lilwork.mmall.mapper.ProductMapper;
import com.lilwork.mmall.service.ProductService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author lil
 * @since 2021-03-02
 */
@Service
public class ProductServiceImpl extends ServiceImpl<ProductMapper, Product> implements ProductService {

    @Override
    public List<Product> findByCategoryId(String type,Integer id) {
        Map<String, Object> map = new HashMap<>();
        map.put("categorylevel"+type+"_id",id);
        return listByMap(map);
    }
}
