package com.itheima.service;

import com.itheima.pojo.Emp;
import com.itheima.pojo.PageBean;

import java.time.LocalDate;
import java.util.List;

/**
 * 员工管理
 */
public interface EmpService {
    /**
     * 分页查询
     * @param page
     * @param pageSize
     * @return
     */
    PageBean page(Integer page, Integer pageSize,String name, Short gender,
                  LocalDate begin,
                  LocalDate end);

    void delete(List<Integer> ids);

    void add(Emp emp);

    Emp select(Integer id);

    void update(Emp emp);

    Emp getByUsernameAndPassword(Emp emp);
}
