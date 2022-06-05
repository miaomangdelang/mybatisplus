package com.joing.mybatisplus.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;

import java.util.Optional;
import java.util.stream.Stream;

/**
 * @author Join.Yao (pathinfuture@163.com)
 * @date 2022/05/25 17:32
 */
@Getter
public enum SexEnum implements BaseEnum {

    /**
     * 男
     */
    MALE(1, "男"),

    /**
     * 女
     */
    FEMALE(2, "女");

    /**
     * 将注解所标识的属性的值存储到数据库中
     */
    @EnumValue
    private final Integer code;

    @JsonValue
    private final String name;

    SexEnum(Integer code, String name) {
        this.code = code;
        this.name = name;
    }

    /**
     * 自定义JSON反序列化
     *
     * @param code 类型code
     * @return {@link SexEnum} code所对应的枚举
     */
    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public static SexEnum getByCode(Integer code) {
        Optional<SexEnum> enumOptional = Stream.of(SexEnum.values()).filter(typeEnum -> typeEnum.getCode().equals(code)).findFirst();
        return enumOptional.orElse(null);
    }

}
