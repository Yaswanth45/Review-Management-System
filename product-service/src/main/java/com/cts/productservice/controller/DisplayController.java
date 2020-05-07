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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value = "The Display Controller", description = "Rest controller for Display")
@RestController
@CrossOrigin
public class DisplayController {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
    
    @Autowired
    public DisplayService displayService;

    //Operation on Display

	@ApiOperation(value = "Add a Display Review",
	consumes = "A new Review in JSON",
	notes = "Hit this URL to insert a new Display review details"
	)
	@RequestMapping(method=RequestMethod.POST,value="reviews/display")
	void addReviews(@RequestBody Display display) {

		logger.info("Adding the new display review {}",display);
		displayService.addDisplayReviews(display);
	}
		
	@ApiOperation(value = "Get a Display Review",
	consumes = "A new Review in JSON",
	notes = "Hit this URL to get a Display review details"
	)
	@RequestMapping("reviews/display/{did}")
	public ResponseEntity<Display> getByDisplayId(@PathVariable(name = "did") int displayId) {
		ResponseEntity<Display> result;
		logger.debug("Getting the display reviews with displayId {]",displayId);
		Display entity = displayService.getByDisplayId(displayId).orElse(null);
		if (null != entity) {
			result = new ResponseEntity<Display>(entity, HttpStatus.OK);
		} else {
			result = new ResponseEntity<Display>(HttpStatus.NOT_FOUND);
		}
		logger.debug("Output {}",result);
		return result;
	}
		
	@ApiOperation(value = "Delete a Display Review",
	consumes = "A displayId in JSON",
	notes = "Hit this URL to delete a Display review details"
	)
	@RequestMapping(method = RequestMethod.DELETE, value = "reviews/delete/display/{displayId}")
	void deleteDisplayReview(@PathVariable int displayId) {
		logger.info("Deleting the reviews with displayId {}",displayId);
		displayService.deleteDisplayReview(displayId);
	}

	@ApiOperation(value = "Get all Display Reviews",
	consumes = "Nothing direct mapping",
	notes = "Hit this URL to get all Display review details"
	)
	@RequestMapping("reviews/display")
	public ResponseEntity<Iterable<Display>> getAllDisplay() {
		logger.debug("Get all display reviews");
		ResponseEntity<Iterable<Display>> result =new ResponseEntity<Iterable<Display>>(displayService.getAllDisplay(),HttpStatus.OK);
		
		logger.debug("Display Reviews {}",result);
		return result;
	}

	@ApiOperation(value = "Get a Display Review by ProductId",
	consumes = "A new Review in JSON",
	notes = "Hit this URL to get a Display review details"
	)
	@RequestMapping("reviews/display/products/{pid}")
	List<Display> findByProductIdDisplay(@PathVariable(name = "pid") int productId) {

		logger.debug("Get all reviews based on productId {}",productId);
		List<Display> result= displayService.findByProductIdDisplay(productId);

		logger.debug("The Reviews {}",result);
		return result;
	}
}