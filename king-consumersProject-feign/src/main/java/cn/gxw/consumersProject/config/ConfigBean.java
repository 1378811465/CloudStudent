package cn.gxw.consumersProject.config;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import com.netflix.loadbalancer.RetryRule;
import com.netflix.loadbalancer.RoundRobinRule;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ConfigBean { //@Configuration == applicationContext.xml

    @Bean
    @LoadBalanced// 客户端 负载均衡启动注解
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }

    @Bean
    public IRule myRule() {
        //return new RoundRobinRule();//轮询算法
        return new RetryRule();//(重试算法)先按照轮询算法的策略获取服务，如果获取服务失败在指定时间重试，获取可用的服务
        //return new RandomRule();//随机算法
    }

}
