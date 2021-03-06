package club.javalearn.boot.config;

import com.alibaba.fastjson.parser.ParserConfig;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import java.time.Duration;

/**
 * learn-parent
 *
 * @author king-pan
 * @date 2018-05-25
 **/
@Configuration
@EnableCaching
public class MyRedisConfig extends CachingConfigurerSupport {


//    @Autowired
//    private RedisConnectionFactory connectionFactory;

//    @Bean
//    @Override
//    public KeyGenerator keyGenerator() {
//        KeyGenerator keyGenerator = (target, method, params) -> {
//            StringBuffer sb = new StringBuffer();
//            sb.append(target.getClass().getName());
//            sb.append(method.getName());
//            for (Object obj : params) {
//                sb.append(obj.toString());
//            }
//            return sb.toString();
//        };
//        return keyGenerator;
//    }

//    @Override
//    @Bean
//    public CacheManager cacheManager() {
//        RedisCacheManager redisCacheManager = RedisCacheManager.builder(connectionFactory).build();
//        return redisCacheManager;
//    }

    /**
     * RedisTemplate配置
     *
     * @param redisConnectionFactory
     * @return RedisTemplate
     */
//    @Bean
//    public RedisTemplate<Object, Object> redisTemplate(RedisConnectionFactory redisConnectionFactory) {
//        //设置序列化
//        Jackson2JsonRedisSerializer jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer(Object.class);
//        ObjectMapper om = new ObjectMapper();
//        om.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
//        om.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
//        jackson2JsonRedisSerializer.setObjectMapper(om);
//        //配置redisTemplate
//        RedisTemplate<Object, Object> redisTemplate = new RedisTemplate<>();
//        redisTemplate.setConnectionFactory(redisConnectionFactory);
//        RedisSerializer stringSerializer = new StringRedisSerializer();
//        //key序列化
//        redisTemplate.setKeySerializer(stringSerializer);
//        //value序列化
//        redisTemplate.setValueSerializer(jackson2JsonRedisSerializer);
//        //Hash key序列化
//        redisTemplate.setHashKeySerializer(stringSerializer);
//        //Hash value序列化
//        redisTemplate.setHashValueSerializer(jackson2JsonRedisSerializer);
//        redisTemplate.afterPropertiesSet();
//        return redisTemplate;
//    }

    @Bean
    public RedisCacheConfiguration redisCacheConfiguration(){
        FastJsonRedisSerializer<Object> fastJsonRedisSerializer = new FastJsonRedisSerializer<>(Object.class);
        ParserConfig.getGlobalInstance().setAutoTypeSupport(true);
        RedisCacheConfiguration configuration = RedisCacheConfiguration.defaultCacheConfig();
        configuration = configuration.serializeValuesWith(RedisSerializationContext.SerializationPair.fromSerializer(fastJsonRedisSerializer)).entryTtl(Duration.ofDays(30));
        return configuration;
    }
}
