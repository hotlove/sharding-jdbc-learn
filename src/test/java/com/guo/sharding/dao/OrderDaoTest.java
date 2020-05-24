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

    @Resource
    LearnMysqlDao learnMysqlDao;

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

    @Test
    public void testLearnMysql() {
        String [] str = new String[]{"a", "b", "c", "d", "e", "f", "g", "h", "j", "k", "l", "m", "n", "o", "p", "q", "r", "t",
                "A", "B", "C", "D", "E", "F", "G", "H", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "T"};

        Random random = new Random();

        for (int i = 0; i < 10000; i++) {
            int k1 = random.nextInt(36);
//            int k2 = random.nextInt(36);
            int k3 = random.nextInt(36);
            int kp1 = random.nextInt(36);
            int kp2 = random.nextInt(36);
            int kp3 = random.nextInt(36);
            int kc = random.nextInt(36);
            learnMysqlDao.insertk(str[k1], i, str[k3], str[kp1], str[kp2],str[kp3],str[kc]);
        }
    }
}
