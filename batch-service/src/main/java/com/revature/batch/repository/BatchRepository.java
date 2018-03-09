package com.revature.batch.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.revature.batch.bean.Batch;

import java.util.List;

@Repository
public interface BatchRepository extends CrudRepository<Batch, Integer> {
	public Batch findById(Integer id);
	public List<Batch> findAll();
}