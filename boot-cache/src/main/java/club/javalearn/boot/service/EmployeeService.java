package club.javalearn.boot.service;

import club.javalearn.boot.model.Employee;

/**
 * learn-parent
 *
 * @author king-pan
 * @date 2018-05-24
 **/
public interface EmployeeService {
    Employee getEmp(Integer id);
    Employee updateEmp(Employee employee);
    void deleteEmp(Integer id);
}
