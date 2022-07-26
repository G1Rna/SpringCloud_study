package com.G1Rna.springcloud.controller;

import com.G1Rna.springcloud.entity.Dept;
import com.G1Rna.springcloud.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//提供Restful服务
@RestController
public class DeptController {

    @Autowired
    private DeptService deptService;

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

}
