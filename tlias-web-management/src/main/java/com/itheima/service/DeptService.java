package com.itheima.service;

import com.itheima.pojo.Dept;

import java.util.List;

/**
 * 部门管理
 */
public interface DeptService {
    /**
     * 查询全部部门信息
     * @return
     */
    List<Dept> list();

    /**
     * 删除部门
     */
    void delete(Integer id) throws Exception;



    /**
     * 新增部门
     */
    void add(Dept dept);

    Dept select(Integer id);


    void update(Dept dept);
}
