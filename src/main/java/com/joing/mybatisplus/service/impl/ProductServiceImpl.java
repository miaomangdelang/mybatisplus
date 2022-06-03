package com.joing.mybatisplus.service.impl;

import com.joing.mybatisplus.entity.Product;
import com.joing.mybatisplus.mapper.ProductMapper;
import com.joing.mybatisplus.service.ProductService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @author Join.Yao (pathinfuture@163.com)
 * @date 2022/06/02 18:16
 */
@Service
public class ProductServiceImpl implements ProductService {

    @Resource
    private ProductMapper productMapper;

    /**
     * 修改价格
     *
     * @param price 价格
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updatePrice(Integer price, String username) {
        Product product = productMapper.selectById(1L);
        System.out.println(username + "查询价格：" + product.getPrice());
        product.setPrice(product.getPrice() + price);
        try {
            Thread.sleep(1000 * 100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        int i = productMapper.updateById(product);
        System.out.println(username + "查询价格：" + product.getPrice());
        if (i == 0) {
            product = productMapper.selectById(1L);
            System.out.println(username + "2次查询价格：" + product.getPrice());
            product.setPrice(product.getPrice() + price);
            productMapper.updateById(product);
            System.out.println(username + "查询价格：" + product.getPrice());
        }
    }

}
