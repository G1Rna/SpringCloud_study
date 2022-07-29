package com.G1Rna.myrule;

import com.netflix.loadbalancer.IRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/*该包不要和主启动类所在的包同级，要跟启动类所在包同级*/
@Configuration
public class MyRule {
    //注意bean重名
    @Bean
    public IRule myRule1(){
        return new MyRandomRule();
    }
}