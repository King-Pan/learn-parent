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
	默认使用的是ConcurrentMapCacheManager，ConcurrentMapCache；将数据保存在ConcurrentMap<String,Object>中

	真实的开发过程中都会使用缓存中间件: redis、memchached、

	整合redis作为缓存:
		redis简介：Redis 是一个开源（BSD许可）的，内存中的数据结构存储系统，它可以用作数据库、缓存和消息中间件。
		1. 安装redis；使用docker安装  docker run -d -p 6379:6379 --name myredis redis
				命令详解: -d 后台运行  -p 主机端口:容器端口 --name 自定义名称 镜像名称
		2. 引入redis的starter
		3. 配置redis
		4. 测试缓存
			原理: CacheManager -> 创建Cache组件来实际上CRUD缓存
			1、引入redis的starter后，容器中保存的是RedisCacheManager，剩下的CacheManager就失效了
			2、RedisCacheManager帮我们创建RedisCache来作为缓存组件，RedisCache通过操作Redis缓存数据
			3、默认保存数据k-v都是Object，利用序列号保存,默认使用JDK序列号，可以配置redisTemplate的默认序列化规则
				1）、引入了redis的starter，cacheManager变成了RedisCacheManager
				2）、默认创建的RedisCacheManager在操作redis时使用的是RedisTemplate<Object,Object>
				3）、RedisTemplate<Obejct,Object>默认使用JdkSerializationRedisSerializer序列化规则
			4、自定义redis


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
