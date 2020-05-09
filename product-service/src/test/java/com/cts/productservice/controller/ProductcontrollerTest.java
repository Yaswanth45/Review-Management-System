package com.cts.productservice.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.cts.productservice.entity.Product;
import com.cts.productservice.repo.ProductRepository;
import com.cts.productservice.service.ProductService;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class ProductcontrollerTest {
    
    @InjectMocks
    private  ProductService productService;

    @Mock
    private ProductRepository productRepository;

    @Test
	public void findAllTest() {
		when(productRepository.findAll()).thenReturn(Stream
				.of(new Product(2, "Samsung", "Excellent", 4), new Product(1, "Iphone", "Nice Product", 5)).collect(Collectors.toList()));
		assertEquals(2, productService.findAll().size());
    }
    
    // @Test
	// public void addProductReviewTest() {
	// 	Product product = new Product(0, "Lenovo", "Not bad", 3);
	// 	when(productRepository.save(product)).thenReturn(product);
	// 	assertEquals(product, productService.addProductReview(product));
    // }
    
    // @Test
	// public void getByProductIdTest() {
	// 	int productId = 1;
	// 	when(productRepository.findById(productId))
	// 			.thenReturn(Stream.of(new List<Product>(1, "Iphone", "Excellent",5)).collect(Collectors.toList()));
	// 	assertEquals(1, productService.findByProductId(productId).size());
	// }

    @Test
	public void deleteProductReview() {
        Integer productId=1;
		productService.deleteProductReview(productId);
        verify(productRepository, times(1)).deleteById(productId);
	}


}