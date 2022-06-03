package com.joing.mybatisplus.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.Version;
import lombok.Data;

import java.io.Serializable;

/**
 * @author Join.Yao (pathinfuture@163.com)
 * @date 2022/05/25 17:32
 */
@Data
@TableName("t_product")
public class Product implements Serializable {

    private Long id;

    private String name;

    private Integer price;

    /**
     * 标识乐观锁版本号字段
     */
    @Version
    private Integer version;

    private static final long serialVersionUID = -2114754512834203002L;

}
