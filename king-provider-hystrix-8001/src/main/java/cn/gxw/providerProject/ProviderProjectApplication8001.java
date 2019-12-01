package cn.gxw.providerProject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

@SpringBootApplication
@EnableEurekaClient //开启EurekaClient功能
@EnableDiscoveryClient //开启服务发现
@EnableHystrix  //开启熔断
public class ProviderProjectApplication8001 {
    public static void main(String[] args) {
        SpringApplication.run(ProviderProjectApplication8001.class);
    }
}
