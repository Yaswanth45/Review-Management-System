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
    
    private final  Logger log = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private RestTemplate restTemplate;

	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
    }
    
    public Product getReviews(final int productId){

       log.info("To get all the reviews from product-service{}");
       return  restTemplate.getForObject("http://localhost:8965/products/reviews/{p_id}", Product.class,
               productId);
        
    }

    public void deleteReviews(final int productId){

        log.info("To get all the reviews from product-service{}");
        restTemplate.delete("http://localhost:8965/products/reviews/delete/{p_id}",productId);
        
    }

    public void addReviews(final Product product){
        log.info("Adding the product into product-service");
        restTemplate.postForObject("http://localhost:8965/products/reviews",product,Product.class,product);
    }

}