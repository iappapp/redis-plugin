package com.treefintech.redis.plugin.service.impl;

import com.treefintech.redis.plugin.redis.JedisConnection;
import com.treefintech.redis.plugin.service.RedisApplicationService;
import org.junit.platform.commons.logging.Logger;
import org.junit.platform.commons.logging.LoggerFactory;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * Created by mayonghua@treefinance.com.cn
 *
 * @author tree
 * @date 2019-04-06 21:43
 **/
public class RedisApplicationServiceImpl implements RedisApplicationService {
    private static final Logger logger = LoggerFactory.getLogger(RedisApplicationServiceImpl.class);
    private static JedisConnection jedisConnection;

    static {
        jedisConnection = new JedisConnection();
    }

    @Override
    public Jedis getJedis() {
        return jedisConnection.getJedis();
    }

    @Override
    public boolean closeJedisPool() {
        try {
            JedisPool jedisPool = jedisConnection.getJedisPool();
            if (null == jedisPool) {
                logger.info(null);
            }
            jedisPool.close();
            return true;
        } catch (Exception ex) {

        }
        return false;
    }
}
