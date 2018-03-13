package com.revature.batch.controller;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.batch.bean.Batch;
import com.revature.batch.bean.BatchType;
import com.revature.batch.service.BatchService;

@RestController
@RequestMapping(value = "/")
public class InternalBatchController {
	
	@Autowired
	BatchService batchService;
	
	@PostMapping("addOrUpdateBatch")
	public Batch addOrUpdateBatch(@RequestBody Batch batch) {
		return batchService.addOrUpdateBatch(batch);
	}

	@PostMapping("getBatchById/{id}")
	public Batch getBatchById(@PathVariable Integer id) {
		return batchService.getBatchById(id);
	}
	
	@PostMapping("getBatchAll")
	public List<Batch> getBatchAll() {
		return batchService.getBatchAll();
	}

	@PostMapping("getBatchByTrainer/{trainerID}")
	public List<Batch> getBatchByTrainerID(@PathVariable Integer trainerID) {
		return batchService.getBatchByTrainerID(trainerID);
	}
	
	@PostMapping("getAllBatchTypes")
	public List<BatchType> getAllBatchTypes() {
		return batchService.getAllBatchTypes();
	}

	@PostMapping("currentBatches")
	public List<Batch> currentBatches() {
		return batchService.currentBatches();
	}
}
