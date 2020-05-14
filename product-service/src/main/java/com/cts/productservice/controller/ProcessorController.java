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

@Api(value = "The Processor ", description = "Rest controller for Processor")
@RestController
@CrossOrigin
@RequestMapping("products/")
public class ProcessorController {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
    @Autowired
    public ProcessorService processorService;
    
    //Operation on Processor

	@ApiOperation(value = "Add a Processor Review",
	consumes = "A new Review in JSON",
	notes = "Hit this URL to insert a new Processor review details"
	)
	@PostMapping(value="processor/reviews")
	public String addReviews(@RequestBody Processor processor) {
		logger.info("Adding processor reviews {}",processor);
		return processorService.addProcessorReview(processor);
	}
		
	@ApiOperation(value = "Get a Processor Review",
	consumes = "A new Review in JSON",
	notes = "Hit this URL to get a Processor review details"
	)
	@GetMapping("processor/reviews/{prid}")
	public ResponseEntity<List<Processor>> getByProcessorId(@PathVariable(name = "prid") int processorId) {
		ResponseEntity<List<Processor>> result;
		logger.debug("Get the reviews by processorId {}",processorId);
		List<Processor> entity = processorService.getByProcessorId(processorId);
		if (null != entity) {
			result = new ResponseEntity<List<Processor>>(entity, HttpStatus.OK);
		} else {
			result = new ResponseEntity<List<Processor>>(HttpStatus.NOT_FOUND);
		}
		logger.debug("The reviews of processor are {}",result);
		return result;
	}
	
	@ApiOperation(value = "Delete a Processor Review",
	consumes = "A processorId in JSON",
	notes = "Hit this URL to delete a Processor review details"
	)
	@DeleteMapping(value = "processor/reviews/delete/{processorId}")
	public void deleteProcessorReview(@PathVariable int processorId) {
		logger.info("Dleteing the reviews by processorId {}",processorId);
		processorService.deleteProcessorReview(processorId);
	}
	
	@ApiOperation(value = "Get all Processor Reviews",
	consumes = "Nothing direct mapping",
	notes = "Hit this URL to get all Processor review details"
	)
	@GetMapping("processor/reviews")
	public ResponseEntity<List<Processor>> getAllProcessor() {
		logger.debug("Get all reviews ");
		ResponseEntity<List<Processor>> result=new ResponseEntity<List<Processor>>(processorService.getAllProcessor(),HttpStatus.OK);
		logger.debug("All Processor Reviews {}",result);
		return result;
	}

	
	@ApiOperation(value = "Get a Processor Review by ProductId",
	consumes = "A new Review in JSON",
	notes = "Hit this URL to get a Processor review details"
	)
	@GetMapping("processor/reviews/productId/{pid}")
	public List<Processor> findByProductIdProcessor(@PathVariable(name = "pid") int productId) {
		logger.debug("Request to get the processor review by productId {}",productId);
		List<Processor> result= processorService.findByProductIdProcessor(productId);

		logger.debug("All reviews with productId {}",result);
		return result;
	}
	
}