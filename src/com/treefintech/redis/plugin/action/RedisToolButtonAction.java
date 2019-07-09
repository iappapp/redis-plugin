package com.treefintech.redis.plugin.action;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.treefintech.redis.plugin.RedisConnectionPage;

/**
 * Created by mayonghua@treefinance.com.cn
 *
 * @author tree
 * @date 2019-04-06 22:23
 **/
public class RedisToolButtonAction extends AnAction {

    @Override
    public void actionPerformed(AnActionEvent e) {
        RedisConnectionPage form = new RedisConnectionPage();
    }
}
