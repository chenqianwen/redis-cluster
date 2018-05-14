package com.example.rediscluster;

import com.example.rediscluster.config.RedisService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisSentinelPool;

import java.util.HashSet;
import java.util.Set;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisClusterApplicationTests {

    @Autowired
    public RedisTemplate redisTemplate;

    @Test
    public void redisTest() {
        //redisTemplate.opsForValue().set("name","ygl");
        Object name = redisTemplate.opsForValue().get("name");
        log.info("---------------" + name);
    }


    @Autowired
    private RedisService service;

    @Test
    public void contextLoads() {
        String name = service.get("name");
        System.out.println(name);
    }


    @Test
    public void redisTest2() {
        Set<String> sentinels = new HashSet<String>();
        String hostAndPort1 = "10.211.55.10:26379";
        String hostAndPort2 = "10.211.55.10:26380";
        String hostAndPort3 = "10.211.55.10:26381";
        sentinels.add(hostAndPort1);
        sentinels.add(hostAndPort2);
        sentinels.add(hostAndPort3);

        String clusterName = "mymaster";
        JedisSentinelPool redisSentinelJedisPool = new JedisSentinelPool(clusterName, sentinels);
        Jedis jedis = null;
        try {
            jedis = redisSentinelJedisPool.getResource();
            String name = jedis.get("name");
            System.out.println("*********************"+name);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            redisSentinelJedisPool.returnBrokenResource(jedis);
        }

        redisSentinelJedisPool.close();
    }

}
