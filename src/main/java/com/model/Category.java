package com.model;

import java.io.Serializable;

/**
 * @author 作者：roll27
 * @version 创建时间：2017年11月7日上午9:54:48 类说明
 */
public class Category implements Serializable {

	private static final long serialVersionUID = 2734839972087784229L;

	private int id;
	private String name;

	public Category() {

	}

	public Category(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
