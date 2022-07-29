package com.G1Rna.springcloud.config;

import com.G1Rna.myrule.MyRandomRule;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ConfigBean {

    @Bean
    @LoadBalanced//配置负载均衡实现RestTemplate
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }


    @Bean
    public IRule myRule(){
        // RoundRobinRule 轮询
        // RandomRule 随机
        // AvailabilityFilteringRule :会先过滤掉，跳闸，访问故障的服务~,对剩下的进行轮询
        // RetryRule :会先按照轮询获取服务~，如果服务获取失败，则会在指定的时间内进行，重试
        return new RandomRule();//使用随机策略
        //return new RoundRobinRule();//使用轮询策略
        //return new AvailabilityFilteringRule();//使用轮询策略
        //return new RetryRule();//使用轮询策略
    }
}
