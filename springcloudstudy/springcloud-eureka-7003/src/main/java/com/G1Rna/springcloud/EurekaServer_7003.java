package com.G1Rna.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

//启动后访问 http://localhost:7001/
@EnableEurekaServer//EnableEurekaServer 服务器端的启动类，可以接受别人注册进来
@SpringBootApplication
public class EurekaServer_7003 {
    public static void main(String[] args) {
        SpringApplication.run(EurekaServer_7003.class,args);
    }
}
