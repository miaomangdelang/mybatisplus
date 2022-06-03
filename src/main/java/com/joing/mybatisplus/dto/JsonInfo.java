package com.joing.mybatisplus.dto;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author Join.Yao (pathinfuture@163.com)
 * @date 2022/06/01 17:08
 */
@Data
@Accessors(chain = true)
public class JsonInfo {

    private Long id;

    private String name;
}
