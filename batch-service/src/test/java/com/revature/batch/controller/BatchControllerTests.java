package com.revature.batch.controller;

import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.naming.spi.DirStateFactory.Result;

import org.assertj.core.api.Assertions;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.PathVariable;

import com.revature.batch.bean.Batch;
import com.revature.batch.bean.BatchType;
import com.revature.batch.exception.BatchUpdateException;
import com.revature.batch.exception.NoBatchException;
import com.revature.batch.repository.BatchRepository;
import com.revature.batch.repository.BatchTypeRepository;
import com.revature.batch.service.BatchService;
import com.revature.batch.service.TrainerService;

public class BatchControllerTests {
	
	TrainerService mockTrainerService = mock(TrainerService.class);
	BatchService mockBatchService = mock(BatchService.class);
	BatchController batchController = new BatchController(mockTrainerService, mockBatchService);
	
	@Rule
	public ExpectedException thrown = ExpectedException.none();
	
	@Test
	public void getBatchAll_returnsNonEmptyResult() throws NoBatchException {
		// Setup
		List<Batch> batch = new ArrayList<Batch>();
		batch.add(new Batch(null, null, null, null, new BatchType(1, null, null)));
		when(mockBatchService.getBatchAll()).thenReturn(batch);
		
		// Execute
		List<Batch> result = batchController.getBatchAll();
		
		// Verify
		assertTrue(!result.isEmpty());
	}
	
	@Test
	public void getBatchAll_returnsCorrectInstanceof() throws NoBatchException {
		// Setup
		List<Batch> batch = new ArrayList<Batch>();
		batch.add(new Batch(null, null, null, null, new BatchType(1, null, null)));
		when(mockBatchService.getBatchAll()).thenReturn(batch);
		
		// Execute
		List<Batch> result = batchController.getBatchAll();
		
		// Verify
		assertTrue(result.get(0) instanceof Batch);
	}
	
	@Test(expected = NoBatchException.class)
	public void getBatchAll_returnsCorrectException() throws NoBatchException {
		// Setup
		List<Batch> batch = new ArrayList<Batch>();
		when(mockBatchService.getBatchByTrainerID(1)).thenReturn(batch);
		
		// Execute
		batchController.getBatchAll();
	}
	
	@Test(expected = NoBatchException.class)
	public void getPastBatches_returnsCorrectException() throws NoBatchException {
		// Setup
		List<Batch> batch = new ArrayList<Batch>();
		when(mockBatchService.getBatchByTrainerID(1)).thenReturn(batch);
		
		// Execute
		batchController.getPastBatches("email@email.com");
	}
	
	@Test(expected = NoBatchException.class)
	public void getFutureBatches_returnsCorrectException() throws NoBatchException {
		// Setup
		List<Batch> batch = new ArrayList<Batch>();
		when(mockBatchService.getBatchByTrainerID(1)).thenReturn(batch);
		
		// Execute
		batchController.getFutureBatches("email@email.com");
	}
	
	@Test(expected = NoBatchException.class)
	public void getBatchInProgress_returnsCorrectException() throws NoBatchException {
		// Setup
		List<Batch> batch = new ArrayList<Batch>();
		when(mockBatchService.getBatchByTrainerID(1)).thenReturn(batch);
		
		// Execute
		batchController.getBatchInProgress("email@email.com");
	}
	
	@Test(expected = NoBatchException.class)
	public void getAllBatchesInProgress_returnsCorrectException() throws NoBatchException {
		// Setup
		List<Batch> batch = new ArrayList<Batch>();
		when(mockBatchService.getBatchByTrainerID(1)).thenReturn(batch);
		
		// Execute
		batchController.getAllBatchesInProgress("email@email.com");
	}
	
	@Test(expected = NoBatchException.class)
	public void getBatchById_returnsCorrectException() throws NoBatchException {
		// Setup
		Batch batch = new Batch();
		when(mockBatchService.getBatchById(1)).thenReturn(batch);
		
		// Execute
		batchController.getBatchById(2);
	}
	
	@Test(expected = BatchUpdateException.class)
	public void updateBatch_returnsCorrectException() throws BatchUpdateException {
		// Setup
		Batch batch = new Batch();
		when(mockBatchService.addOrUpdateBatch(batch)).thenReturn(batch);
		
		// Execute
		batchController.updateBatch(new Batch());
	}
	
	@Test(expected = NoBatchException.class)
	public void getAllBatchTypes_returnsCorrectException() throws NoBatchException {
		// Setup
		List<BatchType> batches = new ArrayList<BatchType>();
		when(mockBatchService.getAllBatchTypes()).thenReturn(batches);
		
		// Execute
		batchController.getAllBatchTypes();
	}
	
	@Test(expected = NoBatchException.class)
	public void getAllInProgress_returnsCorrectException() throws NoBatchException {
		// Setup
		List<Batch> batch = new ArrayList<Batch>();
		when(mockBatchService.currentBatches()).thenReturn(batch);
		
		// Execute
		batchController.getAllInProgress();
	}
	
}
