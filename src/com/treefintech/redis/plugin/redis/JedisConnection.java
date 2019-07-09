package com.treefintech.redis.plugin.redis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.JedisShardInfo;

/**
 * Created by mayonghua@treefinance.com.cn
 *
 * @author tree
 * @date 2019-03-30 15:06
 **/
public class JedisConnection {

    private static JedisPool jedisPool = null;

    static {
        JedisPoolConfig config = new JedisPoolConfig();
        jedisPool = new JedisPool(config, "localhost", 6379, 10000, null);
    }

    public JedisShardInfo initJedisSharedInfo(String host, String name, int port) {
        JedisShardInfo shardInfo = new JedisShardInfo(host, port, name);
        return shardInfo;
    }

    public Jedis initJedis(JedisShardInfo info) {
        Jedis jedis = new Jedis(info);
        return jedis;
    }

    public Jedis getJedis() {
        return jedisPool.getResource();
    }

    public JedisShardInfo initJedisInfo(String host, String name, int port, String password) {
        JedisShardInfo shardInfo = this.initJedisSharedInfo(host, name, port);
        shardInfo.setPassword(password);
        shardInfo.setSoTimeout(2000);
        return shardInfo;
    }

    public JedisPool getJedisPool() {
        return jedisPool;
    }
}