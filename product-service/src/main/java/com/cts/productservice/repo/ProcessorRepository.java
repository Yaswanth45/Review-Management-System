package com.cts.productservice.repo;

import java.util.List;

import com.cts.productservice.entity.*;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProcessorRepository extends CrudRepository<Processor,Integer> {
    
        
    @Query(value = "Select * from processor e where e.p_id=:productId",nativeQuery = true)
    List<Processor> findByProductIdProcessor(int productId);
}