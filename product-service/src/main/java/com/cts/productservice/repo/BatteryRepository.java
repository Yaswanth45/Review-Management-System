package com.cts.productservice.repo;


import java.util.List;

import com.cts.productservice.entity.*;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BatteryRepository extends CrudRepository<Battery,Integer>{
    
    @Query(value = "Select * from battery e where e.p_id=:productId",nativeQuery = true)
    List<Battery> findByProductId(int productId);

    List<Battery> findById(int batteryId);

    List<Battery> findAll();
}