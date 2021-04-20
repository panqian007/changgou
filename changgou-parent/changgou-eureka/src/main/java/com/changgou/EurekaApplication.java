package com.changgou;/**
 * @Author panqian
 * @Date 2020/8/31 14:51
 * @Version 1.0.0
 */

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @Author panqian
 * @Date 2020/8/31 14:51
 * @Version 1.0.0
 */
@SpringBootApplication
@EnableEurekaServer
public class EurekaApplication {
    public static void main(String[] args) {
        SpringApplication.run(EurekaApplication.class,args);
    }
}
