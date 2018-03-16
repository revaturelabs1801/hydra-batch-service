package com.revature.batch.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.batch.bean.BamUser;
import com.revature.batch.bean.Batch;

import java.sql.Timestamp;
import java.util.List;

@Repository
public interface BatchRepository extends JpaRepository<Batch, Integer> {
//	public Batch findOne(Integer id); //	public Batch findById(Integer id);
//	public List<Batch> findAll();
	public List<Batch> findByTrainerID(int trainerID);
	public List<Batch> findByEndDateGreaterThanAndStartDateLessThan(Timestamp end, Timestamp start);

}