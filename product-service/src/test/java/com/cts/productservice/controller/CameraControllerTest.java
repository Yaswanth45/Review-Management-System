package com.cts.productservice.controller;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import com.cts.productservice.repo.CameraRepository;
import com.cts.productservice.service.CameraService;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class CameraControllerTest {

    @InjectMocks
    private CameraService cameraService;

    @Mock
    private CameraRepository cameraRepository;

    // @Test
	// public void getAllCameraTest() {
	// when(cameraRepository.findAll()).thenReturn(Stream
	// .of(new Camera(1, 16 ,new
	// Product(1,"Iphone","Excellent",5),"Good", 4), new Camera(2, 20,new
	// Product(2,"Samsung","Excellent",4), "selfie",
	// 5)).collect(Collectors.toList()));
	// assertEquals(2, cameraService.getAllCamera().size());
	// }

	
	@Test
	public void deleteProduct() {
        Integer cameraId=1;
		cameraService.deleteCameraReview(cameraId);
        verify(cameraRepository, times(1)).deleteById(cameraId);
	}
    
}