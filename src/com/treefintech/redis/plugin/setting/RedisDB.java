package com.treefintech.redis.plugin.setting;

import com.google.common.base.Objects;

import java.awt.*;

/**
 * Created by mayonghua@treefinance.com.cn
 *
 * @author tree
 * @date 2019-04-07 17:08
 **/
public class RedisDB extends Component {
    private String host;
    private Integer port;
    private String password;
    private String name;

    public RedisDB() {
    }

    public RedisDB(String host, Integer port, String password, String name) {
        this.host = host;
        this.port = port;
        this.password = password;
        this.name = name;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public Integer getPort() {
        return port;
    }

    public void setPort(Integer port) {
        this.port = port;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RedisDB)) return false;
        RedisDB redisDB = (RedisDB) o;
        return Objects.equal(host, redisDB.host) &&
                Objects.equal(port, redisDB.port) &&
                Objects.equal(password, redisDB.password) &&
                Objects.equal(name, redisDB.name);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(host, port, password, name);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("{");
        sb.append("\"host\":\"")
                .append(host).append('\"');
        sb.append(",\"port\":")
                .append(port);
        sb.append(",\"password\":\"")
                .append(password).append('\"');
        sb.append(",\"name\":\"")
                .append(name).append('\"');
        sb.append('}');
        return sb.toString();
    }
}
