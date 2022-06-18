package com.joing.mybatisplus.web;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.joing.mybatisplus.entity.User;
import com.joing.mybatisplus.mapper.UserMapper;
import com.joing.mybatisplus.web.input.UserInput;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author Join.Yao (pathinfuture@163.com)
 * @date 2022/06/02 16:26
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserMapper userMapper;

    @GetMapping("/get")
    public OperationResult get(UserInput input) {
        return OperationResult.success(userMapper.selectList(new QueryWrapper<User>().lambda().eq(User::getSex, input.getSex())));
    }

    @PostMapping("/post")
    public OperationResult post(@RequestBody UserInput input) {
        return OperationResult.success(userMapper.selectList(new QueryWrapper<User>().lambda().eq(User::getSex, input.getSex())));
    }

}
