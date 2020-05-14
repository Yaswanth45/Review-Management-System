package com.cts.productservice.service;

import java.util.List;
import com.cts.productservice.entity.*;
import com.cts.productservice.repo.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProcessorService {
    
    @Autowired
    public ProcessorRepository processorRepository;

    public String addProcessorReview(Processor processor){
        String message = "Sucessfully added";
        processorRepository.save(processor);
        return message;
    }

    public List<Processor> getByProcessorId(int processorId){
        return processorRepository.findById(processorId);
    }

    public List<Processor> findByProductIdProcessor(int productId){
        return processorRepository.findByProductIdProcessor(productId);
    }

    public void deleteProcessorReview(int processorId) {
		processorRepository.deleteById(processorId);	
	}

    public List<Processor> getAllProcessor(){
        return processorRepository.findAll();
    }
}