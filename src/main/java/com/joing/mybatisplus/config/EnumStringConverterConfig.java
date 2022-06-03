package com.joing.mybatisplus.config;

import com.google.common.collect.Maps;
import com.joing.mybatisplus.enums.BaseEnum;
import lombok.Data;
import org.springframework.core.convert.converter.Converter;
import org.springframework.core.convert.converter.ConverterFactory;

import java.util.Map;
import java.util.Objects;

/**
 * Integer值转为枚举配置
 *
 * @author huangTT(bluehtt @ gmail.com)
 * @version 1.0
 * @date 2020/6/14
 */
public class EnumStringConverterConfig implements ConverterFactory<Integer, BaseEnum> {

    private static final Map<Class, Converter> CONVERTERS = Maps.newHashMap();

    /**
     * 获取一个从 Integer 转化为 T 的转换器，T 是一个泛型，有多个实现
     *
     * @param targetType 转换后的类型
     * @return 返回一个转化器
     */
    @Override
    public <T extends BaseEnum> Converter<Integer, T> getConverter(Class<T> targetType) {
        Converter<Integer, T> converter = CONVERTERS.get(targetType);
        if (converter == null) {
            converter = new IntegerToEnumConverter(targetType);
            CONVERTERS.put(targetType, converter);
        }
        return converter;
    }

    /**
     * Integer枚举转化类
     *
     * @author huangTT(bluehtt @ gmail.com)
     * @version 1.0
     * @date 2020/6/14
     */
    @Data
    public static class IntegerToEnumConverter<T extends BaseEnum> implements Converter<Integer, T> {
        private Map<Integer, T> enumMap = Maps.newHashMap();

        public IntegerToEnumConverter(Class<T> enumType) {
            T[] enums = enumType.getEnumConstants();
            for (T e : enums) {
                enumMap.put(e.getCode(), e);
            }
        }

        @Override
        public T convert(Integer source) {
            T t = enumMap.get(source);
            if (Objects.isNull(t)) {
                throw new IllegalArgumentException("无法匹配对应的枚举类型");
            }
            return t;
        }
    }
}
