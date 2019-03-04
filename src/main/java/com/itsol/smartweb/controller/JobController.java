/*
*This is my code.

*@author Admin
*@date Feb 28, 2019
*@version 

*/

package com.itsol.smartweb.controller;



import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.itsol.smartweb.exception.ResourceNotFoundException;
import com.itsol.smartweb.model.TblJob;
import com.itsol.smartweb.repository.JobRepository;
import com.itsol.smartweb.service.JobService;
@RestController
@RequestMapping("/api/v1")
public class JobController implements JobService{
	
	@Autowired
	public JobRepository jobRepository;
	
	@Override
	@GetMapping("/job")
	public ArrayList<TblJob> getAllJob() {
		return (ArrayList<TblJob>) jobRepository.findAll();
		
	}

	@Override
	@GetMapping("/job/{id}")
	public ResponseEntity<TblJob> getJobById(@PathVariable(value = "id") int id) throws ResourceNotFoundException{
		//Lambda function
		TblJob job = jobRepository.findById(id).
				orElseThrow(() -> new ResourceNotFoundException("Can't found id " + id) );
		return ResponseEntity.ok().body(job);
	}

	@Override
	@PutMapping("/job/{id}")
	public ResponseEntity<TblJob> getUpdateJobById(@PathVariable(value = "id") int id,
			@Valid @RequestBody TblJob jobDetail) throws ResourceNotFoundException{
		// Find Job that you want to change by id
		TblJob job = jobRepository.findById(id).
				orElseThrow(() -> new ResourceNotFoundException("Can't found id " + id) );
		job.setJobAvatar(jobDetail.getJobAvatar());
		job.setJobCity(jobDetail.getJobCity());
		job.setJobNote(jobDetail.getJobNote());
		job.setJobSalary(jobDetail.getJobSalary());
		job.setTblCandidates(jobDetail.getTblCandidates());
		job.setJobTitle(jobDetail.getJobTitle());
		
		//Change old job = new job(jobNew)
		TblJob jobNew = jobRepository.save(job);
		return ResponseEntity.ok(jobNew);
	}

	@Override
	@PostMapping(value="/job")
	public TblJob saveJob(@Valid @RequestBody TblJob jobAdd) {
		return jobRepository.save(jobAdd);
	}

	@Override
	@DeleteMapping("/job/{id}")
	public Map<String, Boolean> deleteJobById(@PathVariable(value = "id") int id) throws ResourceNotFoundException{
		// TODO Auto-generated method stub
		TblJob job = jobRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Not found id: " + id));
		jobRepository.delete(job);
		Map<String, Boolean> response = new HashMap<>();
		response.put("delete", Boolean.TRUE);
		return response;
	}

	@Override
	@GetMapping("/job/cityname/{city}")
	public ArrayList<TblJob> findJobByCity(@PathVariable(value = "city") String city) {
		// TODO Auto-generated method stub
		return (ArrayList<TblJob>) jobRepository.findByCity(city);
	}

		

}
