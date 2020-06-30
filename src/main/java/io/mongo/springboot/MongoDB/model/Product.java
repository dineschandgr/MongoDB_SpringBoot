package io.mongo.springboot.MongoDB.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Product {

	@Id
	public String productID;
	
	public String productName;
	
	public int price;
	
	public String description;
	
	public Owner owner;
	
	public Product(String productID, String productName, int price, String description, Owner owner) {
		super();
		this.productID = productID;
		this.productName = productName;
		this.price = price;
		this.description = description;
		this.owner = owner;
	}

	public String getProductID() {
		return productID;
	}

	public void setProductID(String productID) {
		this.productID = productID;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Owner getOwner() {
		return owner;
	}

	public void setOwner(Owner owner) {
		this.owner = owner;
	}
	
}
