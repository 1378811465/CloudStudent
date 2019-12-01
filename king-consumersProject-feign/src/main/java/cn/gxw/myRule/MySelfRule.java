package cn.gxw.myRule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import com.netflix.loadbalancer.RetryRule;
import com.netflix.loadbalancer.RoundRobinRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MySelfRule {

    @Bean
    public IRule myRule() {
        //return new RoundRobinRule();//轮询算法
        //return new RetryRule();//(重试算法)先按照轮询算法的策略获取服务，如果获取服务失败在指定时间重试，获取可用的服务
        //return new RandomRule();//随机算法
        return new RoundRobinRule_self();//自定义算法
    }
}
