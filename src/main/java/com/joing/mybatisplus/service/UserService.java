package com.joing.mybatisplus.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.joing.mybatisplus.entity.User;

import java.util.List;

/**
 * @author Join.Yao (pathinfuture@163.com)
 * @date 2022/05/25 17:32
 */
public interface UserService extends IService<User> {

    /**
     * user
     *
     * @return users
     */
    List<User> selectUsers();

}
