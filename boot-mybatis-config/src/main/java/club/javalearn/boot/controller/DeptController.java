package club.javalearn.boot.controller;

import club.javalearn.boot.mapper.DepartmentMapper;
import club.javalearn.boot.mapper.EmployeeMapper;
import club.javalearn.boot.model.Department;
import club.javalearn.boot.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * learn-parent
 *
 * @author king-pan
 * @date 2018-05-24
 **/
@RestController
public class DeptController {

    @Autowired
    DepartmentMapper departmentMapper;

    @Autowired
    EmployeeMapper employeeMapper;


    @GetMapping("/dept/{id}")
    public Department getDepartment(@PathVariable("id") Integer id){
        return departmentMapper.getDeptById(id);
    }

    @GetMapping("/dept")
    public Department insertDept(Department department){
        departmentMapper.insertDept(department);
        return department;
    }

    @GetMapping("/emp/{id}")
    public Employee getEmp(@PathVariable("id") Integer id){
        return employeeMapper.getEmpById(id);
    }


}
