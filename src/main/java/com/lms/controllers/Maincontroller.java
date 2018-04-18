package com.lms.controllers;
//import com.lms.models.*;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
//import java.util.Collection;
//mport org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.servlet.ModelAndView;
//import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestParam;

import com.lms.models.Book;
import com.lms.services.LmsService;

//import com.lms.services.LmsService;

@Controller
public class Maincontroller {

	
	@Autowired
	private LmsService lmsservice;
	
	@GetMapping("/")
	public String init(HttpServletRequest req) {
		req.setAttribute("books", lmsservice.getallbooks());
		req.setAttribute("mode", "BOOK_VIEW");
		return "index";
	}
	
	@GetMapping("/updaterecord")
	public String update(@RequestParam long id, HttpServletRequest req) {
		req.setAttribute("book", lmsservice.find(id));
		req.setAttribute("mode", "BOOK_EDIT");
		return "index";
	}
	
	@PutMapping("/save")
	public String save(@ModelAttribute Book book,HttpServletRequest req) {
		lmsservice.save(book);
		book = null;
		req.setAttribute("books", lmsservice.getallbooks());
		req.setAttribute("mode", "BOOK_VIEW");
		return "index";
		
	}
	
}
