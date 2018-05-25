package club.javalearn.boot;

import club.javalearn.boot.model.Employee;
import club.javalearn.boot.service.EmployeeService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BootCacheApplicationTests {


	@Autowired
	StringRedisTemplate stringRedisTemplate;


	@Autowired
	EmployeeService employeeService;

	@Autowired
	RedisTemplate redisTemplate;

	@Test
	public void contextLoads() {
	}


	/**
	 * string-字符串、list-列表、set-集合、hash-散列、zset-有序集合
	 * stringRedisTemplate.opsForValue(): 操作string的
	 * stringRedisTemplate.opsForList(): 操作list的
	 * stringRedisTemplate.opsForSet(): 操作set的
	 * stringRedisTemplate.opsForHash(): 操作hash
	 * stringRedisTemplate.opsForZSet(): 操作zset
 	 */
	@Test
	public void test01(){
		//在message上追加值"hello"
		stringRedisTemplate.opsForValue().append("message","hello");
	}

	@Test
	public void test02(){
		String message = stringRedisTemplate.opsForValue().get("message");
		System.out.println(message);
	}

	@Test
	public void test03(){
		stringRedisTemplate.opsForList().leftPush("mylist","l1");
		stringRedisTemplate.opsForList().leftPush("mylist","l2");
	}


	/**
	 * 测试保存对象,
	 * redisTemplate 保存的对象必须是可序列化的
	 *
	 * IllegalArgumentException: DefaultSerializer requires a Serializable payload but received an object of type [club.javalearn.boot.model.Employee
	 */
	@Test
	public void test04(){
		Employee employee = employeeService.getEmp(1);
		//默认保存对象使用了jdk的序列号机制，序列号后的数据保存到redis中
		redisTemplate.opsForValue().set("emp-"+employee.getId(),employee);
		//1. 将数据以json的方式保存数据
			//1）、自己将对象转换成json
			//2)、redisTemplate有默认的序列化规则
	}


	@Test
	public void test05(){
		Employee employee = employeeService.getEmp(1);
		//默认保存对象使用了jdk的序列号机制，序列号后的数据保存到redis中
		redisTemplate.opsForValue().set("emp-001",employee);
		//1. 将数据以json的方式保存数据
		//1）、自己将对象转换成json
		//2)、redisTemplate有默认的序列化规则:改变redisTemplate的默认序列化规则
	}


	@Test
	public void test06(){
		//默认保存对象使用了jdk的序列号机制，序列号后的数据保存到redis中
		Object o = redisTemplate.opsForValue().get("emp-001");
		System.out.println(o);
		//1. 将数据以json的方式保存数据
		//1）、自己将对象转换成json
		//2)、redisTemplate有默认的序列化规则
	}

}
