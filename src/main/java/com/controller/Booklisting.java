package com.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.entities.*;

@Controller
public class Booklisting {

	@GetMapping("/Addbook")
	public ModelAndView doAdd(HttpServletRequest request, HttpServletResponse response) throws InterruptedException, IOException{
		ModelAndView mv = new ModelAndView();
		mv.setViewName("addbook");
		return mv;
	}
	@GetMapping("/editbook")
	public ModelAndView doedit(HttpServletRequest request, HttpServletResponse response, Model model, @RequestParam("bookcode") int bookcode) throws InterruptedException, IOException{
		ModelAndView mv = new ModelAndView();
		mv.setViewName("Editbookdetails");
		//mv.addObject("bookcode",bookcode);
		
		return mv;
	}


	
}
