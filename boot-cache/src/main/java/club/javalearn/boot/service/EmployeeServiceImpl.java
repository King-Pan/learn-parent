package club.javalearn.boot.service;

import club.javalearn.boot.mapper.EmployeeMapper;
import club.javalearn.boot.model.Employee;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.*;
import org.springframework.stereotype.Service;

/**
 * learn-parent
 *
 * @author king-pan
 * @date 2018-05-24
 **/
@CacheConfig(cacheNames = "emp")
@Service
@Slf4j
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeMapper employeeMapper;

    /**
     * @param id
     * @return
     * @Cacheable 将方法的运行结果进行缓存, 以后再要相同的数据，直接从缓存中取，不用调用方法
     * <p>
     * CacheManager 管理多个Cache组件的，对缓存真正的CRUD操作在Cache组件中，
     * 每一个缓存组件有自己唯一一个名字
     * @Cacheable的几个属性 cacheNames/value 指定缓存的名字
     * key： 缓存数据使用的key；可以用它来指定，默认是使用方法参数的值 1-方法返回值
     * 编写SpEL表达式: key= "#id" 参数值等同于key="#root.arg[0]"
     * keyGenerator:  key的生成器,可以自定义key的生成器组件,key与keyGenerator二选一使用
     * cacheManager: 指定缓存管理器
     * cacheResolver: 缓存解析器 与cacheManager 二选一，作用都一样
     * condition: 指定符合条件的情况下，才缓存
     * unless: 当unless指定的条件为true，方法的返回值不会缓存,与condition相反
     * sync: 缓存是否使用异步模式,使用异步模式，将不支持unless属性.
     * <p>
     * 原理:
     * 1、自动配置类
     * 2、缓存的配置类
     * <p>
     * 0 = "org.springframework.boot.autoconfigure.cache.GenericCacheConfiguration"
     * 1 = "org.springframework.boot.autoconfigure.cache.JCacheCacheConfiguration"
     * 2 = "org.springframework.boot.autoconfigure.cache.EhCacheCacheConfiguration"
     * 3 = "org.springframework.boot.autoconfigure.cache.HazelcastCacheConfiguration"
     * 4 = "org.springframework.boot.autoconfigure.cache.InfinispanCacheConfiguration"
     * 5 = "org.springframework.boot.autoconfigure.cache.CouchbaseCacheConfiguration"
     * 6 = "org.springframework.boot.autoconfigure.cache.RedisCacheConfiguration"
     * 7 = "org.springframework.boot.autoconfigure.cache.CaffeineCacheConfiguration"
     * 8 = "org.springframework.boot.autoconfigure.cache.SimpleCacheConfiguration"
     * 9 = "org.springframework.boot.autoconfigure.cache.NoOpCacheConfiguration"
     * 3、默认哪个配置类生效： SimpleCacheConfiguration  打开debug模式，找到对应的CacheConfiguration
     */
    // @Cacheable(cacheNames = {"emp", "temp"}, key = "#root.args[0]", condition = "#id>1", unless = "#result==null")
    @Cacheable(cacheNames = "emp", key = "#id")
    @Override
    public Employee getEmp(Integer id) {
        log.info("查询员工: 员工编号->" + id);
        return employeeMapper.getEmpById(id);
    }

    /**
     * @CachePut: 即调用方法，又更新缓存
     * 修改了数据库的某个数据，同时更新缓存
     * 运行时机：
     *  1、先调用目标方法，
     *  2、把目标方法结果放在缓存中。
     *
     *
     *  测试步骤：
     *    1、查询2号员工，查询到的结果会放在缓存中
     *    2、以后查询直接从缓存中
     *    3、更新2号员工,[lastName=king-pan]
     *    4、查询2号员工: 应该是更新后的2号员工。实际上是不同的，应为两个方法缓存的key不一致。
     *    5、调整2个方法缓存的key
     */

    /**
     * @param employee 员工信息
     * @return
     */
    @CachePut(key = "#result.id")
    @Override
    public Employee updateEmp(Employee employee) {
        log.info("更新员工信息->" + employee);
        employeeMapper.updateEmp(employee);
        return employeeMapper.getEmpById(employee.getId());
    }


    /**
     * @param id
     * @CacheEvict 缓存清理
     */
    @CacheEvict(cacheNames = "emp", key = "#id")
    @Override
    public void deleteEmp(Integer id) {
        log.info("删除员工:员工ID ->" + id);
        employeeMapper.deleteEmp(id);
    }


    @Caching(
            cacheable = {
                    @Cacheable(value = "emp", key = "#lastName")
            },
            put = {
                    @CachePut(value = "emp", key = "#result.id", condition = "#result!=null"),
                    @CachePut(cacheNames = "emp", key = "#result.email", condition = "#result!=null")
            }
    )
    @Override
    public Employee getEmpByLastName(String lastName) {
        log.info("通过lastName查询员工信息：lastName - >" + lastName);
        return employeeMapper.getEmpByLastName(lastName);
    }

}
