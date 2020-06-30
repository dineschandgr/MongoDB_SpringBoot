package io.mongo.springboot.MongoDB.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.mongo.springboot.MongoDB.model.Product;
import io.mongo.springboot.MongoDB.repository.ProductRepository;

@Service
public class ProductService {

	@Autowired
	ProductRepository productRepository;
	
	public Product getProduct(String id) {
		return productRepository.findById(id).orElse(null);
	}
	
	public List<Product> getAllProducts() {
		return productRepository.findAll();
	}
	
	public Product createProduct(Product product) {
		return productRepository.save(product);
	}
	
	public List<Product> createProducts(List<Product> productList) {
		return productRepository.saveAll(productList);
	}
	
	public Product updateProduct(Product product, String productID) {
		product.setProductID(productID);
		return productRepository.save(product);
	}
	
	public void deleteProduct(String productID) {
		productRepository.deleteById(productID);
	}
}
