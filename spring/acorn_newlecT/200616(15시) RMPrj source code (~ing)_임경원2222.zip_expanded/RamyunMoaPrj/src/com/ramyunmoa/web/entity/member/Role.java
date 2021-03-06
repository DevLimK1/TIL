package com.ramyunmoa.web.entity.member;

public class Role {
	private int id;
	private String name;
	private String icon;
	
	public Role() {
		// TODO Auto-generated constructor stub
	}

	public Role(int id, String name, String icon) {
		this.id = id;
		this.name = name;
		this.icon = icon;
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

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	@Override
	public String toString() {
		return "Role [id=" + id + ", name=" + name + ", icon=" + icon + "]";
	}
	
	
}
