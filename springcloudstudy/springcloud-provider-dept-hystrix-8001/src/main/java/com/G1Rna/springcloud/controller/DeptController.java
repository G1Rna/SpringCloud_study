package com.G1Rna.springcloud.controller;

import com.G1Rna.springcloud.entity.Dept;
import com.G1Rna.springcloud.service.DeptService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//提供Restful服务
@RestController
public class DeptController {

    @Autowired
    private DeptService deptService;



    @HystrixCommand(fallbackMethod = "queryDeptFallBack")
    @GetMapping("/dept/get/{deptNo}")
    public Dept queryDept(@PathVariable("deptNo") Long deptNo){
        Dept dept = deptService.queryById(deptNo);
        if (dept == null){
            throw new RuntimeException("这个id=>"+deptNo+",不存在该用户，或信息无法找到~");
        }
            return dept;
    }

    public Dept queryDeptFallBack(@PathVariable("deptNo") Long deptNo){
        return new Dept().setDeptno(deptNo)
                .setDeptname("这个id=>"+deptNo+",没有对应的信息,null---@Hystrix~")
                .setDb_source("在MySQL中没有这个数据库");
    }
}
