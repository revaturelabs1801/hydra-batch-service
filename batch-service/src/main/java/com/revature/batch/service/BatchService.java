package com.revature.batch.service;

import java.sql.Timestamp;
import java.util.List;

//import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.batch.bean.Batch;
import com.revature.batch.bean.BatchType;
import com.revature.batch.repository.BatchRepository;
import com.revature.batch.repository.BatchTypeRepository;


@Service
public class BatchService {
	@Autowired
	BatchRepository batchRepository;

	@Autowired
	BatchTypeRepository batchTypeRepository;
		
	public Batch addOrUpdateBatch(Batch b) {
		if (b != null && b.getType() != null && b.getType().getId() != null) {
			if(batchTypeRepository.exists(b.getType().getId())) {
				b.setType(batchTypeRepository.findOne(b.getType().getId()));
			}
			else {
				b.getType().setId(null);
			}
		}	
		return batchRepository.save(b);
	}

	public Batch getBatchById(Integer id) {
//		LogManager.getLogger(BatchService.class).fatal(batchRepository);
		return batchRepository.findOne(id);
	}

	public List<Batch> getBatchAll() {
		return batchRepository.findAll();
	}

	public List<Batch> getBatchByTrainerID(Integer trainerID) {
		return trainerID == null ? null : batchRepository.findByTrainerID(trainerID);
	}
	
	public List<BatchType> getAllBatchTypes() {
		return batchTypeRepository.findAll();
	}
	
	/**
	 * Method to get all currently active batches
	 * @author Francisco Palomino | Batch: 1712-dec10-java-steve
	 * @return a list of batches, Http status 200 otherwise Http status 204
	 */
	public List<Batch> currentBatches() {
		Timestamp t = new Timestamp(System.currentTimeMillis());
		return batchRepository.findByEndDateGreaterThanAndStartDateLessThan(t, t);
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
//	public void addCurriculumSubtopicsToBatch(List<CurriculumSubtopic> currSubtopics, Batch batch){
//		Calendar cal = Calendar.getInstance();
//		
//		for(CurriculumSubtopic cSTopic: currSubtopics){
//			Subtopic sub = new Subtopic();
//			
//			//set name and batch using given information
//			sub.setBatch(batch);
//			sub.setSubtopicName((subtopicNameRepository.findById(cSTopic.getCurriculumSubtopicNameId().getId())));
//			sub.setStatus(subtopicService.getStatus("Pending"));
//			
//			//Get the absolute day of batch that the subtopic should be added to
//			int sDay = cSTopic.getCurriculumSubtopicDay();
//			int sWeek = cSTopic.getCurriculumSubtopicWeek();
//			int absoluteDayOfBatch = (sWeek-1)*7 + sDay - 1;
//			
//			//Set the subtopics date using the batches start date and the 
//			//previously derived absolute day of batch.
//			cal.setTime(batch.getStartDate());
//			cal.add(Calendar.DAY_OF_WEEK, absoluteDayOfBatch);
//			sub.setSubtopicDate(new Timestamp(cal.getTime().getTime()));
//			
//			subtopicRepository.save(sub);
//		}
//	}
}