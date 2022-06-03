package com.joing.mybatisplus.method;

import com.baomidou.mybatisplus.core.enums.SqlMethod;
import com.baomidou.mybatisplus.core.injector.AbstractMethod;
import com.baomidou.mybatisplus.core.metadata.TableFieldInfo;
import com.baomidou.mybatisplus.core.metadata.TableInfo;
import com.baomidou.mybatisplus.core.toolkit.sql.SqlScriptUtils;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.SqlSource;

import java.util.function.Predicate;

/**
 * 根据 ID 更新固定的那几个字段(但是不包含逻辑删除)
 *
 * <p>
 * 自己的通用 mapper 如下使用:
 * <pre>
 * int alwaysUpdateSomeColumnById(@Param(Constants.ENTITY) T entity);
 * </pre>
 * </p>
 *
 *
 * @author hubin
 * @since 2019-04-12
 */
@SuppressWarnings("serial")
public class AlwaysUpdateSomeColumnById extends AbstractMethod {

    /**
     * 字段筛选条件
     */
    @Setter
    @Accessors(chain = true)
    private Predicate<TableFieldInfo> predicate;

    /**
     * @param name      方法名
     * @param predicate 筛选条件
     * @since 3.5.0
     */
    public AlwaysUpdateSomeColumnById(String name, Predicate<TableFieldInfo> predicate) {
        super(name);
        this.predicate = predicate;
    }

    public AlwaysUpdateSomeColumnById() {
        super("alwaysUpdateSomeColumnById");
    }

    /**
     * @param predicate 筛选条件
     */
    public AlwaysUpdateSomeColumnById(Predicate<TableFieldInfo> predicate) {
        super("alwaysUpdateSomeColumnById");
        this.predicate = predicate;
    }

    @Override
    public MappedStatement injectMappedStatement(Class<?> mapperClass, Class<?> modelClass, TableInfo tableInfo) {
        SqlMethod sqlMethod = SqlMethod.UPDATE_BY_ID;
        final String additional = optlockVersion(tableInfo) + tableInfo.getLogicDeleteSql(true, true);
        String sqlSet = this.filterTableFieldInfo(tableInfo.getFieldList(), getPredicate(),
                i -> i.getSqlSet(true, ENTITY_DOT), NEWLINE);
        sqlSet = SqlScriptUtils.convertSet(sqlSet);
        String sql = String.format(sqlMethod.getSql(), tableInfo.getTableName(), sqlSet,
                tableInfo.getKeyColumn(), ENTITY_DOT + tableInfo.getKeyProperty(), additional);
        SqlSource sqlSource = languageDriver.createSqlSource(configuration, sql, modelClass);
        return addUpdateMappedStatement(mapperClass, modelClass, getMethod(sqlMethod), sqlSource);
    }

    private Predicate<TableFieldInfo> getPredicate() {
        Predicate<TableFieldInfo> noLogic = t -> !t.isLogicDelete();
        if (predicate != null) {
            return noLogic.and(predicate);
        }
        return noLogic;
    }

}