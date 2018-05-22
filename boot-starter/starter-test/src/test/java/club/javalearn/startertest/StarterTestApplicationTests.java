package club.javalearn.startertest;

import com.alibaba.druid.pool.DruidDataSource;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.SQLException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StarterTestApplicationTests {

	@Autowired
	ApplicationContext context;

	@Test
	public void contextLoads() {
		DruidDataSource druidDataSource = context.getBean(DruidDataSource.class);
		try {
			System.out.println(druidDataSource.getConnection());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
