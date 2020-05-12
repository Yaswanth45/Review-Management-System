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

@Api(value = "The Display Controller", description = "Rest controller for Display")
@RestController
@CrossOrigin
@RequestMapping("products/")
public class DisplayController {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
    
    @Autowired
    public DisplayService displayService;

    //Operation on Display

	@ApiOperation(value = "Add a Display Review",
	consumes = "A new Review in JSON",
	notes = "Hit this URL to insert a new Display review details"
	)
	@PostMapping(value="display/reviews")
	public void addReviews(@RequestBody Display display) {

		logger.info("Adding the new display review {}",display);
		displayService.addDisplayReviews(display);
	}
		
	@ApiOperation(value = "Get a Display Review",
	consumes = "A new Review in JSON",
	notes = "Hit this URL to get a Display review details"
	)
	@GetMapping(value="display/reviews/{did}")
	public ResponseEntity<List<Display>> getByDisplayId(@PathVariable(name = "did") int displayId) {
		ResponseEntity<List<Display>> result;
		logger.debug("Getting the display reviews with displayId {}",displayId);
		List<Display> entity = displayService.getByDisplayId(displayId);
		if (null != entity) {
			result = new ResponseEntity<List<Display>>(entity, HttpStatus.OK);
		} else {
			result = new ResponseEntity<List<Display>>(HttpStatus.NOT_FOUND);
		}
		logger.debug("Output {}",result);
		return result;
	}
		
	@ApiOperation(value = "Delete a Display Review",
	consumes = "A displayId in JSON",
	notes = "Hit this URL to delete a Display review details"
	)
	@DeleteMapping(value = "display/reviews/delete/{displayId}")
	public void deleteDisplayReview(@PathVariable int displayId) {
		logger.info("Deleting the reviews with displayId {}",displayId);
		displayService.deleteDisplayReview(displayId);
	}

	@ApiOperation(value = "Get all Display Reviews",
	consumes = "Nothing direct mapping",
	notes = "Hit this URL to get all Display review details"
	)
	@GetMapping(value="display/reviews")
	public ResponseEntity<List<Display>> getAllDisplay() {
		logger.debug("Get all display reviews");
		ResponseEntity<List<Display>> result =new ResponseEntity<List<Display>>(displayService.getAllDisplay(),HttpStatus.OK);
		
		logger.debug("Display Reviews {}",result);
		return result;
	}

	@ApiOperation(value = "Get a Display Review by ProductId",
	consumes = "A new Review in JSON",
	notes = "Hit this URL to get a Display review details"
	)
	@GetMapping("display/reviews/productId/{pid}")
	public List<Display> findByProductIdDisplay(@PathVariable(name = "pid") int productId) {

		logger.debug("Get all reviews based on productId {}",productId);
		List<Display> result= displayService.findByProductIdDisplay(productId);

		logger.debug("The Reviews {}",result);
		return result;
	}
}