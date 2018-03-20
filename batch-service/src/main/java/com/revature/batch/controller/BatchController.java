package com.revature.batch.controller;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.revature.batch.bean.Batch;
import com.revature.batch.bean.BatchType;
import com.revature.batch.exception.BatchUpdateException;
import com.revature.batch.exception.NoBatchException;
import com.revature.batch.service.BatchService;
import com.revature.batch.service.TrainerService;

@RestController
@RequestMapping(value = "/api/v2/batch/")
public class BatchController {

	@Autowired
	TrainerService trainerService;

	@Autowired
	BatchService batchService;

	public BatchController() {
		super();
	}
	
	public BatchController(TrainerService trainerService, BatchService batchService) {
		super();
		this.trainerService = trainerService;
		this.batchService = batchService;
	}

	/**
	 * A method to get all batches using BatchService.
	 * 
	 * @return a list of all batches, Http status 200 otherwise Http status 204
	 */
	@GetMapping("all")
	public List<Batch> getBatchAll() {
		List<Batch> result = batchService.getBatchAll();

		if (result == null || result.isEmpty()) {
			throw new NoBatchException("No batches exist");
		}
		return result;
	}

	/**
	 * A method to get all past batches for the trainer using BatchService.
	 * 
	 * @param request
	 *            Http request hold the trainer email as parameter.
	 * @return a list of all past batches for the trainer, Http status 200 otherwise
	 *         Http status 204
	 */
	@GetMapping("past/{email}/")
	public List<Batch> getPastBatches(@PathVariable String email) {
		List<Batch> batches = batchService.getBatchByTrainerID(trainerService.getTrainerByEmail(email));
		if (batches == null) {
			throw new NoBatchException("No past batches exist");
		}
		
		Timestamp t = new Timestamp(System.currentTimeMillis());
		batches.removeIf(b -> t.before(b.getEndDate()));
		if (batches.isEmpty()) {
			throw new NoBatchException("no past batches");
		}
		return batches;
	}

	/**
	 * A method to get all future batches for the trainer using BatchService.
	 * 
	 * @param request
	 *            Http request hold the trainer email as parameter.
	 * @return a list of all future batches for the trainer, Http status 200
	 *         otherwise Http status 204
	 */
	@GetMapping("future/{email}/")
	public List<Batch> getFutureBatches(@PathVariable String email) {
//		System.out.println("future/" + email);
		List<Batch> batches = batchService.getBatchByTrainerID(trainerService.getTrainerByEmail(email));
		if (batches == null) {
			throw new NoBatchException("No future batches");
		}

		Timestamp t = new Timestamp(System.currentTimeMillis());
		batches.removeIf(b -> t.after(b.getStartDate()));
		if (batches.isEmpty()) {
			throw new NoBatchException("no future batches");
		}
		return batches;
	}

	/**
	 * A method to get all in-progress batches for the trainer using BatchService.
	 * 
	 * @param request
	 *            Http request hold the trainer email as parameter.
	 * @return a list of all in-progress batches for the trainer, Http status 200
	 *         otherwise Http status 204
	 */
	@GetMapping("inprogress/{email}/")
	public Batch getBatchInProgress(@PathVariable String email ) {
//		System.out.println("inprogress/" + email);
		List<Batch> batches = batchService.getBatchByTrainerID(trainerService.getTrainerByEmail(email));
		if (batches == null) {
			throw new NoBatchException("no bathces in progress");
		}
		
		Batch batchInProgress = null;
		Timestamp t = new Timestamp(System.currentTimeMillis());
		for (Batch b : batches) {
			if (t.after(b.getStartDate()) && t.before(b.getEndDate())) {
				batchInProgress = b;
				break;
			}
		}
		if (batchInProgress == null) {
			throw new NoBatchException("no batches in progress");
		}
		return batchInProgress;
	}

	/**
	 * A method to get all in-progress for the trainer batches using BatchService.
	 * 
	 * @param request
	 *            Http request hold the trainer email as parameter.
	 * @return a list of all in-progress batches for the trainer, Http status 200
	 *         otherwise Http status 204
	 */
	@GetMapping("allinprogress/{email}/")
	public List<Batch> getAllBatchesInProgress(@PathVariable String email) {
//		System.out.println("allinprogress/" + email);
		List<Batch> batches = batchService.getBatchByTrainerID(trainerService.getTrainerByEmail(email));
		if (batches == null) {
			throw new NoBatchException("no batches in progress");
		}
		
		Timestamp t = new Timestamp(System.currentTimeMillis());
		batches.removeIf(b -> t.before(b.getStartDate()) || t.after(b.getEndDate()));
		if (batches.isEmpty()) {
			throw new NoBatchException("no batches in progress");
		}
		return batches;
	}

	/**
	 * A method to get batch by batch id using BatchService.
	 * 
	 * @param request
	 *            Http request hold the batch id as parameter.
	 * @return a batch , Http status 200 otherwise Http status 204.
	 */
	@GetMapping("byid/{batchId}")
	public Batch getBatchById(@PathVariable int batchId) {
		Batch result = batchService.getBatchById(batchId);
		if (result == null) {
			throw new NoBatchException("no batches in progress");
		}
		return result;
	}

	/**
	 * A method to update batch using BatchService.
	 * 
	 * @param batch
	 *            to be update.
	 * @return batch and Http status 202 otherwise Http status 400
	 */
	@PostMapping("updatebatch")
	public Batch updateBatch(@RequestBody Batch batch) {
		// System.out.println(batch);
		
		Batch result = batchService.addOrUpdateBatch(batch);
		if (result == null) {
			throw new BatchUpdateException("Error processing the update batch");
		}
		return result;

	}

	/**
	 * A method to get all batch types using BatchService.
	 * 
	 * @return a list of batch types, Http status 200 otherwise Http status 204
	 */
	@GetMapping("batchtypes")
	public List<BatchType> getAllBatchTypes() {
		List<BatchType> result = batchService.getAllBatchTypes();
		if (result == null || result.isEmpty()) {
			throw new NoBatchException("no batch types");
		}
		return result;
	}

	/**
	 * Method to get all currently active batches
	 * 
	 * @author Francisco Palomino | Batch: 1712-dec10-java-steve
	 * @return a list of batches, Http status 200 otherwise Http status 204
	 */
	@GetMapping("currentbatches")
	public List<Batch> getAllInProgress() {
		List<Batch> batchesInProgress = batchService.currentBatches();
		if (batchesInProgress == null || batchesInProgress.isEmpty()) {
			throw new NoBatchException("no batches in progress");
		}
		return batchesInProgress;
	}
}
