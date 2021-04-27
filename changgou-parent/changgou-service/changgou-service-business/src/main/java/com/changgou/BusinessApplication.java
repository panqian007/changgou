package com.changgou;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @Author panqian
 * @Date 2020/11/25 11:56
 * @Version 1.0.0
 */
@SpringBootApplication
@EnableEurekaClient
@MapperScan(basePackages = {"com.changgou.dao"})
public class BusinessApplication {
    public static void main(String[] args) {
        SpringApplication.run(BusinessApplication.class,args);
    }
}
