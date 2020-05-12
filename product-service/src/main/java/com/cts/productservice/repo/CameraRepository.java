package com.cts.productservice.repo;

import java.util.List;

import com.cts.productservice.entity.*;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CameraRepository extends CrudRepository<Camera,Integer> {
    
        
    @Query(value = "Select * from camera e where e.p_id=:productId",nativeQuery = true)
    List<Camera> findByProductIdCamera(int productId);

    List<Camera> findById(int cameraId);

    List<Camera> findAll();
}