package cn.gxw.publicApi.service;

import feign.hystrix.FallbackFactory;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan// 不能忘记加，不然此类无法生效
public class StudentClientServiceFallBack implements FallbackFactory<StudentClientService> {
    @Override
    public StudentClientService create(Throwable throwable) {
        return new StudentClientService(){
            @Override
            public String test() {
                return "访问/test接口错误";
            }

            @Override
            public Object discovery() {
                return "访问/discovery接口错误";
            }
        };
    }
}
