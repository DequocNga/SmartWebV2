/*
*This is my code.

*@author Admin
*@date Feb 28, 2019
*@version 

*/

package com.itsol.smartweb.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.itsol.smartweb.model.TblJob;

public interface JobRepository extends JpaRepository<TblJob, Integer>{
	
	@Query(value = "SELECT * FROM tbl_job WHERE job_city LIKE %?1", nativeQuery=true)
	public List<TblJob> findByCity(String city);

}
