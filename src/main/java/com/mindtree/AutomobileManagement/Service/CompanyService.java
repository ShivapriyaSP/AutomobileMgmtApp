package com.mindtree.AutomobileManagement.Service;

import java.util.List;

import com.mindtree.AutomobileManagement.Dto.CompanyDto;
import com.mindtree.AutomobileManagement.Exception.ServiceException;

public interface CompanyService {

	CompanyDto addCompany(CompanyDto companyD) throws ServiceException;

	List<CompanyDto> getAllCompanies() throws ServiceException;

	CompanyDto getCompanyByColour(String compName, String colour) throws ServiceException;

	int getAvgPrice(String compName) throws ServiceException;

	//List<CompanyDto> getCompaniesByColour(String colour);

	

}
