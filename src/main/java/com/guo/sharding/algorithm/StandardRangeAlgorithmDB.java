package com.guo.sharding.algorithm;

import org.apache.shardingsphere.api.sharding.standard.RangeShardingAlgorithm;
import org.apache.shardingsphere.api.sharding.standard.RangeShardingValue;

import java.util.Collection;

/**
 * @Date: 2021/2/25 14:55
 * @Author 郭乐建
 * @Since JDK 1.8
 * @Description:
 */
public class StandardRangeAlgorithmDB implements RangeShardingAlgorithm {
    @Override
    public Collection<String> doSharding(Collection collection, RangeShardingValue rangeShardingValue) {
        return null;
    }
}
