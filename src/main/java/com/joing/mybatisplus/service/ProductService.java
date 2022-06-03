package com.joing.mybatisplus.service;

import com.joing.mybatisplus.entity.Product;

/**
 * @author Join.Yao (pathinfuture@163.com)
 * @date 2022/06/02 18:16
 */
public interface ProductService {

    /**
     * 修改价格
     *
     * @param price    价格
     * @param username 用户
     * @return Product
     */
    void updatePrice(Integer price, String username);

}
