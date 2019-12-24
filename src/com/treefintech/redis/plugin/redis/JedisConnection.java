package com.treefintech.redis.plugin.redis;

import org.apache.commons.compress.utils.Lists;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.JedisShardInfo;

import java.util.List;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;

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
        jedisPool = new JedisPool(config, "192.168.3.60", 6379, 10000, null);
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

    public static void main(String[] args) {
        List<List<Integer>> listList = Lists.newArrayList();
        List<Integer> integerList = Lists.newArrayList();
        for (int i = 0; i < 100 * 10000; i++) {

            integerList.add(i);
            if (i % 10000 == 0) {
                listList.add(integerList);
                integerList.clear();
            }

            if (i == 100 * 10000 - 1) {
                listList.add(integerList);

            }
        }


        for (List<Integer> integers : listList) {
            KeyTask keyTask = new KeyTask(integers);
            keyTask.run();
        }
    }
}