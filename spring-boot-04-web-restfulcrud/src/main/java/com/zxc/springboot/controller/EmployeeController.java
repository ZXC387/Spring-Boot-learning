package com.zxc.springboot.controller;

import com.zxc.springboot.dao.DepartmentDao;
import com.zxc.springboot.dao.EmployeeDao;
import com.zxc.springboot.entities.Department;
import com.zxc.springboot.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

/**
 * @author ZXC
 * @create 2021-01-18 10:41
 */
@Controller
public class EmployeeController {
    @Autowired
    EmployeeDao employeeDao;

    @Autowired
    DepartmentDao departmentDao;

    //查询所有员工返回列表页面
    @GetMapping("/emps")
    public String list(Model model) {
        Collection<Employee> emps = employeeDao.getAll();
        //放在请求域中
        model.addAttribute("emps",emps);
        //thymeleaf 默认就会拼串
        //classpath：/templates/xxx.html
        return "emp/list";
    }

    //返回员工添加页面
    @GetMapping("/emp")
    public String toAddPage(Model model){
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("depts",departments);
        return "emp/add";
    }

    //员工添加
    //SpringMVC自动将请求参数和入参对象的属性进行一一绑定
    //要求请求参数名字和javaBean入参对象里面的属性名称一致
    @PostMapping("/emp")
    public String addEmp(Employee employee){
        //保存员工
        employeeDao.save(employee);
        //添加完成来到员工列表页面
        //redirect：表示重定向一个地址  /代表当前项目路径
        //forward：表示转发到一个地址
        return "redirect:/emps";
    }

    //返回员工修改页面
    @GetMapping("/emp/{id}")
    public String toEditPage(@PathVariable("id") Integer id, Model model){
        Employee employee = employeeDao.get(id);
        model.addAttribute("emp",employee);
        //查询出部门
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("depts",departments);
        return  "emp/add";
    }

    //员工修改 ,需要提交员工的id
    @PutMapping("/emp")
    public String editEmp(Employee employee){
        System.out.println(employee);
        employeeDao.save(employee);
        return "redirect:/emps";
    }

    //删除员工
    @DeleteMapping("/emp/{id}")
    public  String deleteEmp(@PathVariable("id") Integer id){
        employeeDao.delete(id);
        return "redirect:/emps";
    }
}
