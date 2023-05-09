package com.controller;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;

import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;


import com.dao.LoginDao;
import com.entities.*;
import java.util.List;
@Controller

public class LoginController {
	
	@Autowired
	LoginDao logindao;
	
	@Autowired
	RestTemplate restTemplate;
	
	
	
	
	
	@PostMapping("/Insertbook")
	public String addbooktospringboot(HttpServletRequest request,HttpServletResponse response,Model model,
			@RequestParam("bookcode") int bookcode,
			@RequestParam("bookname") String bookname,
			@RequestParam("author") String author,
			@RequestParam("date") String date) {
	
		String url = "http://localhost:8085/";
		Book book = new Book(bookcode,bookname,author,date);
		
		
		 restTemplate.postForObject(url + "books", book, String.class);
		return "sucess";
		
	}
	
	
	
	@PostMapping("/editbookbycode")
	public String editbooktospringboot(HttpServletRequest request,HttpServletResponse response,Model model,
			 @RequestParam("bookcode") int bookcode,
			@RequestParam("bookname") String bookname,
			@RequestParam("author") String author,
			@RequestParam("date") String date) {
	
		String url = "http://localhost:8085/books/";
		Book book = new Book(bookcode,bookname,author,date);
		
		
			 restTemplate.put(url +bookcode,book, String.class);
		return "sucess";
		
	}
	@GetMapping("/deletebook")
	public ModelAndView deletebook(HttpServletRequest request, HttpServletResponse response, Model model,@RequestParam("bookcode") int bookcode) {
		ModelAndView mv = new ModelAndView();
		
		String url = "http://localhost:8085/";
		mv.setViewName("delete");
		System.out.println(bookcode);
		 restTemplate.delete(url + "books/"+ bookcode, String.class);
		return mv;
		
	}
	
	
	
	
	
	
	@PostMapping("/Login")
	public ModelAndView checkUser(HttpServletRequest request,HttpServletResponse response,Model model) throws JsonMappingException, JsonProcessingException {
		
		ModelAndView mv=new ModelAndView();
		
		String uname=request.getParameter("username");
		String pass=request.getParameter("password");
		
		

		if(logindao.checkUser(uname,pass)) {
			HttpSession session =request.getSession();
			session.setAttribute("username", uname);
			
			String url = "http://localhost:8085/";
			
			String booksList = restTemplate.exchange(url + "books", HttpMethod.GET, null, String.class).getBody();
			ObjectMapper objectMapper = new ObjectMapper();
			List<Book> bookList = objectMapper.readValue(booksList, new TypeReference<List<Book>>() {
			});

			model.addAttribute("booksList", bookList);
			mv.addObject("bookList",bookList);
			mv.setViewName("booklisting");
			System.out.println();
			/*
		     restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
			
			

			
			
			
			List<Book> books = restTemplate.exchange(url+"books", HttpMethod.GET, null, new ParameterizedTypeReference<List<Book>>(){}).getBody();
			
			model.addAttribute("books", books);

			mv.addObject("books",books);
			
			*/
	        
	        //String data = restTemplate.exchange(url+"books", HttpMethod.GET, null, String.class).getBody();
	       // model.addAttribute("data", data);
	        System.out.println(bookList);
	        for (Object obj : bookList) {
	            if (obj instanceof String) {
	                System.out.println("String value: " + obj);
	            } else if (obj instanceof Integer) {
	                System.out.println("Integer value: " + obj);
	            }
	        }
	        System.out.println(mv);
	        mv.setViewName("booklisting");
		}
		else {
			mv.setViewName("Login");
		}
		return mv;
		
	}

}
