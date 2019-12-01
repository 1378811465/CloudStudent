package cn.gxw.publicApi.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/*Feign根据细粒化，通过服务注册中心，通过服务名选择此服务名多个服务里适当的微服务进行访问*/
@FeignClient(value = "PROVIDERPROJECT", fallbackFactory = StudentClientServiceFallBack.class)
public interface StudentClientService {
    @GetMapping("/provider/test")
    public String test();

    @RequestMapping(value = "/provider/discovery", method = RequestMethod.GET)
    public Object discovery();
}
