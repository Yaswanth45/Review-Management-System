package com.cts.productservice.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cts.productservice.entity.*;

@Repository
public interface ProductRepository extends CrudRepository<Product, Integer> {

}
