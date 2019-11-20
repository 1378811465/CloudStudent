package cn.gxw.consumersProject;

import cn.gxw.myRule.MySelfRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableEurekaClient
@RibbonClient(name = "PROVIDERPROJECT",configuration = MySelfRule.class)
public class ConsumersApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConsumersApplication.class);
    }
}
