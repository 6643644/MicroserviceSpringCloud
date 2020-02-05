package com.springcloud.entitys;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/****************************************************************************************************************
 * 這是一個entity <br>
 * 1. @Entity <br>
 * 2. @Table 表示綁定哪個一個table名稱 <br>
 * 3. @Id PK <br>
 * 4. @Column 對應欄位 <br>
 * 5. @GeneratedValue 自動產生 GenerationType.IDENTITY 對應SQL Server與MySQL;GenerationType.SEQUENCE 對應Oracle <br>
 * 
 * @author Miles
 ****************************************************************************************************************/
@Entity
@Table(name = "USER")
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "ADDRESS")
    private String address;

    public Integer getId() {
	return id;
    }

    public void setId(Integer id) {
	this.id = id;
    }

    public String getName() {
	return name;
    }

    public void setName(String name) {
	this.name = name;
    }

    public String getAddress() {
	return address;
    }

    public void setAddress(String address) {
	this.address = address;
    }

}
