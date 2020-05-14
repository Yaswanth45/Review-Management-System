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

@Api(value = "The Battery Controller", description = "Rest controller for Battery")
@RestController
@CrossOrigin
@RequestMapping("products/")
public class BatteryController {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
    @Autowired
    public BatteryService batteryService;
    
    //Operation on Battery

	@ApiOperation(value = "Add a Battery Review",
	consumes = "A new Review in JSON",
	notes = "Hit this URL to insert a new Battery review details"
	)
	@PostMapping(value="battery/reviews")
	public String addReviews(@RequestBody Battery battery) {

		logger.info("Adding the battery reviews {}",battery);
		return batteryService.addBatteryReviews(battery);
	}
		
	@ApiOperation(value = "Get a Battery Review",
	consumes = "A new Review in JSON",
	notes = "Hit this URL to get a Battery review details"
	)
	@GetMapping("battery/reviews/{bid}")
	public ResponseEntity<List<Battery>> getByBatteryId(@PathVariable(name = "bid") int batteryId) {
		ResponseEntity<List<Battery>> result;

		logger.debug("Request {}",batteryId);
		List<Battery> entity = batteryService.getByBatteryId(batteryId);
		if (null != entity) {
			result = new ResponseEntity<List<Battery>>(entity, HttpStatus.OK);
		} else {
			result = new ResponseEntity<List<Battery>>(HttpStatus.NOT_FOUND);
		}

		logger.debug("{}",result);
		return result;
	}

	@ApiOperation(value = "Get a Battery Review by ProductId",
	consumes = "A new Review in JSON",
	notes = "Hit this URL to get a Battery review details"
	)
	@GetMapping("battery/reviews/productId/{pid}")
	public List<Battery> getAllProductsByProductId(@PathVariable(name = "pid") int productId) {
		logger.debug("Request {}",productId);
		List<Battery> result= batteryService.findByProductId(productId);

		logger.debug("Output {}",result);

		return result;
	}
	
	@ApiOperation(value = "Delete a Battery Review",
	consumes = "A batteryId in JSON",
	notes = "Hit this URL to delete a Battery review details"
	)
	@DeleteMapping(value = "battery/reviews/delete/{batteryId}")
	public void deleteProduct(@PathVariable int batteryId) {
		logger.info("Delete a battery review {}",batteryId);
		batteryService.deleteReview(batteryId);
	}
	
	@ApiOperation(value = "Get all Battery Reviews",
	consumes = "Nothing direct mapping",
	notes = "Hit this URL to get all Battery review details"
	)
	@GetMapping("battery/reviews")
	public ResponseEntity<List<Battery>> getAllBattery() {

		logger.info("Request All reviews {}");

		return new ResponseEntity<List<Battery>>(batteryService.getAllBattery(),HttpStatus.OK);

	}

}