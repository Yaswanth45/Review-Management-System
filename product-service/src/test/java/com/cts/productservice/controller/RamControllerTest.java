package com.cts.productservice.controller;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
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

    // @Test
	// public void getAllRamTest() {
	// when(ramRepository.findAll()).thenReturn(Stream
	// .of(new Ram(1, 8, new
	// Product(1,"Iphone","Excellent",5),"Excellent", 4), new Ram(2, 6,new
	// Product(2,"Samsung","Excellent",4), "Long lasting",
	// 5)).collect(Collectors.toList()));
	// assertEquals(2, ramService.getAllRam().size());
	// }

	
    // @Test
	// public void addProductReviewTest() {
	// 	Battery battery = new Battery(0, "6000mah", new Product(1,"Iphone","Excellent",5),"long life", 4);
	// 	when(batteryRepository.save(battery)).thenReturn(battery);
	// 	assertEquals(battery, batteryService.addBatteryReviews(battery));
    // }
    
    // @Test
	// public void getByRamIdTest() {
	// 	int ramId = 1;
	// 	when(ramRepository.findById(ramId))
	// 			.thenReturn(Stream.of(new List<Ram>(1, 8, "Excellent",4)).collect(Collectors.toList()));
	// 	assertEquals(1, ramService.getByRamId(ramId).size());
	// }


	@Test
	public void deleteProduct() {
        Integer ramId=1;
		ramService.deleteRamReview(ramId);
        verify(ramRepository, times(1)).deleteById(ramId);
	}
}