package com.mindtree.AutomobileManagement.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.mindtree.AutomobileManagement.Entity.Company;

public interface CompanyRepository extends JpaRepository<Company,Integer>{

	@Query("select c from Company c where c.companyName = ?1")
	Optional<Company> findByName(String companyName);
}
