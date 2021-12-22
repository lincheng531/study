package com.lincheng.study.redis.service.interfaces;

import com.lincheng.study.common.domain.redis.TestRedisVO;

public interface ITestSpringCacheService {

    TestRedisVO testCacheable(TestRedisVO testRedisVO);

    TestRedisVO testCachePut(TestRedisVO testRedisVO);

    TestRedisVO testCacheEvict(TestRedisVO testRedisVO);

    TestRedisVO testCaching(TestRedisVO testRedisVO);
}
