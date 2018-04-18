package com.lms.services;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
//import java.util.Optional;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;


import com.lms.dao.LmsRepository;
import com.lms.models.Book;

@Service
@Component
public class LmsService {

@Autowired
private LmsRepository lmsRepository;


public Collection<Book> getallbooks(){
	
	
	List<Book> books = new ArrayList<Book>();
	
	for (Book book : lmsRepository.findAll()) {
		books.add(book);
	}
	return books;
	
}

public void deletebook(long id) {
	// TODO Auto-generated method stub
	lmsRepository.deleteById(id);
}



	public Optional<Book> find(long id) {
	
	return lmsRepository.findById(id);
}

public void save(Book book) {
	lmsRepository.save(book);
}

}
