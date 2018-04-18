package com.lms.controllers.rest;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lms.models.Book;
import com.lms.services.LmsService;

@RestController
public class MainRestController {

	
	@Autowired
	private LmsService  lmsservice;
	
	
	public void initbinder(WebDataBinder binder) {
		
		binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-mm-dd"), false));
	}
	
	@GetMapping("/findall")
	public Collection<Book> getAllBooks(){
		return lmsservice.getallbooks();
	}
	
	@GetMapping("/delete")
	public void Delete(@RequestParam long id) {
		lmsservice.deletebook(id);
	}
	
	
	
}
