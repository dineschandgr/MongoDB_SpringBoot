package io.mongo.springboot.MongoDB.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import io.mongo.springboot.MongoDB.model.Owner;
import io.mongo.springboot.MongoDB.model.Product;
import io.mongo.springboot.MongoDB.service.ProductService;
import io.mongo.springboot.MongoDB.repository.ProductRepository;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@DisplayName(value = "Spring Boot Product Service Test")
class ProductServiceTest {

	@Autowired
	ProductService productService;
	
	@MockBean
	ProductRepository productRepositoryMock;

	@DisplayName(value = "Test getProduct Method")
	@Test
	public void getProduct() {
		
		Map<String,String> contactMap = new HashMap<String,String>();
		contactMap.put("name", "dc");
		contactMap.put("contact", "83471025");
		Owner owner = new Owner(1,"Test",30,contactMap);
		Product product = new Product("Test", "Test", 0, "Test", owner);
		List<Product> productList = new ArrayList<Product>();
		productList.add(product);
		Optional<Product> optionalList = productList.stream().findFirst();
		
		when(productRepositoryMock.findById("Test")).thenReturn(optionalList);
		assertEquals(optionalList.get().getProductName(),productService.getProduct("Test").getProductName());
	}

	 @DisplayName(value = "Test addProductTest Method")
	 @Test
	 public void addProductTest(){
		 
		 Map<String,String> contactMap = new HashMap<String,String>();
	     contactMap.put("name", "dc");
		 contactMap.put("contact", "83471025");
		 Owner owner = new Owner(1,"Test",30,contactMap);
		 Product product = new Product("Test", "Test", 0, "Test", owner);
		 
		 when(productRepositoryMock.save(product)).thenReturn(product);
		 assertEquals(product, productService.createProduct(product));
	 }
	 
	 @Test
	 @DisplayName(value = "Test deleteProductTest Method")
	 public void deleteProductTest() {
		String productId = "Test";
		productService.deleteProduct("Test");
		verify(productRepositoryMock,times(1)).deleteById(productId);
	}

}
