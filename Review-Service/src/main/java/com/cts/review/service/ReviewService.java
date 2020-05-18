package com.cts.review.service;

import java.util.Arrays;
import java.util.List;

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
    
    public List<Product> getReviews(int productId){

       log.info("To get all the reviews from product-service {}",productId);
       return Arrays.asList(restTemplate.getForObject("http://localhost:8965/products/reviews/{p_id}", Product[].class,productId));
                
    }

    public String deleteReviews(int productId){

        log.info("To get all the reviews from product-service{}");
        restTemplate.delete("http://localhost:8965/products/reviews/delete/{p_id}",productId);
        return "Deleted Sucessfully";
    }

    public String addReviews(Product product){
        String message="Sucessfully added";
        log.info("Adding the product into product-service");
        restTemplate.postForEntity("http://localhost:8965/products/reviews",product,String.class,product);
        return message;
    }

}