package com.joing.mybatisplus;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.joing.mybatisplus.entity.User;
import com.joing.mybatisplus.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

/**
 * @author Join.Yao (pathinfuture@163.com)
 * @date 2022/06/06 18:35
 */
@SpringBootTest
public class InjectorTest {


    @Resource
    private UserMapper userMapper;

    @Test
    public void deleteAll() {
        System.out.println(userMapper.deleteAll(new QueryWrapper<User>().lambda().eq(User:: getName, "aaa")));
    }

}
