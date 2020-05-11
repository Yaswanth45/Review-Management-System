package com.cts.review.controller;

import com.cts.review.entity.Product;
import com.cts.review.service.ReviewService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value = "The Review Controller", description = "Rest controller for Review")
@RestController
public class ReviewController {

    private  Logger log = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private ReviewService reviewService;

    @ApiOperation(value = "Get a Product Review from Product Service",
	consumes = "A new Review in JSON",
	notes = "Hit this URL to get a new product's details"
	)
    @HystrixCommand(fallbackMethod = "fallback")
    @GetMapping(value = "reviews/products/{p_id}")
    public Product getReviews(@PathVariable(name="p_id") int productId){
        log.info("Getting info from product");
        return reviewService.getReviews(productId);
    }

    public Product fallback(int productId){
    
      log.error("Server Down");
      return new Product(0,"Samsung","Good",4);
    }

    @ApiOperation(value = "Delete a Product Review in Product Service",
	consumes = "A new Review Id in JSON",
	notes = "Hit this URL to delete a new product's details"
	)
    @DeleteMapping(value = "reviews/products/delete/{p_id}")
    public void deleteReviews(@PathVariable(name="p_id") int productId){
        log.info("Deleting reviews in  product");
        reviewService.deleteReviews(productId);
    }

    @ApiOperation(value = "Add a Product Review in Product Service",
	consumes = "A new Review  in JSON",
	notes = "Hit this URL to Post a new product's details"
	)
    @PostMapping(value = "reviews/products")
    public void addReviews(Product product){
        log.info("Posting reviews in  product");
        reviewService.addReviews(product);
    }

}