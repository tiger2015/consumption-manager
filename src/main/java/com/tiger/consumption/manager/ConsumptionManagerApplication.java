package com.tiger.consumption.manager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

/**
 * @Auther: Zeng Hu
 * @Date: 2020/7/25 15:46
 * @Description:
 * @Version: 1.0
 **/
@SpringBootApplication
@EnableCaching
public class ConsumptionManagerApplication {

    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(ConsumptionManagerApplication.class);
        application.run(args);
    }
}
