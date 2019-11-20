package cn.gxw.providerProject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient //开启EurekaClient功能
@EnableDiscoveryClient //开启服务发现
public class ProviderProjectApplication8081 {
    public static void main(String[] args) {
        SpringApplication.run(ProviderProjectApplication8081.class);
    }
}
