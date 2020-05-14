package com.cts.productservice.controller;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.cts.productservice.entity.Processor;
import com.cts.productservice.entity.Product;
import com.cts.productservice.repo.ProcessorRepository;
import com.cts.productservice.service.ProcessorService;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class ProcessorControllerTest {
    
    @InjectMocks
    private ProcessorService processorService;

    @Mock
    private ProcessorRepository processorRepository;

    @Test
	public void getAllProcessorTest() {
	when(processorRepository.findAll()).thenReturn(Stream
	.of(new Processor(1, "SanpDragon" ,new
	Product(1,"Iphone","Excellent",5),"Good", 4), new Processor(2, "Qualcom",new
	Product(2,"Samsung","Excellent",4), "Nice",
	5)).collect(Collectors.toList()));
	assertEquals(2, processorService.getAllProcessor().size());
	}

	@Test
	public void addProductReviewTest() {
		String message="Sucessfully added";
		Processor processor = new Processor(1, "SanpDragon" ,new Product(1,"Iphone","Excellent",5),"Good", 4);
		when(processorRepository.save(processor)).thenReturn(processor);
		assertEquals(message,processorService.addProcessorReview(processor));
	}
	
	@Test
	public void getByProcessorIdTest() {
		int processorId = 1;
		when(processorRepository.findById(processorId))
			.thenReturn(Stream.of(new Processor(1, "SanpDragon" ,new Product(1,"Iphone","Excellent",5),"Good", 4)).collect(Collectors.toList()));
		assertEquals(1, processorService.getByProcessorId(processorId).size());
    }
	
	@Test
	public void deleteProduct() {
        Integer processorId=1;
		processorService.deleteProcessorReview(processorId);
        verify(processorRepository, times(1)).deleteById(processorId);
	}
}