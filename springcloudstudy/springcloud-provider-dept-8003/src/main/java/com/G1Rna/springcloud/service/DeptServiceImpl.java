package com.G1Rna.springcloud.service;

import com.G1Rna.springcloud.dao.DeptDao;
import com.G1Rna.springcloud.entity.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeptServiceImpl implements DeptService {

    @Autowired
    private DeptDao deptDao;

    @Override
    public boolean addDept(Dept dept) {
        return deptDao.addDept(dept);
    }

    @Override
    public Dept queryById(Long deptNo) {
        return deptDao.queryById(deptNo);
    }

    @Override
    public List<Dept> queryAll() {
        return deptDao.queryAll();
    }

    @Override
    public boolean delDept(Long deptNo) {
        return deptDao.delDept(deptNo);
    }
}
