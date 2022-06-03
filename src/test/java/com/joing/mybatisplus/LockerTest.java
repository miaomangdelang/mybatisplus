package com.joing.mybatisplus;

import com.baomidou.mybatisplus.extension.conditions.query.LambdaQueryChainWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.joing.mybatisplus.entity.User;
import com.joing.mybatisplus.service.ProductService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

/**
 * @author Join.Yao (pathinfuture@163.com)
 * @date 2022/06/02 18:26
 */
@SpringBootTest
public class LockerTest {

    @Resource
    private ProductService productService;

    @Test
    public void lockWang() {
        productService.updatePrice(30, "小王");
    }

    @Test
    public void lockLi() {
        productService.updatePrice(20, "小里");
    }

}
