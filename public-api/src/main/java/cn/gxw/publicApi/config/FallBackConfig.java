package cn.gxw.publicApi.config;

import cn.gxw.publicApi.service.StudentClientServiceFallBack;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FallBackConfig {

    @Bean
    public StudentClientServiceFallBack studentClientServiceFallBack(){
        return new StudentClientServiceFallBack();
    }
}
