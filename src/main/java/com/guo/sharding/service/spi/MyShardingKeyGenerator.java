package com.guo.sharding.service.spi;

import org.apache.shardingsphere.spi.keygen.ShardingKeyGenerator;
import org.springframework.stereotype.Component;

import java.util.Properties;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @Date: 2021/2/26 9:26
 * @Author 郭乐建
 * @Since JDK 1.8
 * @Description:
 */
public class MyShardingKeyGenerator implements ShardingKeyGenerator {

    private final AtomicLong count = new AtomicLong();

    @Override
    public Comparable<?> generateKey() {
        return count.incrementAndGet();
    }

    @Override
    public String getType() {
        return "SELF_KEY_GENERATOR";
    }

    @Override
    public Properties getProperties() {
        return null;
    }

    @Override
    public void setProperties(Properties properties) {

    }
}
