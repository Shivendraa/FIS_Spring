package com.fis.springlearn.bean;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fis.springlearn.SpringLearnApplication;

public class Skill {
	int id;
	String name;
	
	private final Logger LOGGER = LoggerFactory.getLogger(SpringLearnApplication.class);
	
	public Skill() {
		LOGGER.debug("Inside Skill Constructor");
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

	@Override
	public String toString() {
		return "Skill [id=" + id + ", name=" + name + "]";
	}
	
	
}
