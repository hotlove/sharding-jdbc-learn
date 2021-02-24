package com.guo.sharding.dao;

import com.guo.sharding.BootStrap;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Random;

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

    @Value("${spring.profiles.active}")
    String pvalue;

    @Test
    public void testInsertOrder() {
        for (int i = 1; i < 20; i++) {
            orderDao.insertOrder(new BigDecimal(i), 1L, "sucess");
        }
    }

    @Test
    public void testSelectOrder() {
        List<Map> maps = orderDao.selectOrderByIds(Arrays.asList(571280340715307008L, 571280341398978561L));
        System.out.println(maps);
    }

    @Test
    public void testInsertProfile() {
        for (int i = 10; i < 20; i++) {
            orderDao.insertProfile("user_" + i, i, "adress_" + i);
        }
        testInsertOrder();

    }

    @Test
    public void testValue() {
        System.out.println("value----------"+pvalue);
    }
}
