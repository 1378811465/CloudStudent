package cn.gxw.consumersProject.controller;

import cn.gxw.publicApi.service.StudentClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
public class ConsumersController {
    @Autowired
    private StudentClientService service;

    @RequestMapping(value = "/consumers/test")
    public String test(){
        System.out.println("进入");
        return this.service.test();
    }

    @RequestMapping(value = "/consumers/discovery", method = RequestMethod.GET)
    public Object discovery(){
       // return this.service.discovery();
        return "22";
    }
}
