package com.cts.productservice.controller;


import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.cts.productservice.entity.Product;
import com.cts.productservice.entity.Ram;
import com.cts.productservice.repo.RamRepository;
import com.cts.productservice.service.RamService;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class RamControllerTest {
    
    @InjectMocks
    private RamService ramService;

    @Mock
    private RamRepository ramRepository;

    @Test
	public void getAllRamTest() {
	when(ramRepository.findAll()).thenReturn(Stream
	.of(new Ram(1, 8, new
	Product(1,"Iphone","Excellent",5),"Excellent", 4), new Ram(2, 6,new
	Product(2,"Samsung","Excellent",4), "Long lasting",
	5)).collect(Collectors.toList()));
	assertEquals(2, ramService.getAllRam().size());
	}

	
    @Test
	public void addRamReviewTest() {
		String message="Sucessfully added";
		Ram ram = new Ram(1, 8, new Product(1,"Iphone","Excellent",5),"Excellent", 4);
		when(ramRepository.save(ram)).thenReturn(ram);
		assertEquals(message, ramService.addRamReviews(ram));
    }
    
    @Test
	public void getByRamIdTest() {
		int ramId = 1;
		when(ramRepository.findById(ramId))
			.thenReturn(Stream.of(new Ram(1, 8, new Product(1,"Iphone","Excellent",5),"Excellent", 4)).collect(Collectors.toList()));
		assertEquals(1, ramService.getByRamId(ramId).size());
	}
	
	@Test
	public void deleteProduct() {
        Integer ramId=1;
		ramService.deleteRamReview(ramId);
        verify(ramRepository, times(1)).deleteById(ramId);
	}
}