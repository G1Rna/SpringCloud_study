package com.G1Rna.springcloud.controller;

import com.G1Rna.springcloud.entity.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class DeptConsumerController {
//消费者不应该有service层




    @Autowired
    private RestTemplate restTemplate;
    /**
     * 服务提供方地址前缀
     */
//        private static final String REST_URL_PERFIX = "http://localhost:8001";
    //Ribbon:我们这里的地址，应该是一个变量，通过服务名来访问
    private static final String REST_URL_PERFIX = "http://SPRINGCLOUD-PROVIDER-DEPT";

    @RequestMapping("consumer/dept/add")
    public boolean addDpet(Dept dept){
        return restTemplate.postForObject(REST_URL_PERFIX+"/dept/add",dept,Boolean.class);
    }

    @RequestMapping("consumer/dept/get/{deptNo}")
    public Dept get(@PathVariable("deptNo") Long deptNo){
        return restTemplate.getForObject(REST_URL_PERFIX+"/dept/get/"+deptNo,Dept.class);
    }

    @RequestMapping("consumer/dept/getAll")
    public List<Dept> getAll(){
        return restTemplate.getForObject(REST_URL_PERFIX+"/dept/getAll",List.class);
    }

    @RequestMapping("consumer/dept/delete/{deptNo}")
    public void delDept(@PathVariable("deptNo") Long deptNo){
        restTemplate.delete(REST_URL_PERFIX+"/dept/del/"+deptNo);
    }

}
