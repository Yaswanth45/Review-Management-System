package com.cts.review.controller;


import java.util.Arrays;
import java.util.List;

import com.cts.review.model.Product;
import com.cts.review.service.ProductService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class ProductController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
	protected ProductService proxy;

	@Autowired
	public ProductController(ProductService proxy) {
		super();
		this.proxy = proxy;
	}

    @HystrixCommand(fallbackMethod= "fallback")
    @RequestMapping(value = "/reviews/{products}", method = RequestMethod.GET)
    public Product Reviews(@PathVariable("products") String products) {
        
        Product reviews = proxy.getReviews(products);
        logger.info("{}",reviews);

        return new Product(reviews.getProductId());
    }

    public List<Product> fallback(@PathVariable("products") String products) {
        
        System.out.println("Server down");
        logger.info("Server down due to some issue");
		return Arrays.asList(
				new Product(1, "Fallback product", "This is a fallback product, means the server is down", 2));
    }
    
}