package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.app.model.JobSeekerPrfl;
import com.app.repository.JobSeekerPrflRepository;

@RestController
@RequestMapping("jobseeker")
public class JobSeekerPrflController {
	
	@Autowired
	private JobSeekerPrflRepository repository;
	
	@RequestMapping(value ="getAllProfiles", method=RequestMethod.GET)
	public Iterable<JobSeekerPrfl> getallprofiles() {
		return repository.findAll();
	}	

	@RequestMapping(value ="getProfileDetails/{id}", method=RequestMethod.GET)
	public JobSeekerPrfl getStudent(@PathVariable("id") Long id) {
		return repository.findById(id).get();
	}

	@RequestMapping(value = "/saveJobSeeker", method = RequestMethod.POST)
	public JobSeekerPrfl addStudent(@RequestBody JobSeekerPrfl jobSeekerPrfl) {
		return repository.save(jobSeekerPrfl);
	}

	@RequestMapping(value="/updateProfileStudent/{id}", method = RequestMethod.PUT)
	public JobSeekerPrfl updateStudent(@PathVariable("id") Long id, @RequestBody JobSeekerPrfl jobSeekerPrfl) {
		JobSeekerPrfl profile = repository.findById(id).get();
		if(profile !=null) {
			profile.setName(jobSeekerPrfl.getName());
			profile.setResumeTitle(jobSeekerPrfl.getResumeTitle());
			profile.setExperience(jobSeekerPrfl.getExperience());
			profile.setEmail(jobSeekerPrfl.getEmail());
			profile.setPassword(jobSeekerPrfl.getPassword());
			return repository.save(profile);
		}
		return null;
		
	}

	@DeleteMapping("/{id}")
	public void deleteStudent(@PathVariable("id") Long id) {
		//repository.findById(id).orElseThrow(StudentNotFoundException::new);
		repository.deleteById(id);
	}
}
