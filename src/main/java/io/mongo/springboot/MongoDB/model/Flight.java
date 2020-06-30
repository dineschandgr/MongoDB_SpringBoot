package io.mongo.springboot.MongoDB.model;

import java.util.HashMap;
import java.util.Map;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Flight {

	private int id;
	private int model;
	private String name;
	
	Map<String,String> passengerMap = new HashMap<String,String>();

	public Flight(int id, int model, String name, Map<String, String> passengerMap) {
		super();
		this.id = id;
		this.model = model;
		this.name = name;
		this.passengerMap = passengerMap;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getModel() {
		return model;
	}

	public void setModel(int model) {
		this.model = model;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Map<String, String> getPassengerMap() {
		return passengerMap;
	}

	public void setPassengerMap(Map<String, String> passengerMap) {
		this.passengerMap = passengerMap;
	}
	
}
