package com.revature.batch;

import java.sql.Timestamp;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

import com.revature.batch.bean.Batch;
import com.revature.batch.bean.BatchType;
import com.revature.batch.controller.BatchController;
import com.revature.batch.service.BatchService;

@SpringBootApplication
public class BatchServiceApplication {
	

	public static void main(String[] args) {
		SpringApplication.run(BatchServiceApplication.class, args);
	}
}
