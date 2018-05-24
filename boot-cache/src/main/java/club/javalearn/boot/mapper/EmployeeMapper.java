package club.javalearn.boot.mapper;


import club.javalearn.boot.model.Employee;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Update;


/**
 * @Mapper或者@MapperScan将接口扫描装配到容器中
 * @author king-pan
 */
public interface EmployeeMapper {

    Employee getEmpById(Integer id);

    void insertEmp(Employee employee);

    @Update("update employee set last_name=#{lastName},gender=#{gender},email=#{email},d_id=#{dId} where id=#{id}")
    void updateEmp(Employee employee);

    @Delete("delete from employee where id=#{id}")
    void deleteEmp(Integer id);
}
