package com.example.rediscluster;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisClusterApplicationTests {

    @Autowired
    public RedisTemplate<String, Object> redisTemplate;

    @Test
    public void redisTest() {
        redisTemplate.opsForValue().set("name","tom");
        Object name = redisTemplate.opsForValue().get("name");
        log.info("---------------"+name);
    }

}
