package com.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.app.model.SearchJobs;
import com.app.model.JobSeekerPrfl;

@Repository
public interface SearchJobsRepository extends JpaRepository<SearchJobs, Long>{
	//public interface StudentRepository extends CrudRepository<Student, Long>{

//	https://www.javatpoint.com/components-of-spring-cloud
//		@Query("SELECT con FROM Contact con  WHERE con.phoneType=(:pType) AND con.lastName= (:lName)")
//List<Contact> findByLastNameAndPhoneType(@Param("pType") PhoneType pType, @Param("lName") String lName);
	
//	@Query("SELECT job FROM jobposting job  WHERE job.id=(:id)")
//    List<SearchJobs> getJobsDetails(@Param("id") Long id);
}
