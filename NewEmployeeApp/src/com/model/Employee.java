package com.model;

import java.util.Iterator;

public class Employee {
	private int id;
	private String name;
	private double salary;
	private String city;
	
	public Employee(int id, String name, double salary, String city) {
		super();
		this.id = id;
		this.name = name;
		this.salary = salary;
		this.city = city;
	}
	public Employee() {
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
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	
	
}
