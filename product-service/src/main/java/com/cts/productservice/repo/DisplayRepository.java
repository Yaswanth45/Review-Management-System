package com.cts.productservice.repo;


import java.util.List;

import com.cts.productservice.entity.*;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DisplayRepository extends CrudRepository<Display,Integer> {
    
        
    @Query(value = "Select * from display e where e.p_id=:productId",nativeQuery = true)
    List<Display> findByProductIdDisplay(int productId);

    List<Display> findById(int displayId);

    List<Display> findAll();
}