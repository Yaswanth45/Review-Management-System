package com.cts.productservice.repo;

import java.util.List;

import com.cts.productservice.entity.*;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RamRepository extends CrudRepository<Ram,Integer> {
    
    @Query(value = "Select * from ram e where e.p_id=:productId",nativeQuery = true)
    List<Ram> findByProductIdRam(int productId);
}