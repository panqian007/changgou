package com.changgou;/**
 * @Author panqian
 * @Date 2020/9/1 9:30
 * @Version 1.0.0
 */

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.scheduling.annotation.EnableAsync;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @Author panqian
 * @Date 2020/9/1 9:30
 * @Version 1.0.0
 */
@SpringBootApplication
@EnableEurekaClient
@EnableAsync
@MapperScan(basePackages = {"com.changgou.dao"})
public class GoodsApplication {
    public static void main(String[] args) {
        SpringApplication.run(GoodsApplication.class,args);
    }
}
