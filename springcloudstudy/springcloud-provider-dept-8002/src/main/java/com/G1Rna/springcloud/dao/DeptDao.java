package com.G1Rna.springcloud.dao;

import com.G1Rna.springcloud.entity.Dept;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface DeptDao {

public boolean addDept(Dept dept);

public Dept queryById(Long deptNo);

public List<Dept> queryAll();

public boolean delDept(Long deptNo);


}
