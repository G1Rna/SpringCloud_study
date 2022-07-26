package com.G1Rna.springcloud.controller;

import com.G1Rna.springcloud.entity.Dept;
import com.G1Rna.springcloud.service.DeptService;
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

    @Autowired
    private DiscoveryClient client;

    @PostMapping("/dept/add")
    public boolean addDept(@RequestBody Dept dept){
        return deptService.addDept(dept);
    }

    @GetMapping("/dept/get/{deptNo}")
    public Dept queryDept(@PathVariable("deptNo") Long deptNo){
        return deptService.queryById(deptNo);
    }
    @GetMapping("/dept/getAll")
    public List<Dept> queryDept(){
        return deptService.queryAll();
    }

    @DeleteMapping("/dept/del/{deptNo}")
    public boolean deleteDpet(@PathVariable("deptNo") Long deptNo){
        return deptService.delDept(deptNo);
    }


    @GetMapping("/dept/discovery")
    public Object discovery() {
        // 获取微服务列表的清单
        List<String> services = client.getServices();
        System.out.println("discovery=>services:" + services);
        // 得到一个具体的微服务信息,通过具体的微服务id，applicaioinName；
        List<ServiceInstance> instances = client.getInstances("SPRINGCLOUD-PROVIDER-DEPT");
        for (ServiceInstance instance : instances) {
            System.out.println(
                    instance.getHost() + "\t" + // 主机名称
                            instance.getPort() + "\t" + // 端口号
                            instance.getUri() + "\t" + // uri
                            instance.getServiceId() // 服务id
            );
        }
        return this.client;
    }
}
