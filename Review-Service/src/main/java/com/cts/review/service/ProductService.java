package com.cts.review.service;



import com.cts.review.model.Product;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name="product-service",url="localhost:8965")
//@FeignClient(name="currency-exchange-service")
public interface ProductService {
    
    @RequestMapping(value = "/reviews/{servicename}", method = RequestMethod.GET)
    Product getReviews(@PathVariable("servicename") String servicename);
}