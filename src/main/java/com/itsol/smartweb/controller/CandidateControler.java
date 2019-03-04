/*
*This is my code.

*@author Admin
*@date Feb 28, 2019
*@version 

*/

package com.itsol.smartweb.controller;

import java.util.ArrayList;
import java.util.HashMap;
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
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;

import com.itsol.smartweb.exception.ResourceNotFoundException;
import com.itsol.smartweb.model.TblCandidate;
import com.itsol.smartweb.model.TblJob;
import com.itsol.smartweb.repository.CandidateReponsitory;
import com.itsol.smartweb.service.CandidateService;

@RestController
@RequestMapping("/api/v1")
public class CandidateControler implements CandidateService {

	@Autowired
	public CandidateReponsitory candidateRepository;

	@Override
	@GetMapping("/candidate")
	public ArrayList<TblCandidate> getAllCandidate() {
		// TODO Auto-generated method stub

		return (ArrayList<TblCandidate>) candidateRepository.findAll();
	}

	@Override
	@GetMapping("/candidate/{id}")
	public ResponseEntity<TblCandidate> getCandidateById(@PathVariable(value = "id") int id)
			throws ResourceNotFoundException {
		// TODO Auto-generated method stub
		// Lambda function
		TblCandidate candidate = candidateRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Can't found id " + id));
		return ResponseEntity.ok().body(candidate);
	}

	@Override
	@PutMapping("/candidate/{id}")
	public ResponseEntity<TblCandidate> getUpdateCandidateById(@PathVariable(value = "id") int id,
			@Valid @RequestBody TblCandidate candidateDetail) throws ResourceNotFoundException {
		// Find Job that you want to change by id
		TblCandidate candidate = candidateRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Can't found id " + id));
		candidate.setCandidateBirth(candidateDetail.getCandidateBirth());
		candidate.setCandidateCvfile(candidateDetail.getCandidateCvfile());
		candidate.setCandidateEmail(candidateDetail.getCandidateEmail());
		candidate.setCandidateFirstname(candidateDetail.getCandidateFirstname());
		candidate.setCandidatelLastname(candidateDetail.getCandidatelLastname());
		candidate.setCandidateMobile(candidateDetail.getCandidateMobile());
		
		candidate.setCandidateContent(candidateDetail.getCandidateContent());
		candidate.setTblJob(candidateDetail.getTblJob());
		candidate.setTblUser(candidateDetail.getTblUser());

		// Change old job = new job(jobNew)
		TblCandidate candidateNew = candidateRepository.save(candidate);
		return ResponseEntity.ok(candidateNew);
	}

	@Override
	@PostMapping("/candidate")
	public TblCandidate saveCandidate(@Valid @RequestBody TblCandidate candidateNew) {
		// TODO Auto-generated method stub
		return candidateRepository.save(candidateNew);
	}

	@Override
	@DeleteMapping("/candidate/{id}")
	public Map<String, Boolean> deleteCandidateById(@PathVariable(value = "id") int id)
			throws ResourceNotFoundException {
		TblCandidate candidate = candidateRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Can't found id " + id));
		candidateRepository.delete(candidate);
		Map<String, Boolean> response = new HashMap<>();
		response.put("delete", Boolean.TRUE);
		return response;
	}

}
