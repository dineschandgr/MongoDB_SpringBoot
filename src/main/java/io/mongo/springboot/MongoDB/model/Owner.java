package io.mongo.springboot.MongoDB.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

public class Owner {

	private int id;
	
	private String name;
	
	private int age;
	
	Map<String,String> contactMap = new HashMap<String,String>();
	
	public Owner() {
		
	}
	
	public Owner(int id, String name, int age, Map<String, String> contactMap) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.contactMap = contactMap;
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

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Map<String, String> getContactMap() {
		return contactMap;
	}

	public void setContactMap(Map<String, String> contactMap) {
		this.contactMap = contactMap;
	}
	
}
