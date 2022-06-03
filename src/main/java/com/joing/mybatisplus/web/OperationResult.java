package com.joing.mybatisplus.web;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.io.Serializable;

/**
 * 处理结果对象，其他具体的业务功能中返回字段比较多的输出类时，输出类都需要先继承该类<br>
 *
 * @Author Join.Yao
 * @Version 1.0.0
 * @CreateTime 2020年02月14日 14:08
 */
@ApiModel(description = "返回结果")
@Slf4j
@Data
public class OperationResult<T> implements Serializable {

    /**
     * 交易成功码常量
     */
    public static final String OK = "0";

    /**
     * 返回码
     */
    @ApiModelProperty(value = "返回码, 处理成功返回0，系统异常返回对应错误码", required = true, example = "0")
    private String resultCode = "0";

    /**
     * 返回消息
     */
    @ApiModelProperty(value = "返回消息, 系统异常返回错误描述信息", required = true, example = "ok")
    private String resultMessage = "ok";

    /**
     * 业务数据对象
     */
    @ApiModelProperty(value = "返回数据, 接口请求数据", required = true)
    T data = null;

    private static final long serialVersionUID = 6044849293418983828L;

    /**
     * 交易正常
     *
     * @return
     */
    public static OperationResult success() {
        return new OperationResult();
    }

    /**
     * 交易正常调用带数据
     *
     * @param data
     * @return
     */
    public static OperationResult success(Object data) {
        return new OperationResult(data);
    }

    /**
     * 自定义的错误信息返回
     *
     * @param errorMsg
     * @return
     */
    public OperationResult() {

    }

    /**
     * 设置返回信息的构造方法,用于成功时返回明确的成功消息
     *
     * @param resultMessage 返回详细提示消息
     */
    public OperationResult(String resultMessage) {
        this.resultMessage = resultMessage;
    }

    /**
     * 设置返回码和返回信息的构造方法,一般用于发生错误时设置
     *
     * @param resultCode    错误码
     * @param resultMessage 错误信息
     */
    public OperationResult(String resultCode, String resultMessage) {
        this.resultCode = resultCode;
        this.resultMessage = resultMessage;
    }

    /**
     * 正确情况下,只设置业务对象的构造方法
     *
     * @param data 业务数据对象
     */
    public OperationResult(T data) {
        this.data = data;
    }

}
