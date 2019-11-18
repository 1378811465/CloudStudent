package cn.gxw.consumersProject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
public class ConsumersController {
    private static final String URL = "http://127.0.0.1:8081";

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
