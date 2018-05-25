package club.javalearn.boot.controller;

import club.javalearn.boot.model.Employee;
import club.javalearn.boot.service.EmployeeService;
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
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/emp/{id}")
    public Employee getEmp(@PathVariable("id") Integer id) {
        return employeeService.getEmp(id);
    }

    @GetMapping("/emp")
    public Employee update(Employee employee) {
        return employeeService.updateEmp(employee);
    }

    @GetMapping("/deleteEmp/{id}")
    public String delete(@PathVariable("id") Integer id) {
        employeeService.deleteEmp(id);
        return "删除成功";
    }


    @GetMapping("/emp/lastName/{lastName}")
    public Employee getEmpByLastName(@PathVariable("lastName") String lastName){
        return employeeService.getEmpByLastName(lastName);
    }
}
