package com.joing.mybatisplus.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.joing.mybatisplus.enums.SexEnum;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author Join.Yao (pathinfuture@163.com)
 * @date 2022/05/25 17:32
 */
@EqualsAndHashCode(callSuper = true)
@Data
@TableName(value = "t_user", schema = "mybatis_plus")
public class User extends Model<User> {

    /**
     * 将属性所对应的字段指定为主键
     *
     * @TableId 注解的value属性用于指定主键的字段
     * @TableId 注解的type属性设置主键生成策略
     * @TableId (value = " uid ", type = IdType.AUTO)
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 指定属性所对应的字段名
     */
    @TableField("name")
    private String name;

    private Integer age;

    private String email;

    private SexEnum sex;

    @TableLogic
    private Integer isDeleted;

    private static final long serialVersionUID = 4978401788968072550L;

}
