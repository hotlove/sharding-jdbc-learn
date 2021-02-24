package com.guo.sharding.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 * @Auther: hotlove_linx
 * @Date: 2020/4/27 21:41
 * @Description:
 */
@Mapper
@Component
public interface OrderDao {

    // 注意这里的t_ordershi配置中的逻辑表名
    @Insert("insert into t_order(order_id, price, user_id, status) values (#{price}, #{userId}, #{status})")
    int insertOrder(@Param("price")BigDecimal price, @Param("userId")Long userId, @Param("status")String status);

    // 根据id列表查询订单
    @Select("<script>" + "select " +
            "* " +
            "from t_order t " +
            "where t.order_id in " +
            "<foreach collection='orderIds' open='(' close=')' item='id' separator=',' index='index'>" +
            "#{id}" +
            "</foreach>" +
            "</script>")
    List<Map> selectOrderByIds(@Param("orderIds") List<Long> orderIds);

    @Insert("insert into profile(profile_id, user_name, vip_grade, address) values(#{userName}, #{vipGrade}, #{address})")
    int insertProfile(@Param("userName") String userName, @Param("vipGrade") Integer vipGrade, @Param("address") String address);
}
