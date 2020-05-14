package com.cts.productservice.controller;

import java.util.List;

import com.cts.productservice.entity.*;
import com.cts.productservice.service.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value = "The Product Controller", description = "Rest controller for Product")
@RestController
@RequestMapping("/products/reviews")
@CrossOrigin
public class ProductController {
	
	private Logger log=LoggerFactory.getLogger(this.getClass());

    @Autowired
    public ProductService productService;  

	//Operation on Products

	@ApiOperation(value = "Add a Product Review",
	consumes = "A new Review in JSON",
	notes = "Hit this URL to insert a new product's details"
	)
    @PostMapping
	public String addProductReviews(@RequestBody Product product) {
		log.info("Adding the product Reviews {}",product);
		return productService.addProductReview(product);
	}
	
	@ApiOperation(value = "Get a Product Review",
	consumes = "A new Review in JSON",
	notes = "Hit this URL to get a  Product review details"
	)
	@GetMapping("{p_id}")
	public ResponseEntity<List<Product>> getByProductId(@PathVariable(name = "p_id") int productId) {
		ResponseEntity<List<Product>> result;
		log.debug("Request to get a review by productId {}",productId);
		List<Product> entity = productService.findByProductId(productId);
		if (null != entity) {
			result = new ResponseEntity<List<Product>>(entity, HttpStatus.OK);
		} else {
			result = new ResponseEntity<List<Product>>(HttpStatus.NOT_FOUND);
		}
		log.debug("Reviews by Product Id {}",result);
		return result;
    }
	
	@ApiOperation(value = "Delete a Product Review",
	consumes = "A productId in JSON",
	notes = "Hit this URL to delete a Product review details"
	)
	@DeleteMapping(value = "/delete/{productId}")
	public void deleteProductReview(@PathVariable int productId) {
		log.info("request to delete the review by productId {}",productId);
		productService.deleteProductReview(productId);
	}

	@ApiOperation(value = "Get all Reviews",
	consumes = "Nothing direct mapping",
	notes = "Hit this URL to get all review details"
	)
    @GetMapping
	public ResponseEntity<List<Product>> findAll() {
		log.debug("Request to get the products {}");
		ResponseEntity<List<Product>> result=new ResponseEntity<List<Product>>(productService.findAll(),HttpStatus.OK);
		log.debug("All Product reviews {}",result);

		return result;
	}
}