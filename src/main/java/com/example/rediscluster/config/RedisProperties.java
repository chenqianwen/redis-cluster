package com.example.rediscluster.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * @author： ygl
 * @date： 2018/05/10
 * @Description：
 */
@Data
@Configuration
public class RedisProperties {

    @Value("${spring.redis.host}")
    private String host;

    @Value("${spring.redis.port}")
    private int port;

    @Value("${spring.redis.timeout}")
    private int timeout;

    //@Value("${spring.redis.password}")
    private String password;

    @Value("${spring.redis.database}")
    private int database;

    @Value("${spring.redis.pool.max-idle}")
    private int maxIdle;

    @Value("${spring.redis.pool.min-idle}")
    private int minIdle;

    @Value("${spring.redis.sentinel.nodes}")
    private String sentinelHosts;

    @Value("${spring.redis.sentinel.master}")
    private String sentinelMaster;
}
