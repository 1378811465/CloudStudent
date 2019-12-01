package com.gxw.consumersProject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.context.annotation.ComponentScan;
@SpringBootApplication
@EnableHystrixDashboard //启动熔断监听
public class ConsumersApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConsumersApplication.class);
    }
}
