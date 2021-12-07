package com.lincheng.study.redis.config;

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @description: 这个配置也可以放在common中，但是包路径要一样，spring boot在启动时才能自己把配置加载进来。
 * @author: linCheng
 * @create: 2021-11-12 14:49
 **/
@Configuration
public class RedissonConfig {

    @Bean
    public RedissonClient getRedissonClient() {
        Config config = new Config();
        config.useSingleServer()
                .setAddress("redis://127.0.0.1:6379");
        return Redisson.create(config);
    }


}
