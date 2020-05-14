package com.cts.productservice.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.cts.productservice.entity.Battery;
import com.cts.productservice.entity.Product;
import com.cts.productservice.repo.BatteryRepository;
import com.cts.productservice.service.BatteryService;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class BatteryControllerTest {

	@InjectMocks
	private BatteryService batteryService;

	@Mock
	private BatteryRepository batteryRepository;

	@Test
	public void getAllBatteryTest() {
	when(batteryRepository.findAll()).thenReturn(Stream
	.of(new Battery(1, "5000mah",new
	Product(1,"Iphone","Excellent",5),"Excellent", 4), new Battery(2, "5200",new
	Product(2,"Samsung","Excellent",4), "Long lasting",
	5)).collect(Collectors.toList()));
	assertEquals(2, batteryService.getAllBattery().size());
	}

	
    @Test
	public void addProductReviewTest() {
		Battery battery = new Battery(0, "6000mah", new Product(1,"Iphone","Excellent",5),"long life", 4);
		when(batteryRepository.save(battery)).thenReturn(battery);
		
	}
	
    @Test
	public void getByBatteryIdTest() {
		int batteryId = 1;
		when(batteryRepository.findById(batteryId))
				.thenReturn(Stream.of(new Battery(1, "5000mah",new Product(1,"Iphone","Excellent",5),"Excellent",4)).collect(Collectors.toList()));
		assertEquals(1, batteryService.getByBatteryId(batteryId).size());
	}


	@Test
	public void deleteProduct() {
        Integer batteryId=1;
		batteryService.deleteReview(batteryId);
        verify(batteryRepository, times(1)).deleteById(batteryId);
	}
}