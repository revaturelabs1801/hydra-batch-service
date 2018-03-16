package com.revature.batch.service.tests;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.springframework.web.client.RestTemplate;

import com.revature.batch.bean.BamUser;
import com.revature.batch.bean.Batch;
import com.revature.batch.bean.BatchType;
import com.revature.batch.repository.BatchTypeRepository;
import com.revature.batch.service.BatchService;
import com.revature.batch.service.TrainerService;

public class TrainerServiceTests {
	
	RestTemplate mockRestTemplate = mock(RestTemplate.class);
	TrainerService trainerService = new TrainerService(mockRestTemplate);
	
	@Test
	public void getTrainerByEmail_returnsCorrectType() {
		// add some cool stuff here if you want
	}
	

}
