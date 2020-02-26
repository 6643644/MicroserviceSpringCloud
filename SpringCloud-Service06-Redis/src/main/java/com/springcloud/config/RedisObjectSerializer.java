package com.springcloud.config;

/******************************************************************************************
 * 繼承序列化的 Redis Serializer
 * 
 * @author Miles
 *******************************************************************************************/
public class RedisObjectSerializer {
    private String username;

    private Integer sex;

    private Long id;

    public String getUsername() {
	return username;
    }

    public void setUsername(String username) {
	this.username = username;
    }

    public Integer getSex() {
	return sex;
    }

    public void setSex(Integer sex) {
	this.sex = sex;
    }

    public Long getId() {
	return id;
    }

    public void setId(Long id) {
	this.id = id;
    }

}
