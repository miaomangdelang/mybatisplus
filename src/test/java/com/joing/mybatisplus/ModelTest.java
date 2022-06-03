package com.joing.mybatisplus;

import com.baomidou.mybatisplus.extension.plugins.pagination.PageDTO;
import com.joing.mybatisplus.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author Join.Yao (pathinfuture@163.com)
 * @date 2022/05/31 21:09
 */
@SpringBootTest
public class ModelTest {

    @Test
    public void modelSelect() {
        PageDTO<User> userList = new User().selectPage(new PageDTO<>(2, 2), null);
        System.out.println(userList);
    }

}
