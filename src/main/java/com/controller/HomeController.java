package com.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


@Controller
@RestController
public class HomeController {
	
	@Bean
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}
	@Autowired
	private RestTemplate restTemplate;
	
	static final String bookManagement_url = "http://localhost:8085/";
	
	@GetMapping("/all")
	public String fetchAllBooks() {
		String books = restTemplate.exchange(bookManagement_url+"books",HttpMethod.GET,null,String.class).getBody();
		return books;
	}
	
	   @GetMapping("/booklisting")
	    public String myPage(Model model) {
		   
		   String url = "http://localhost:8085/";
		   String data = restTemplate.exchange(url+"books",HttpMethod.GET,null,String.class).getBody();
	        model.addAttribute("data", data);
	        System.out.println(data);
	        return "booklisting";
	    }

}
