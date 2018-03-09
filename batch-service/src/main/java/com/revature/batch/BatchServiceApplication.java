package com.revature.batch;

import java.sql.Timestamp;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.revature.batch.bean.Batch;
import com.revature.batch.controller.BatchController;
import com.revature.batch.service.BatchService;

@SpringBootApplication
public class BatchServiceApplication {
	
	@Autowired
	BatchController bc;
	
	@Autowired
	static
	BatchService bs;

	public static void main(String[] args) {
		SpringApplication.run(BatchServiceApplication.class, args);
		bs.addOrUpdateBatch(new Batch("1801C", new Timestamp(1000), new Timestamp(1000), new ArrayList<Integer>(), 0, "c", 1000));
	}
}
