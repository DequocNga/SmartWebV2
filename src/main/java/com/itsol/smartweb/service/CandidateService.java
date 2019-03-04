/*
*This is my code.

*@author Admin
*@date Feb 28, 2019
*@version 

*/

package com.itsol.smartweb.service;

import java.util.ArrayList;
import java.util.Map;

import org.springframework.http.ResponseEntity;

import com.itsol.smartweb.model.*;

import com.itsol.smartweb.exception.*;

public interface CandidateService {
	ArrayList<TblCandidate> getAllCandidate();
	
	ResponseEntity<TblCandidate> getCandidateById(int id) throws ResourceNotFoundException;

	ResponseEntity<TblCandidate> getUpdateCandidateById(int id, TblCandidate candidate) throws ResourceNotFoundException;

	TblCandidate saveCandidate(TblCandidate candidate);

	Map<String, Boolean> deleteCandidateById(int id) throws ResourceNotFoundException, Exception;
}
