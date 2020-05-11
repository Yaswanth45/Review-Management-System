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

@Api(value = "The Camera Controller", description = "Rest controller for Camera")
@RestController
@CrossOrigin
@RequestMapping("products/")
public class CameraController {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
    
    @Autowired
    public CameraService cameraService;

    //Operation on Camera

	@ApiOperation(value = "Add a Camera Review",
	consumes = "A new Review in JSON",
	notes = "Hit this URL to insert a new Camera review details"
	)
	@PostMapping(value="camera/reviews")
	public void addReviews(@RequestBody Camera camera) {

		logger.info("Adding camera review {}",camera);
		cameraService.addCameraReviews(camera);
	}
		
	@ApiOperation(value = "Get a Camera Review",
	consumes = "A new Review in JSON",
	notes = "Hit this URL to get a Camera review details"
	)
	@GetMapping("camera/reviews/{cid}")
	public ResponseEntity<Camera> getByCameraId(@PathVariable(name = "cid") int cameraId) {
		ResponseEntity<Camera> result;

		logger.debug("Request the cameraID to get reviews {}",cameraId);
		Camera entity = cameraService.getByCameraId(cameraId).orElse(null);
		if (null != entity) {
			result = new ResponseEntity<Camera>(entity, HttpStatus.OK);
		} else {
			result = new ResponseEntity<Camera>(HttpStatus.NOT_FOUND);
		}
		logger.debug("Output {}",result);
		return result;
	}
	
	@ApiOperation(value = "Delete a Camera Review",
	consumes = "A cameraId in JSON",
	notes = "Hit this URL to delete a Camera review details"
	)
	@DeleteMapping(value = "camera/reviews/delete/{cameraId}")
	public void deleteCameraReview(@PathVariable int cameraId) {

		logger.info("Deleting the camera review with its Id {}",cameraId);
		cameraService.deleteCameraReview(cameraId);
	}
	
	@ApiOperation(value = "Get all Camera Reviews",
	consumes = "Nothing direct mapping",
	notes = "Hit this URL to get all Camera review details"
	)
	@GetMapping("camera/reviews")
	public ResponseEntity<Iterable<Camera>> getAllCamera() {

		logger.info("Get All camera Reviews {}");
		return new ResponseEntity<Iterable<Camera>>(cameraService.getAllCamera(),HttpStatus.OK);
	}
	
	@ApiOperation(value = "Get a Camera Review by ProductId",
	consumes = "A new Review in JSON",
	notes = "Hit this URL to get a Camera review details"
	)
	@GetMapping("camera/reviews/productId/{pid}")
	public List<Camera> findByProductIdCamera(@PathVariable(name = "pid") int productId) {

		logger.debug("Getting the camera review with productId {}",productId);
		List<Camera> result= cameraService.findByProductIdCamera(productId);

		logger.debug("Output {}",result);

		return result;
	}
}