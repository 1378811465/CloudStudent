package cn.gxw.providerProject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableEurekaClient //开启EurekaClient功能
@EnableZuulProxy    //开启Zuul
public class ZuulProjectApplication9527 {
    public static void main(String[] args) {
        SpringApplication.run(ZuulProjectApplication9527.class);
    }
}
