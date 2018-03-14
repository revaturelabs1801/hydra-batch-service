package com.revature.batch.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.revature.batch.bean.BamUser;


@Service
public class TrainerService {
	
	@Bean
	public RestTemplate buildRestTemplate(RestTemplateBuilder restTemplateBuilder){
		return restTemplateBuilder.build();
	} 
	
	@Autowired
	private RestTemplate restTemplate;
	
	// TODO implement this method by accessing user service
	public Integer getTrainerByEmail(String email) {
		// bamUserService.findUserByEmail(request.getParameter(EMAIL);
		BamUser returner = restTemplate.getForObject("", BamUser.class);
		if(returner == null)
			return null;
		return returner.getUserId();
	}
	
//	public FlashCard getFc(){
//		System.out.println("hit /getFc2");
//		FlashCard fc = restTemplate.getForObject("http://flashcard-service-2/fc2", FlashCard.class);
//		return fc;
//	}

}
