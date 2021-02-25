package com.guo.sharding.algorithm;

import org.apache.shardingsphere.api.sharding.standard.RangeShardingAlgorithm;
import org.apache.shardingsphere.api.sharding.standard.RangeShardingValue;

import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * @Date: 2021/2/25 14:55
 * @Author 郭乐建
 * @Since JDK 1.8
 * @Description:
 */
public class StandardRangeAlgorithmTable implements RangeShardingAlgorithm<Integer> {
    @Override
    public Collection<String> doSharding(Collection<String> tableNames, RangeShardingValue<Integer> rangeShardingValue) {
        Set<String> result = new LinkedHashSet<>();
        // between and 的起始值
        int lower = rangeShardingValue.getValueRange().lowerEndpoint();
        int upper = rangeShardingValue.getValueRange().upperEndpoint();
        // 循环范围计算分库逻辑
        for (int i = lower; i <= upper; i++) {
            for (String tableName : tableNames) {
                if (tableName.endsWith((i % tableNames.size() + 1) + "")) {
                    result.add(tableName);
                }
            }
        }
        return result;
    }
}
