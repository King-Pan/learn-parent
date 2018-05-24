package club.javalearn.boot.mapper;


import club.javalearn.boot.model.Employee;


/**
 * @Mapper或者@MapperScan将接口扫描装配到容器中
 * @author king-pan
 */
public interface EmployeeMapper {

    public Employee getEmpById(Integer id);

    public void insertEmp(Employee employee);
}
