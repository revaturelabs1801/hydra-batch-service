package com.revature.batch.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.revature.batch.bean.Batch;
import com.revature.batch.bean.BatchType;

public interface BatchTypeRepository extends JpaRepository<BatchType, Integer>{
	
	public List<BatchType> findAll();

}
