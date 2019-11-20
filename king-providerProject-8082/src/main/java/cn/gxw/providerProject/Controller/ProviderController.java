package cn.gxw.providerProject.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProviderController {

    @Autowired
    private DiscoveryClient client;

    @GetMapping("/provider/test")
    public String test(){
        return "欢迎进入测试提供者2！ ";
    }

    @RequestMapping(value = "/provider/discovery", method = RequestMethod.GET)
    public Object discovery(){
        List<String> list = client.getServices();
        System.out.println("*****" + list);
        List<ServiceInstance> serverList = client.getInstances("providerProject");
        for(ServiceInstance instance : serverList){
            System.out.println(
                    instance.getServiceId() + "\t" +
                    instance.getHost() + "\t" +
                    instance.getPort() + "\t" +
                    instance.getUri());
        }
        return client;
    }
}
