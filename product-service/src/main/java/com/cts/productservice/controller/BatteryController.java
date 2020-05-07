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

@Api(value = "The Battery Controller", description = "Rest controller for Battery")
@RestController
@CrossOrigin
public class BatteryController {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
    @Autowired
    public BatteryService batteryService;
    
    //Operation on Battery

	@ApiOperation(value = "Add a Battery Review",
	consumes = "A new Review in JSON",
	notes = "Hit this URL to insert a new Battery review details"
	)
	@RequestMapping(method=RequestMethod.POST,value="reviews/battery")
	void addReviews(@RequestBody Battery battery) {

		logger.info("Adding the battery reviews {}",battery);
		batteryService.addBatteryReviews(battery);
	}
		
	@ApiOperation(value = "Get a Battery Review",
	consumes = "A new Review in JSON",
	notes = "Hit this URL to get a Battery review details"
	)
	@RequestMapping("reviews/battery/{bid}")
	public ResponseEntity<Battery> getByBatteryId(@PathVariable(name = "bid") int batteryId) {
		ResponseEntity<Battery> result;

		logger.debug("Request {}",batteryId);
		Battery entity = batteryService.getByBatteryId(batteryId).orElse(null);
		if (null != entity) {
			result = new ResponseEntity<Battery>(entity, HttpStatus.OK);
		} else {
			result = new ResponseEntity<Battery>(HttpStatus.NOT_FOUND);
		}

		logger.debug("{}",result);
		return result;
	}

	@ApiOperation(value = "Get a Battery Review by ProductId",
	consumes = "A new Review in JSON",
	notes = "Hit this URL to get a Battery review details"
	)
	@RequestMapping("reviews/battery/products/{pid}")
	List<Battery> getAllProductsByProductId(@PathVariable(name = "pid") int productId) {
		logger.debug("Request {}",productId);
		List<Battery> result= batteryService.findByProductId(productId);

		logger.debug("Output {}",result);

		return result;
	}
	
	@ApiOperation(value = "Delete a Battery Review",
	consumes = "A batteryId in JSON",
	notes = "Hit this URL to delete a Battery review details"
	)
	@RequestMapping(method = RequestMethod.DELETE, value = "reviews/delete/battery/{batteryId}")
	void deleteProduct(@PathVariable int batteryId) {
		logger.info("Delete a battery review {}",batteryId);
		batteryService.deleteReview(batteryId);
	}
	
	@ApiOperation(value = "Get all Battery Reviews",
	consumes = "Nothing direct mapping",
	notes = "Hit this URL to get all Battery review details"
	)
	@RequestMapping("reviews/battery")
	public ResponseEntity<Iterable<Battery>> getAllBattery() {

		logger.info("Request All reviews {}");

		return new ResponseEntity<Iterable<Battery>>(batteryService.getAllBattery(),HttpStatus.OK);

	}

}