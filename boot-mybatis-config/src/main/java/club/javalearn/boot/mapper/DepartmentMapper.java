package club.javalearn.boot.mapper;

import club.javalearn.boot.model.Department;
import org.apache.ibatis.annotations.*;


/**
 * @Mapper与@MapperScan任选其一
 * @author king-pan
 */
public interface DepartmentMapper {

    @Select("select * from department where id=#{id}")
    Department getDeptById(Integer id);

    @Delete("delete from department where id=#{id}")
    int deleteDeptById(Integer id);

    @Options(useGeneratedKeys = true,keyProperty = "id")
    @Insert("insert into department(department_name) values(#{departmentName})")
    int insertDept(Department department);

    @Update("update department set department_name=#{departmentName} where id=#{id}")
    int updateDept(Department department);
}
