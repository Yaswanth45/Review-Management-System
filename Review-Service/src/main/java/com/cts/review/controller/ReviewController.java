package com.cts.review.controller;

import com.cts.review.entity.Product;
import com.cts.review.service.ReviewService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
    //@HystrixCommand(fallbackMethod = "fallback")
    @RequestMapping(value = "reviews/products/{p_id}", method = RequestMethod.GET)
    public Product getReviews(@PathVariable(name="p_id") int productId){
        log.info("Getting info from product");
        return reviewService.getReviews(productId);
    }

    @ApiOperation(value = "Delete a Product Review in Product Service",
	consumes = "A new Review Id in JSON",
	notes = "Hit this URL to delete a new product's details"
	)
    @RequestMapping(value = "reviews/delete/products/{p_id}", method = RequestMethod.DELETE)
    public void deleteReviews(@PathVariable(name="p_id") int productId){
        log.info("Deleting reviews in  product");
        reviewService.deleteReviews(productId);
    }

    @ApiOperation(value = "Add a Product Review in Product Service",
	consumes = "A new Review  in JSON",
	notes = "Hit this URL to Post a new product's details"
	)
    @RequestMapping(value = "reviews/products", method = RequestMethod.POST)
    public void addReviews(Product product){
        log.info("Deleting reviews in  product");
        reviewService.addReviews(product);
    }

}