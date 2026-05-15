package com.plumelog.server.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

import java.io.Serializable;

/**
 * @Description
 * @Author ZhangDong
 * @Date 2024年07月29日 16:15 星期一
 */
@ConfigurationProperties(prefix = "plumelog.doris.env")
public class DorisEnvProperties implements Serializable {

    private  String host;
    // FE port
    private Integer port;
    // db name
    private String database;
    // table name
    private String table;
    //user name
    private String user;
    //user password
    private String passwd;

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

    public String getDatabase() {
        return database;
    }

    public void setDatabase(String database) {
        this.database = database;
    }

    public String getTable() {
        return table;
    }

    public void setTable(String table) {
        this.table = table;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }
}
