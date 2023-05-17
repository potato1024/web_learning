package com.itheima.controller;

import com.itheima.anno.Log;
import com.itheima.pojo.Emp;
import com.itheima.pojo.PageBean;
import com.itheima.pojo.Result;
import com.itheima.service.EmpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

/**
 * 员工管理Controller
 */
@Slf4j
@RestController
@RequestMapping("/emps")
public class EmpController {


    @Autowired
    private EmpService empService;

    @GetMapping
    public Result page(@RequestParam(defaultValue = "1") Integer page,
                       @RequestParam(defaultValue = "10") Integer pageSize,
                       String name, Short gender,
                       @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate begin,
                       @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate end) {

        log.info("分页查询，参数：{},{},{},{},{},{}", page, pageSize, name, gender, begin, end);


        PageBean pageBean = empService.page(page, pageSize, name, gender,
                begin,
                end);


        return Result.success(pageBean);
    }

    @DeleteMapping("/{ids}")
    @Log
    public Result delete(@PathVariable List<Integer> ids) {
        log.info("批量删除：ids:{}", ids);
        empService.delete(ids);

        return Result.success();

    }
    @GetMapping("/{id}")
    public Result select(@PathVariable Integer id){

        log.info("根据id查询：{}, ",id);
        Emp emp = empService.select(id);
        return Result.success(emp);
    }


    @PostMapping
    @Log
    public Result add(@RequestBody  Emp emp){
        log.info("新增员工：{}", emp);
        empService.add(emp);


        return Result.success();
    }

    @PutMapping
    @Log
    public Result update(@RequestBody Emp emp){
        log.info("修改员工id：{}",emp.getId());
        empService.update(emp);
        return  Result.success();
    }

}
