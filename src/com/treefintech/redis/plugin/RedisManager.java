package com.treefintech.redis.plugin;

import com.intellij.openapi.components.ServiceManager;
import com.jgoodies.common.collect.ArrayListModel;
import com.treefintech.redis.plugin.setting.RedisDB;
import com.treefintech.redis.plugin.setting.RedisDBSetting;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Vector;

/**
 * Created by mayonghua@treefinance.com.cn
 *
 * @author tree
 * @date 2019-04-07 22:24
 **/
public class RedisManager {
    private static final Logger logger = LoggerFactory.getLogger(RedisManager.class);
    private JPanel contentPanel;
    private JPanel secondPanel;
    private JPanel rightPanel;
    private JPanel leftPanel;
    private JList<RedisDB> serverList;
    private JEditorPane editorPane;

    public RedisManager() {
        JFrame frame = new JFrame("RedisConnection");
        frame.setContentPane(contentPanel);
        frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        initRedisServerList();
        frame.pack();
        frame.setSize(800, 1000);
        frame.setVisible(true);

        frame.setVisible(true);
    }

    public void initRedisServerList() {
        /*RedisDBSetting dbSetting = ServiceManager.getService(RedisDBSetting.class);
        if (null == dbSetting) {
            return new JList(new Vector());
        }*/
        // return new JList(dbSetting.getAllRedisDB().toArray());

        RedisDB redisDB = new RedisDB("127.0.0.1", 6379, null, "redis");
        RedisDB[] redisDBArray = new RedisDB[1];
        redisDBArray[0] = redisDB;
        serverList.setBorder(BorderFactory.createTitledBorder("redis-server"));
        serverList.setListData(redisDBArray);
    }
}
