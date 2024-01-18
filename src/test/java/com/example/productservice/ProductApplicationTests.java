package com.example.productservice;

import com.example.productservice.controller.ProductController;
import com.example.productservice.entity.Product;
import com.example.productservice.repository.ProductRepository;
import com.example.productservice.service.ProductService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@SpringBootTest
class ProductApplicationTests {
	/*@Mock
	private ProductRepository productRepository;

	@InjectMocks
	private ProductService productService;

	@Test
	public void testGetProducts() {
		//EventService eventService = new EventServiceImp();
		/*List<Product> Service = new ArrayList<>();
		Product product= new Product();
		product.setId(2L);
		product.setName("Chocolate");
		product.setCategory("Dairy");
		product.setQty(46);
		Service.add(product);*/

		// Mocking the productService to return a list of products

	/*	List<Product> mockProducts = Arrays.asList(
				new Product(2L, "Chocolate", 43, "Dairy", new Date(), 5.22),
				new Product(3L, "Cake", 90, "Produce", new Date(), 8.49)
		);
		when(productService.getAllProducts()).thenReturn(mockProduct);

		// Calling the controller method
		List<Product> result = productController.getProducts();

		// Asserting the result
		assertNotNull(result);
		assertEquals(2, result.size());
	}

	@Test
	public void testCreateProduct() {
		// Mocking the productService to return the created product
		Product mockProduct = new Product(2L, "Chocolate", 43, "Dairy", new Date(), 5.22);
		when(productService.createProduct(any(Product.class))).thenReturn(mockProduct);

		// Calling the controller method
		ResponseEntity<Product> responseEntity = productController.createProduct(new Product());

		// Asserting the response status and body
		assertEquals(HttpStatus.CREATED, responseEntity.getStatusCode());
		assertEquals(mockProduct, responseEntity.getBody());
	}

	@Test
	public void testUpdateProduct() {
		// Mocking the productService to return the updated product
		Product mockProduct = new Product(2L, "Chocolate", 43, "Dairy", new Date(), 5.22);
		when(productService.updateProduct(any(Long.class), any(Product.class))).thenReturn(mockProduct);

		// Calling the controller method
		ResponseEntity<Product> responseEntity = productController.updateProduct(1L, new Product());

		// Asserting the response status and body
		assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
		assertEquals(mockProduct, responseEntity.getBody());
	}

	// Add more tests for edge cases, validations, and other scenarios...
*/

	@InjectMocks
	private ProductService productService;

	@Mock
	private ProductRepository productRepository;

	@Test
	public void testGetAllProducts() {
		// Mocking the repository to return a list of products
		List<Product> mockProducts = Arrays.asList(
				new Product(2L, "Chocolate", 43, "Dairy", null, 5.22),
				new Product(3L, "Cake", 90, "Produce", null, 8.49)
		);
		when(productRepository.findAll()).thenReturn(mockProducts);

		// Calling the service method
		List<Product> result = productService.getAllProducts();

		// Verifying that the repository method was called once
		//verify(productRepository, times(1)).findAll();

		// Asserting the result
		assertEquals(2, result.size());
	}

	@Test
	public void testUpdateProduct() {
		// Mocking the repository to return the updated product
		Product mockProduct = new Product(2L, "Chocolate", 43, "Dairy", null, 5.22);
		when(productRepository.findById(any(Long.class))).thenReturn(Optional.of(mockProduct));
		when(productRepository.save(any(Product.class))).thenReturn(mockProduct);

		// Calling the service method
		Product result = productService.updateProduct(2L, new Product());

		// Verifying that the repository methods were called once each
		//verify(productRepository, times(1)).findById(any(Long.class));
		//verify(productRepository, times(1)).save(any(Product.class));

		// Asserting the result
		assertEquals(mockProduct, result);
	}
}

