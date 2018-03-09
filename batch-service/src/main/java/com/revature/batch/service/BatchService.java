package com.revature.batch.service;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.batch.bean.Batch;
import com.revature.batch.repository.BatchRepository;


@Service
public class BatchService {
	@Autowired
	BatchRepository batchRepository;
	
	public void addOrUpdateBatch(Batch b) {
		batchRepository.save(b);
	}

	public Batch getBatchById(Integer id) {
		LogManager.getLogger(BatchService.class).fatal(batchRepository);
		return batchRepository.findById(id);
	}

	public List<Batch> getBatchAll() {
		return batchRepository.findAll();
	}

	public List<Batch> getBatchByTrainer(Integer trainer) {
		return batchRepository.findByTrainer(trainer);
	}
	
	/**
	 * Populates batch using a list of curriculum subtopics.
	 * 
	 * NOTE: This method assumes all batches start on a Monday.
	 * 
	 * @author DillonT
	 * @param currSubtopics
	 * @param batch
	 */
}