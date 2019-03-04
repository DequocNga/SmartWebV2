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


public interface JobService {
	ArrayList<TblJob> getAllJob();
	
	ResponseEntity<TblJob> getJobById(int id) throws ResourceNotFoundException;

	ResponseEntity<TblJob> getUpdateJobById(int id, TblJob job) throws ResourceNotFoundException;

	TblJob saveJob(TblJob job);

	Map<String, Boolean> deleteJobById(int id) throws ResourceNotFoundException;
	
	ArrayList<TblJob> findJobByCity(String city) ;
}
