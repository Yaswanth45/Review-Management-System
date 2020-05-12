package com.cts.productservice.service;

import java.util.List;

import com.cts.productservice.entity.*;
import com.cts.productservice.repo.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RamService {

    @Autowired
    public RamRepository ramRepository;

    public void addRamReviews(Ram ram){
        ramRepository.save(ram);
    }
    
    public List<Ram> getByRamId(int ramId){
        return ramRepository.findById(ramId);
    }

    public List<Ram> findByProductIdRam(int productId){
        return ramRepository.findByProductIdRam(productId);
    }

    public void deleteRamReview(int ramId){
        ramRepository.deleteById(ramId);
    }

    public List<Ram> getAllRam(){
        return ramRepository.findAll();
    }
}