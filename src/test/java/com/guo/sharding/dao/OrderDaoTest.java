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
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

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
        List<Map> maps = orderDao.selectOrderByIds(Arrays.asList(571656316867575808L, 571656817839439873L));
        System.out.println(maps);
    }

    @Test
    public void testInsertProfile() {
        for (int i = 10; i < 20; i++) {
            orderDao.insertProfile("user_" + i, i, "adress_" + i);
        }
//        testInsertOrder();

    }

    @Test
    public void testPark() {
        Thread t = Thread.currentThread();
        new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(5);
                LockSupport.unpark(t);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        int count = 0;
        for (;;) {
            System.out.println(count++);
            LockSupport.park(Thread.currentThread());
        }



    }

    @Test
    public void testcom() {
        Long a = new Long(0);
        System.out.println(a.longValue()==0L);
    }
}
