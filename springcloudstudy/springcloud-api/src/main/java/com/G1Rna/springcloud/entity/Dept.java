package com.G1Rna.springcloud.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
@NoArgsConstructor
@Accessors(chain = true)  //链式写法 dept.setdname().setdbsource
public class Dept implements Serializable {  //分布式中的实体类需要实现序列化,方便网络传输
    private Long deptno;
    private String deptname;
    //这个数据存在哪个数据库的字段~微服务   一个服务对应一个数据库  相同的信息可能存在不同的数据库
    private String db_source;

    public Dept(String dname) {
        this.deptname = dname;
    }
}