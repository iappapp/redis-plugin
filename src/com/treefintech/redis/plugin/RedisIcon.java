package com.treefintech.redis.plugin;

import com.intellij.openapi.util.IconLoader;

import javax.swing.*;

/**
 * Created by mayonghua@treefinance.com.cn
 *
 * @author tree
 * @date 2019-04-07 20:15
 **/
public class RedisIcon {
    private static Icon load(String path) {
        return IconLoader.getIcon(path, RedisIcon.class);
    }

    public static final Icon REDIS_ICON = load("/icon/redis.png");
}
