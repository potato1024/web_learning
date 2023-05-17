package com.itheima.controller;


import com.itheima.anno.Log;
import com.itheima.pojo.Dept;
import com.itheima.pojo.Result;
import com.itheima.service.DeptService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 部门管理Controller
 */
@Slf4j
@RestController
@RequestMapping("/depts")
public class DeptController {

    @Autowired
    private DeptService deptService;

    /**
     * 查询数据
     * @return
     */
    @GetMapping
    public Result list(){

    log.info("查询全部部门信息");

    List<Dept> deptList= deptService.list();
    return Result.success(deptList);
    }


    /**
     * 删除数据
     * @return
     */
    @DeleteMapping("/{id}")
    @Log
    public Result delete(@PathVariable Integer id) throws Exception {

        log.info("根据id删除部门：{}",id);
        deptService.delete(id);
        return Result.success();
    }
    /**
     * 新增数据
     * @return
     */
    @PostMapping
    @Log
    public Result add(@RequestBody Dept dept){

        log.info("新增部门：{}",dept);
        deptService.add(dept);
        return Result.success();
    }

    /**
     * 根据id查询部门
     * @return
     */
    @GetMapping("/{id}")
    public Result select(@PathVariable Integer id){

        log.info("根据id查询部门信息：{}",id);

        Dept dept = deptService.select(id);
        return Result.success(dept);
    }


    /**
     * 修改部门
     *
     * @return
     */
    @PutMapping
    @Log
    public Result update(@RequestBody Dept dept){

        log.info("修改部门信息");
        deptService.update(dept);
        return Result.success();
    }

}
