package com.treefintech.redis.plugin.service;

import com.intellij.openapi.components.ServiceManager;
import redis.clients.jedis.Jedis;

/**
 * Created by mayonghua@treefinance.com.cn
 *
 * @author tree
 * @date 2019-04-06 21:43
 **/
public interface RedisApplicationService {
    static RedisApplicationService getInstance() {
        return ServiceManager.getService(RedisApplicationService.class);
    }

    Jedis getJedis();

    boolean closeJedisPool();
}
