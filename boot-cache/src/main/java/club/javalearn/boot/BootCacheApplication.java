package club.javalearn.boot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

/**
 * 一、搭建基本环境
 * 1. 导入数据库文件 ,创建两种表：department 和employee
 * 2. 创建javabean
 * 3. 整合mabatis操作数据库
 * 		1. 配置数据源
 * 	 	2. 使用注解版的Mybatis：
 * 	 		1）、@MapperScan指定需要扫描的mapper接口所在的包
 *
 * 二、快速体验缓存
 * 		步骤:
 * 			1、开启基于注解的缓存   @EnableCaching
 * 			2、标注缓存注解
 * 				@Cacheable: 主要针对方法配置，能够根据方法的请求参数对其结果进行缓存
 				@CacheEvict: 清空缓存
 				@CachePut: 保证方法被调用，又希望结果被缓存。
				 *
 * @author king-pan
 */
@MapperScan("club.javalearn.boot.mapper")
@EnableCaching
@SpringBootApplication
public class BootCacheApplication {

	public static void main(String[] args) {
		SpringApplication.run(BootCacheApplication.class, args);
	}
}
