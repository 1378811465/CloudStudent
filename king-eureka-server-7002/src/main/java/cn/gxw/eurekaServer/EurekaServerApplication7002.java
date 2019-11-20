package cn.gxw.eurekaServer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class EurekaServerApplication7002 {
    public static void main(String[] args) {
        SpringApplication.run(EurekaServerApplication7002.class);
    }
}
