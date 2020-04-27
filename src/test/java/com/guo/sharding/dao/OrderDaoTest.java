package com.guo.sharding.dao;

import com.guo.sharding.BootStrap;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * @Auther: hotlove_linx
 * @Date: 2020/4/27 21:51
 * @Description:
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {BootStrap.class})
public class OrderDaoTest {

    @Resource
    OrderDao orderDao;

    @Test
    public void testInsertOrder() {
        for (int i = 1; i < 20; i++) {
            orderDao.insertOrder(new BigDecimal(i), 1L, "sucess");
        }
    }

    @Test
    public void testSelectOrder() {
        List<Map> maps = orderDao.selectOrderByIds(Arrays.asList(461651844507107328L, 461651844704239617L));
        System.out.println(maps);
    }
}
