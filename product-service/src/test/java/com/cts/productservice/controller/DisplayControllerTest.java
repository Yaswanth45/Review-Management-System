package com.cts.productservice.controller;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.cts.productservice.entity.Display;
import com.cts.productservice.entity.Product;
import com.cts.productservice.repo.DisplayRepository;
import com.cts.productservice.service.DisplayService;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class DisplayControllerTest {
    
    @InjectMocks
    private DisplayService displayService;

    @Mock
    private DisplayRepository displayRepository;

    @Test
	public void getAllDisplayTest() {
	when(displayRepository.findAll()).thenReturn(Stream
	.of(new Display(1, 8,new
	Product(1,"Iphone","Excellent",5),"Good", 4), new Display(2, 6,new
	Product(2,"Samsung","Excellent",4), "Nice",
	5)).collect(Collectors.toList()));
	assertEquals(2, displayService.getAllDisplay().size());
	}
	
	@Test
	public void addCameraReviewTest() {
		String message="Sucessfully added";
		Display display=new Display(1, 6,new Product(1,"Iphone","Excellent",5), "Excellent",5);
		when(displayRepository.save(display)).thenReturn(display);
		assertEquals(message, displayService.addDisplayReviews(display));
	}
	
    @Test
	public void getByDisplayIdTest() {
		int displayId = 1;
		when(displayRepository.findById(displayId))
				.thenReturn(Stream.of(new Display(1, 6,new Product(1,"Iphone","Excellent",5), "Excellent",5)).collect(Collectors.toList()));
		assertEquals(1, displayService.getByDisplayId(displayId).size());
    }

	
	@Test
	public void deleteProduct() {
        Integer displayId=1;
		displayService.deleteDisplayReview(displayId);
        verify(displayRepository, times(1)).deleteById(displayId);
	}
}