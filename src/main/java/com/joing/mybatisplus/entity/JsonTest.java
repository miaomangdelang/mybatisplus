package com.joing.mybatisplus.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.handlers.JacksonTypeHandler;
import com.joing.mybatisplus.dto.JsonInfo;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 测试json
 *
 * @author Join.Yao (pathinfuture@163.com)
 * @date 2022/06/02 09:12
 */
@Data
@TableName(value = "json_test", autoResultMap = true)
public class JsonTest implements Serializable {

    /**
     * id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * jsonStr
     */
    @TableField(value = "json_info", typeHandler = JacksonTypeHandler.class)
    private JsonInfo jsonInfo;

    /**
     * json_list
     */
    @TableField(value = "json_list", typeHandler = JacksonTypeHandler.class)
    private List<JsonInfo> jsonList;

    private static final long serialVersionUID = -6114775394466820943L;

}