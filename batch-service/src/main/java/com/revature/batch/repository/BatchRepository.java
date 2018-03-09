package com.revature.batch.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.batch.bean.Batch;

import java.util.List;

@Repository
public interface BatchRepository extends JpaRepository<Batch, Integer> {
	public Batch findById(Integer id);
	public List<Batch> findAll();
}