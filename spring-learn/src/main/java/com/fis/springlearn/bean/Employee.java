package com.fis.springlearn.bean;

import java.util.Arrays;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fis.springlearn.SpringLearnApplication;

public class Employee {
	private int id;
	private String name;
	private double salary;
	private boolean permanent;
	private Date dob;
	Department department;
	Skill[] skill;
	
	private final Logger LOGGER = LoggerFactory.getLogger(SpringLearnApplication.class);
	
	
	public Skill[] getSkill() {
		return skill;
	}
	public void setSkill(Skill[] skill) {
		this.skill = skill;
	}
	public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department department) {
		this.department = department;
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
	public boolean isPermanent() {
		return permanent;
	}
	public void setPermanent(boolean permanent) {
		this.permanent = permanent;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	
	
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", salary=" + salary + ", permanent=" + permanent + ", dob="
				+ dob + ", department=" + department.toString() + ", skill=" + Arrays.toString(skill) + "]";
	}
	public Employee() {
		LOGGER.debug("Inside Employee Constructor");
	}
}
