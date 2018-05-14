//package com.example.rediscluster;
//
//import lombok.extern.slf4j.Slf4j;
//import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;
//import redis.clients.jedis.JedisPool;
//import redis.clients.jedis.JedisSentinelPool;
//
//import java.util.HashSet;
//import java.util.Set;
//
///**
// * @author： ygl
// * @date： 2018/5/14-11:46
// * @Description：
// */
//@Slf4j
//@RunWith(SpringRunner.class)
//@SpringBootTest
//public class RedisTest {
//
//    @Test
//    public void redisTest() {
//        Set<String> sentinels = new HashSet<String>(16);
//        GenericObjectPoolConfig config = new GenericObjectPoolConfig();
//        config.setBlockWhenExhausted(true);
//        config.setMaxTotal(10);
//        config.setMaxWaitMillis(1000l);
//        config.setMaxIdle(25);
//        config.setMaxTotal(32);
//        JedisPool jedisPool = new JedisSentinelPool(config);
////不停读写
//        while (true) {
//            AegisRedis.set("testSentinel", "ok");
//            System.err.println(AegisRedis.get("testSentinel"));
//            Thread.sleep(3000);
//        }
//    }
//}
