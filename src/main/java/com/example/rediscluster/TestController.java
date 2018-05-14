package com.example.rediscluster;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author： ygl
 * @date： 2018/5/14-16:15
 * @Description：
 */
@RestController
public class TestController {

    @Autowired
    public RedisTemplate redisTemplate;

    @GetMapping("/get")
    public Object redisTest() {
        Object name = redisTemplate.opsForValue().get("name");
        return name;
    }
}
