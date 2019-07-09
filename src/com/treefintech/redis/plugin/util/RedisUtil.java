package com.treefintech.redis.plugin.util;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisShardInfo;

/**
 * Created by mayonghua@treefinance.com.cn
 *
 * @author tree
 * @date 2019-04-07 15:58
 **/
public class RedisUtil {

    private static final String PONG = "PONG";

    public static boolean isConnectionOK(String host, Integer port, String password, String name) {
        JedisShardInfo jedisShardInfo = new JedisShardInfo(host, port, name);
        if (null != password && !password.equals("")) {
            jedisShardInfo.setPassword(password);
        }

        try {
            Jedis jedis = new Jedis(jedisShardInfo);
            if (null != jedis && jedis.ping().equals(PONG)) {
                return true;
            }
        } catch (Exception ex) {

        }

        return false;
    }
}
