package com.yintai.exam.entity;

public class Customer {

	private String id;//客户id
	private String name;//客户姓名
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		StringBuffer sb=new StringBuffer() ;
		sb.append(" customerId:").append(this.id) ;
		sb.append(" customerName:").append(this.name) ;
		return sb.toString();
	}
	
}
