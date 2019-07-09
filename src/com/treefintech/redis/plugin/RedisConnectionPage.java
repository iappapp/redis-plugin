package com.treefintech.redis.plugin;

import com.intellij.openapi.ui.messages.MessageDialog;
import com.treefintech.redis.plugin.setting.RedisDB;
import com.treefintech.redis.plugin.setting.RedisDBSetting;
import com.treefintech.redis.plugin.util.RedisUtil;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by mayonghua@treefinance.com.cn
 *
 * @author tree
 * @date 2019-04-04 22:55
 **/
public class RedisConnectionPage {
    private JTextField nameTextField;
    private JTextField hostTextField;
    private JTextField passwordTextField;
    private JTextField portTextField;
    private JButton testConnectionButton;
    private JButton confirmButton;
    private JButton cancelButton;
    private JPanel rootContent;

    public RedisConnectionPage() {
        JFrame frame = new JFrame("RedisConnection");
        frame.setContentPane(rootContent);
        frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        frame.pack();
        frame.setSize(400, 600);
        frame.setVisible(true);
        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame jFrame = frame;
                onCancel(jFrame);
            }
        });

        confirmButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame jFrame = frame;
                onConfirm(jFrame);
            }
        });

        testConnectionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onTestConnection();
            }
        });
    }

    private void onTestConnection() {
        String host = hostTextField.getText().trim();
        Integer port = Integer.valueOf(portTextField.getText().trim());
        String password = passwordTextField.getText().trim();
        String redisServerName = nameTextField.getText().trim();

        boolean connectionOK = RedisUtil.isConnectionOK(host, port, password, redisServerName);
        if (!connectionOK) {
            MessageDialog dialog =
                    new MessageDialog("redis connection error", "connection fail", new String[]{"confirm"}, 1, null);
            dialog.setSize(400, 200);
            dialog.show();
            return;
        }

        MessageDialog dialog =
                new MessageDialog("redis connection successful", "connection successful", new String[]{"confirm"}, 1, null);
        dialog.setSize(400, 200);
        dialog.show();
    }

    private void onCancel(JFrame jFrame) {
        jFrame.dispose();
    }

    private void onConfirm(JFrame frame) {
        String host = hostTextField.getText().trim();
        Integer port = Integer.valueOf(portTextField.getText().trim());
        String password = passwordTextField.getText().trim();
        String redisServerName = nameTextField.getText().trim();

        // TODO 保存数据到本地 以后可以复用
        if (RedisUtil.isConnectionOK(host, port, password, redisServerName)) {
            RedisDBSetting db = RedisDBSetting.getInstance();
            if (null == db) {
                MessageDialog dialog =
                        new MessageDialog("add server", "server is not up", new String[] {"cancel", "confirm"}, 1, null);
                dialog.setSize(600, 200);
                dialog.show();
            } else {
                RedisDB redisDB = new RedisDB(host, port, password, redisServerName);
                if (db.isRedisDBExist(redisDB)) {
                    MessageDialog dialog =
                            new MessageDialog("server exist", "server repeat", new String[] {"confirm"}, 1, null);
                    dialog.setSize(600, 200);
                    dialog.show();
                } else {
                    db.loadState(new RedisDB(host, port, password, redisServerName));
                    frame.dispose();
                }
            }
        }
    }
}
