package com.changgou.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class RedisTest {
    @Resource
    private RedisUtils redisUtils;

    /**
     * 插入缓存数据
     */
    @Test
    public void set() {
        redisUtils.set("ceshi", "redis数据");
    }

    @Test
    public void setE() {
        redisUtils.setOfExpire("ceshi", "redis数据过期30s",30, TimeUnit.SECONDS);
    }

    /**
     * 读取缓存数据
     */
    @Test
    public void get() {
        String value = redisUtils.get("ceshi");
        System.out.println(value);
    }
}
