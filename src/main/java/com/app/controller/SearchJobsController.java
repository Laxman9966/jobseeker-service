package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.app.model.SearchJobs;
import com.app.repository.SearchJobsRepository;

@RestController
@RequestMapping("searchjobs")
public class SearchJobsController {
	
	@Autowired
	SearchJobsRepository repository;

	@RequestMapping(value = "/getAlljobs", method = RequestMethod.GET)
	public List<SearchJobs> getAlljobs() {
		return repository.findAll();
	}
	
	@RequestMapping(value = "/getJobDetails/{id}", method = RequestMethod.GET)
	public SearchJobs getjobdetails(@PathVariable("id") Long id) {
		return repository.findById(id).get();
	}
	
	
}
