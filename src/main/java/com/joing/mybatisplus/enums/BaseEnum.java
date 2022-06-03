package com.joing.mybatisplus.enums;


/**
 * 枚举类实现此接口，自动将前端Get请求中枚举code转换为枚举
 *
 * @author huangTT(bluehtt @ gmail.com)
 * @version 1.0
 * @date 2020/6/3
 */
public interface BaseEnum {
    /**
     * 获取枚举编号
     *
     * @return Integer 枚举的code
     */
    Integer getCode();
}
