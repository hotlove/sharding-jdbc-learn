package com.guo.sharding.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

/**
 * @Auther: hotlove_linx
 * @Date: 2020/5/24 15:25
 * @Description:
 */
@Mapper
@Component
public interface LearnMysqlDao {
    @Insert("insert into s1(key1, key2, key3, key_part1, key_part2, key_part3, common_field, num) values (#{k1}, #{k2}, #{k3}, #{key_part1}, #{key_part2}, #{key_part3}, #{common_field}, #{num})")
    int insertk(@Param("k1") String k1, @Param("k2") Integer k2, @Param("k3") String k3, @Param("key_part1") String key_part1,
                @Param("key_part2") String key_part2, @Param("key_part3") String key_part3, @Param("common_field") String common_field, @Param("num")Integer num);
}
