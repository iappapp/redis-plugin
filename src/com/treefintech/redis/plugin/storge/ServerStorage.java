package com.treefintech.redis.plugin.storge;

import com.intellij.ide.util.AppPropertiesComponentImpl;
import com.intellij.ide.util.PropertiesComponent;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * Created by mayonghua@treefinance.com.cn
 *
 * @author tree
 * @date 2019-04-06 00:01
 **/
public class ServerStorage extends PropertiesComponent {
    @Override
    public void unsetValue(String s) {

    }

    @Override
    public boolean isValueSet(String s) {
        return false;
    }

    @Nullable
    @Override
    public String getValue(String s) {
        return null;
    }

    @Override
    public void setValue(@NotNull String s, @Nullable String s1) {

    }

    @Override
    public void setValue(@NotNull String s, @Nullable String s1, @Nullable String s2) {

    }

    @Override
    public void setValue(@NotNull String s, float v, float v1) {

    }

    @Override
    public void setValue(@NotNull String s, int i, int i1) {

    }

    @Override
    public void setValue(@NotNull String s, boolean b, boolean b1) {

    }

    @Nullable
    @Override
    public String[] getValues(String s) {
        return new String[0];
    }

    @Override
    public void setValues(String s, String[] strings) {

    }

    public static void main(String[] args) {
        PropertiesComponent storage = new AppPropertiesComponentImpl();
        System.out.println(storage.getValue("hello"));

    }
}
