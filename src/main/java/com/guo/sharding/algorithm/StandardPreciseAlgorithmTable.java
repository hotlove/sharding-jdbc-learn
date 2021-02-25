package com.guo.sharding.algorithm;

import org.apache.shardingsphere.api.sharding.standard.PreciseShardingAlgorithm;
import org.apache.shardingsphere.api.sharding.standard.PreciseShardingValue;

import java.util.Collection;

/**
 * @Date: 2021/2/25 14:54
 * @Author 郭乐建
 * @Since JDK 1.8
 * @Description:
 */
public class StandardPreciseAlgorithmTable implements PreciseShardingAlgorithm<Long> {
    @Override
    public String doSharding(Collection<String> tableNames, PreciseShardingValue<Long> preciseShardingValue) {

        /**
         * tableNames: 所有分片表的集合
         * preciseShardingValue: 分片属性，其内部有以下属性
         *    logicTableName： 为逻辑表，
         *    columnName： 分片健（字段），
         *    value： 为从 SQL 中解析出的分片健的值
         */
        for (String tableName : tableNames) {
            String value = (preciseShardingValue.getValue() % tableNames.size() + 1)+ "";
            if (tableName.endsWith(value)) {
                return tableName;
            }
        }
        throw new IllegalArgumentException();
    }
}
