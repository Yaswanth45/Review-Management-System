package com.cts.productservice.service;

import java.util.List;
import java.util.Optional;

import com.cts.productservice.entity.*;
import com.cts.productservice.repo.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CameraService {

    @Autowired
    public CameraRepository cameraRepository;

    public void addCameraReviews(Camera camera){
        cameraRepository.save(camera);
    }

    public Optional<Camera> getByCameraId(int cameraId){
        return cameraRepository.findById(cameraId);
    }

    public List<Camera> findByProductIdCamera(int productId){
        return cameraRepository.findByProductIdCamera(productId);
    }

    public void deleteCameraReview(int cameraId) {
		cameraRepository.deleteById(cameraId);	
	} 

    public Iterable<Camera> getAllCamera(){
        return cameraRepository.findAll();
    }
}