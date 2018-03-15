package com.revature.batch;

//import java.sql.Timestamp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
//import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

//import com.fasterxml.jackson.core.JsonProcessingException;
//import com.fasterxml.jackson.databind.ObjectMapper;

@EnableCircuitBreaker
//@EnableEurekaClient
@SpringBootApplication
public class BatchServiceApplication {

//	static class MyTime {
//		public Timestamp time;
//
//		public Timestamp getTime() {
//			return time;
//		}
//
//		public void setTime(Timestamp time) {
//			this.time = time;
//		}
//
//		public MyTime() {
//			this.time = new Timestamp(System.currentTimeMillis());
//		}
//
//		public MyTime(Timestamp time) {
//			this.time = time;
//		}
//	}

	public static void main(String[] args) {

//		ObjectMapper mapper = new ObjectMapper();
//		try {
//			String myTime = mapper.writeValueAsString(new MyTime());
//			System.out.println(myTime);
//		} catch (JsonProcessingException e) {
//			e.printStackTrace();
//		}

		SpringApplication.run(BatchServiceApplication.class, args);
	}
}
