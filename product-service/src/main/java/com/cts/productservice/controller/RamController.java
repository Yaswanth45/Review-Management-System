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

@Api(value = "The Ram Controller", description = "Rest controller for Ram")
@RestController
@CrossOrigin
@RequestMapping("products/")
public class RamController {
	
	private Logger log=LoggerFactory.getLogger(this.getClass());
	
    @Autowired
    public RamService ramService;
    
    //Operation on Ram

	@ApiOperation(value = "Add a Ram Review",
	consumes = "A new Review in JSON",
	notes = "Hit this URL to insert a new Ram review details"
	)
	@PostMapping(value="ram/reviews")
	public void addReviews(@RequestBody Ram ram) {
		log.info("Adding the Ram reviews {}");
		ramService.addRamReviews(ram);
	}
	
	@ApiOperation(value = "Get a Ram Review",
	consumes = "A new Review in JSON",
	notes = "Hit this URL to get a  Ram review details"
	)
	@GetMapping("ram/reviews/{rid}")
	public ResponseEntity<Ram> getByRamId(@PathVariable(name = "rid") int ramId) {
		ResponseEntity<Ram> result;
		log.debug("Request to get the reviews by ramId {}",ramId);
		Ram entity = ramService.getByRamId(ramId).orElse(null);
		if (null != entity) {
			result = new ResponseEntity<Ram>(entity, HttpStatus.OK);
		} else {
			result = new ResponseEntity<Ram>(HttpStatus.NOT_FOUND);
		}
		log.debug("Reviews by the ramId {}",result);
		return result;
    }
	
	@ApiOperation(value = "Delete a Ram Review",
	consumes = "A ramId in JSON",
	notes = "Hit this URL to delete a Ram review details"
	)
	@DeleteMapping(value = "ram/reviews/delete/{ramId}")
	public void deleteRamReview(@PathVariable int ramId) {
		log.info("Request to delete the reviews by ramId {}",ramId);
		ramService.deleteRamReview(ramId);
	}

	@ApiOperation(value = "Get all Ram Reviews",
	consumes = "Nothing direct mapping",
	notes = "Hit this URL to get all Ram review details"
	)
    @GetMapping("ram/reviews")
	public ResponseEntity<Iterable<Ram>> getAllRam() {
		log.debug("Request to get all reviews {}");
		ResponseEntity<Iterable<Ram>> result=new ResponseEntity<Iterable<Ram>>(ramService.getAllRam(),HttpStatus.OK);
		log.debug("All reviews of Ram {}",result);
		return result;
	}
	
	@ApiOperation(value = "Get a Ram Review by ProductId",
	consumes = "A new Review in JSON",
	notes = "Hit this URL to get a Ram review details"
	)
	@GetMapping("ram/reviews/productId/{pid}")
	public List<Ram> findByProductIdRam(@PathVariable(name = "pid") int productId) {
		log.debug("Request to get the reviews by productId {}",productId);
		List<Ram> result= ramService.findByProductIdRam(productId);
		log.debug("All reviews based on productId {}",result);
		return result;
	}
}