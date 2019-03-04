/*
*This is my code.

*@author Admin
*@date Feb 28, 2019
*@version 

*/

package com.itsol.smartweb.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.itsol.smartweb.model.TblCandidate;

public interface CandidateReponsitory extends JpaRepository<TblCandidate, Integer>{

}
