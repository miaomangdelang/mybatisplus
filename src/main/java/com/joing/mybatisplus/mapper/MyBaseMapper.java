package com.joing.mybatisplus.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author Join.Yao (pathinfuture@163.com)
 * @date 2022/06/06 18:33
 */
public interface MyBaseMapper<T> extends BaseMapper<T> {

    /**
     * 自定义通用方法
     *
     * @return 删除数量
     */
    Integer deleteAll(@Param(Constants.WRAPPER) Wrapper<T> queryWrapper);

    /**
     * 批量插入
     *
     * @param entityList list
     * @return count
     */
    int insertBatchSomeColumn(List<T> entityList);

    /**
     * 更新
     *
     * @param entity
     * @return
     */
    int alwaysUpdateSomeColumnById(@Param(Constants.ENTITY) T entity);

    int alwaysUpdateSomeColumnById();

    /**
     * 删除
     *
     * @param entity
     * @return
     */
    int deleteByIdWithFill(T entity);


}
