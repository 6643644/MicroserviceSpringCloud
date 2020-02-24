package com.springcloud.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/******************************************************************************************
 * 取得系統配置檔案
 *
 * @author Miles
 *******************************************************************************************/
@Component
//@ConfigurationProperties(prefix = "redisConfig")
public class RedisConfigBean {
    private String host;

    private int port;

    private int database;

    private int timeout;

    public String getHost() {
	return host;
    }

    public void setHost(String host) {
	this.host = host;
    }

    public int getPort() {
	return port;
    }

    public void setPort(int port) {
	this.port = port;
    }

    public int getDatabase() {
	return database;
    }

    public void setDatabase(int database) {
	this.database = database;
    }

    public int getTimeout() {
	return timeout;
    }

    public void setTimeout(int timeout) {
	this.timeout = timeout;
    }

}
