package com.joing.mybatisplus;

import com.baomidou.mybatisplus.extension.conditions.query.LambdaQueryChainWrapper;
import com.baomidou.mybatisplus.extension.conditions.update.LambdaUpdateChainWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.joing.mybatisplus.entity.User;
import com.joing.mybatisplus.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

/**
 * @author Join.Yao (pathinfuture@163.com)
 * @date 2022/05/31 21:46
 */
@SpringBootTest
public class ChainWrapperTest {

    @Resource
    private UserMapper userMapper;

    /**
     * 查询page
     */
    @Test
    public void LambdaQueryChainWrapper() {
        LambdaQueryChainWrapper<User> wrapper = new LambdaQueryChainWrapper<>(userMapper);
        Page<User> list = wrapper.page(new Page<>(2,2));
        System.out.println(list);
    }

    /**
     * update
     */
    @Test
    public void LambdaUpdateChainWrapper() {
        LambdaUpdateChainWrapper<User> updateChainWrapper = new LambdaUpdateChainWrapper<>(userMapper);
        LambdaUpdateChainWrapper<User> set = updateChainWrapper.eq(User::getId, 1).set(User::getName, "122233");
        set.update();
    }

    /**
     * delete
     */
    @Test
    public void LambdaUpdateChainWrapperDeleted() {
        LambdaUpdateChainWrapper<User> updateChainWrapper = new LambdaUpdateChainWrapper<>(userMapper);
        updateChainWrapper.eq(User::getId, 5).remove();
    }

}
