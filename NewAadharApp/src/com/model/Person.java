package com.model;

public class Person {
	private int id;
	private String name;
	private int aadharNo;
	private String address;
	public Person(int id, String name, int aadharNo, String address) {
		super();
		this.id = id;
		this.name = name;
		this.aadharNo = aadharNo;
		this.address = address;
	}
	public Person() {
		// TODO Auto-generated constructor stub
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
	public int getAadharNo() {
		return aadharNo;
	}
	public void setAadharNo(int aadharNo) {
		this.aadharNo = aadharNo;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", aadharNo=" + aadharNo + ", address=" + address + "]";
	}
	
	

}
