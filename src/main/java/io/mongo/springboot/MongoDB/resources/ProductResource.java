package io.mongo.springboot.MongoDB.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.mongo.springboot.MongoDB.model.Product;
import io.mongo.springboot.MongoDB.service.ProductService;

@RestController
public class ProductResource {
	
	@Autowired
	ProductService productService;

	@PostMapping(value="/product/createProduct")
	public Product createProduct(@RequestBody Product product) {
		return productService.createProduct(product);
	}
	
	@PostMapping(value="/product/createProducts")
	public List<Product> createProducts(@RequestBody List<Product> productList) {
		return productService.createProducts(productList);
	}
	
	@GetMapping(value="/product/getProduct/{id}")
	public Product getProduct(@PathVariable String id) {
		return productService.getProduct(id);
	}
	
	@RequestMapping(method = RequestMethod.GET,value="/product/getProducts")
	public List<Product> getAllProducts() {
		return productService.getAllProducts();
	}
	
	@PutMapping(value="/product/updateProduct/{id}")
	public Product updateProduct(@RequestBody Product product,@PathVariable String id) {
		return productService.updateProduct(product,id);
	}
	
	@DeleteMapping(value="/product/deleteProduct/{id}")
	public void deleteProduct(@PathVariable String id) {
		productService.deleteProduct(id);
	}
	
}
