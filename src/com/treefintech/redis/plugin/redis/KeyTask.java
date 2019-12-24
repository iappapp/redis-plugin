package com.treefintech.redis.plugin.redis;

import redis.clients.jedis.Jedis;

import java.util.List;

/**
 * Created by mayonghua@treefinance.com.cn
 *
 * @author tree
 * @date 2019-07-14 10:34
 **/
class KeyTask implements Runnable {
    List<Integer> integers;

    public KeyTask(List<Integer> integers) {
        this.integers = integers;
    }

    public List<Integer> getIntegers() {
        return integers;
    }

    public void setIntegers(List<Integer> integers) {
        this.integers = integers;
    }

    @Override
    public void run() {
        JedisConnection connection = new JedisConnection();
        Jedis jedis = connection.getJedis();
        for (Integer integer : integers) {
            String result = jedis.set("KEY_" + integer, integer.toString());
            System.out.println("redit set KEY_" + integer + " = " + integer + " " + result);
        }
    }
}
