//package com.example.rediscluster.config;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.context.properties.ConfigurationProperties;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.data.redis.connection.RedisConnectionFactory;
//import org.springframework.data.redis.connection.RedisNode;
//import org.springframework.data.redis.connection.RedisSentinelConfiguration;
//import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
//import org.springframework.data.redis.core.RedisTemplate;
//import org.springframework.data.redis.core.StringRedisTemplate;
//import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
//import org.springframework.data.redis.serializer.RedisSerializer;
//import org.springframework.data.redis.serializer.StringRedisSerializer;
//import redis.clients.jedis.JedisPoolConfig;
//
///**
// * @author： ygl
// * @date： 2018/05/10
// * @Description：
// */
//@Configuration
//public class RedisConfig {
//
//    @Autowired
//    private RedisProperties redisProperties;
//
//    /**
//     * 连接池配置
//     * @Description:
//     * @return
//     */
//    @Bean
//    public JedisPoolConfig jedisPoolConfig() {
//        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
//        jedisPoolConfig.setMaxIdle(redisProperties.getMaxIdle());
//        jedisPoolConfig.setMinIdle(redisProperties.getMinIdle());
////    jedisPoolConfig.set ...
//        return jedisPoolConfig;
//    }
//
//
//    @Bean
//    public RedisSentinelConfiguration redisSentinelConfiguration(){
//        RedisSentinelConfiguration configuration = new RedisSentinelConfiguration();
//        String[] host = redisProperties.getSentinelHosts().split(",");
//        for(String redisHost : host){
//            String[] item = redisHost.split(":");
//            String ip = item[0];
//            String port = item[1];
//            configuration.addSentinel(new RedisNode(ip, Integer.parseInt(port)));
//        }
//        configuration.setMaster(redisProperties.getSentinelMaster());
//        return configuration;
//    }
//
//    @Bean
//    public JedisConnectionFactory redisConnectionFactory() {
//        JedisConnectionFactory factory = new JedisConnectionFactory(redisSentinelConfiguration(),jedisPoolConfig());
//        //JedisConnectionFactory factory = new JedisConnectionFactory(jedisPoolConfig());
//        //factory.setHostName(redisProperties.getHost());
//        //factory.setPort(redisProperties.getPort());
//        //factory.setPassword(redisProperties.getPassword());
//        //存储的库
////        factory.setDatabase(database);
//        //设置连接超时时间
//        factory.setTimeout(redisProperties.getTimeout());
//        factory.setUsePool(true);
//        factory.setPoolConfig(jedisPoolConfig());
//
//        return factory;
//    }
//
//    @Bean
//    public RedisTemplate<?,?> redisTemplate(RedisConnectionFactory factory) {
//        RedisTemplate<?,?> redisTemplate = new RedisTemplate<>();
//        redisTemplate.setConnectionFactory(factory);
//        //key序列化方式;但是如果方法上有Long等非String类型的话，会报类型转换错误；
//        RedisSerializer<String> redisSerializer = new StringRedisSerializer();
//        redisTemplate.setKeySerializer(redisSerializer);
//        redisTemplate.setHashKeySerializer(redisSerializer);
//        redisTemplate.setHashValueSerializer(redisSerializer);
//        redisTemplate.setValueSerializer(redisSerializer);
//
//        //JdkSerializationRedisSerializer序列化方式;
//        //JdkSerializationRedisSerializer jdkRedisSerializer=new JdkSerializationRedisSerializer();
//        //redisTemplate.setValueSerializer(jdkRedisSerializer);
//        //redisTemplate.setHashValueSerializer(jdkRedisSerializer);
//        redisTemplate.afterPropertiesSet();
//        return redisTemplate;
//    }
//
//}
