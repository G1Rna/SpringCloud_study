package com.G1Rna.springcloud.service;

import com.G1Rna.springcloud.entity.Dept;

import java.util.List;

public interface DeptService {

    public boolean addDept(Dept dept);

    public Dept queryById(Long deptNo);

    public List<Dept> queryAll();

    public boolean delDept(Long deptNo);

}
