package com.treefintech.redis.plugin.setting;

import com.intellij.openapi.components.PersistentStateComponent;
import com.intellij.openapi.components.ServiceManager;
import com.intellij.openapi.components.State;
import com.intellij.openapi.components.Storage;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mayonghua@treefinance.com.cn
 *
 * @author tree
 * @date 2019-04-07 17:09
 **/
@State(
        name = "redisDBSetting",
        storages = @Storage("redis-manager-db.xml"),
        defaultStateAsResource = true,
        externalStorageOnly = true
    )
public class RedisDBSetting implements PersistentStateComponent<RedisDB> {
    private static final Logger logger = LoggerFactory.getLogger(RedisDBSetting.class);

    private List<RedisDB> globalRedisDBList = new ArrayList<>(10);

    public static RedisDBSetting getInstance() {
        logger.info("getInstance start");
        return ServiceManager.getService(RedisDBSetting.class);
    }

    @Nullable
    @Override
    public RedisDB getState() {
        if (globalRedisDBList != null && globalRedisDBList.size() > 0) {
            return globalRedisDBList.get(0);
        } else {
            return null;
        }
    }

    @Override
    public void loadState(@NotNull RedisDB redisDB) {
        if (this.isRedisDBExist(redisDB)) {
            return;
        } else {
            globalRedisDBList.add(redisDB);
            logger.info("loadState redisDB={}", redisDB);
        }
    }

    public boolean isRedisDBExist(@NotNull RedisDB redisDB) {
        logger.info("isRedisDBExist globalRedisDBList={} redisDB={}", globalRedisDBList, redisDB);
        for (RedisDB db : globalRedisDBList) {
            if (db.equals(redisDB)) {
                logger.info("redisDB redisDB={} exist", redisDB);
                return true;
            }
        }
        return false;
    }

    public List<RedisDB> getAllRedisDB() {
        return globalRedisDBList;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("{");
        sb.append("\"globalRedisDBList\":")
                .append(globalRedisDBList);
        sb.append('}');
        return sb.toString();
    }
}
