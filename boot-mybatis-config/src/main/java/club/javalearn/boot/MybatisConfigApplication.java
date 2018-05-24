package club.javalearn.boot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * learn-parent
 *
 * @MapperScan 指定mapper接口扫描路径
 *
 * @author king-pan
 * @date 2018-05-24
 **/
@MapperScan(value = "club.javalearn.boot.mapper")
@SpringBootApplication
public class MybatisConfigApplication {

    public static void main(String[] args) {
        SpringApplication.run(MybatisConfigApplication.class, args);
    }
}
