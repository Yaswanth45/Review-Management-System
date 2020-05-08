package com.cts.review.service;

import com.cts.review.entity.Product;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ReviewService {
    
    private  Logger log = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private RestTemplate restTemplate;

	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
    }
    
    public Product getReviews(int productId){

        log.info("To get all the reviews from product-service{}");
       Product result= restTemplate.getForObject("http://localhost:8965/reviews/products/{p_id}",Product.class,productId);
        
       return result;
    }

    public void deleteReviews(int productId){

        log.info("To get all the reviews from product-service{}");
        restTemplate.getForObject("http://localhost:8965/reviews/delete/products/{p_id}",Product.class,productId);
        
    }

    public void addReviews(Product product){
        log.info("Adding the product into product-service");
        restTemplate.getForObject("http://localhost:8965/reviews/products",Product.class,product);
    }

}