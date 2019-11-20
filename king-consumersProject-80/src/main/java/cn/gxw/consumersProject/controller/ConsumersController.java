package cn.gxw.consumersProject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
public class ConsumersController {
    //private static final String URL = "http://127.0.0.1:8081";
    //微服务应用名，可以从服务注册中心多个集群服务实现负载均衡区访问最适合的微服务
    //如果服务注册中心有多个服务提供者Ribbon默认会通过轮询算法进行访问提供者
    private static final String URL = "http://PROVIDERPROJECT";

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/consumers/test")
    public String test(){
        String content = restTemplate.getForObject(URL + "/provider/test", String.class);
        System.out.println(content);
        return content;
    }

    @RequestMapping(value = "/consumers/discovery", method = RequestMethod.GET)
    public Object discovery(){
        return restTemplate.getForObject(URL + "/provider/discovery", Object.class);
    }
}
