package com.revature.batch.service;

import java.util.Hashtable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.revature.batch.bean.BamUser;


@Service
public class TrainerService {
	
	@LoadBalanced
	@Bean
	public RestTemplate buildRestTemplate(RestTemplateBuilder restTemplateBuilder){
		return restTemplateBuilder.build();
	} 
	
	@Autowired
	private RestTemplate restTemplate;
	
	// no args constructor
	public TrainerService() {
		super();
	}
	
	// constructor
	public TrainerService(RestTemplate restTemplate) {
		super();
		this.restTemplate = restTemplate;
	}

	@HystrixCommand(fallbackMethod="cachedGetTrainerByEmail")
	public Integer getTrainerByEmail(String email) {
		System.out.println("trainer by email: " + email);
		// bamUserService.findUserByEmail(request.getParameter(EMAIL);
		BamUser returner = restTemplate.getForObject("http://hydra-user-service/byEmail/" + email + "/", BamUser.class);
		System.out.println("trainer from user service: " + returner);
		if(returner == null)
			return null;
		cache.put(email, returner.getUserId());
		//System.out.println(returner);
		return returner.getUserId();
	}
	
	
	Hashtable<String, Integer> cache = new Hashtable<String, Integer> ();
	
	public Integer cachedGetTrainerByEmail(String email) {
		// TODO add logging here
		System.out.println("User-service-fallback");
		return cache.get(email);
	}

	// testing hook to populate cache
	public void testingAddToCache(String email, Integer trainerID) {
		cache.put(email, trainerID);
	}
}
