package club.javalearn.boot.config;

import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * learn-parent
 *
 * @author king-pan
 * @date 2018-05-24
 **/
//@Configuration
public class MyCaCheConfig {


    @Bean(value = "myKeyGenerator")
    public KeyGenerator keyGenerator(){

        KeyGenerator keyGenerator  = (target,method,params)-> {
            return method.getName()+"----------- lamdba";
        };
        return keyGenerator;
    }
}
