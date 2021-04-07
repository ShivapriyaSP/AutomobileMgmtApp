package com.mindtree.AutomobileManagement.Controller;


import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mindtree.AutomobileManagement.Dto.CompanyDto;
import com.mindtree.AutomobileManagement.Entity.Company;
import com.mindtree.AutomobileManagement.Exception.ControllerException;
import com.mindtree.AutomobileManagement.Exception.ServiceException;
import com.mindtree.AutomobileManagement.Service.CompanyService;

@RestController
@RequestMapping("/company")
public class CompanyController {

	@Autowired
	private CompanyService companyservice;
	
	@PostMapping(path="/addCompany",consumes={MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE}, produces= {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<?> addCompany(@RequestBody @Valid CompanyDto companyD) throws ControllerException
	{
		CompanyDto companyDto = null;
		try
		{
			companyDto = companyservice.addCompany(companyD);
		}
		catch(ServiceException ex)
		{
			throw new ControllerException(ex.getMessage());
		} 
		return new ResponseEntity<CompanyDto>(companyDto,HttpStatus.ACCEPTED);
	}
	
	@GetMapping(path="/getAllCompanies", produces= {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<?> getAllCompanies() throws ControllerException
	{
		List<CompanyDto> companiesdto = new ArrayList<>();
		try
		{
			companiesdto = companyservice.getAllCompanies();
		}
		catch(ServiceException ex)
		{
			throw new ControllerException(ex.getMessage());
		}
		return new ResponseEntity<>(companiesdto,HttpStatus.ACCEPTED);
	}
	
//	@RequestMapping("/getCompaniesBasedOnColour/{colour}")
//	public ResponseEntity<?> getCompaniesBasedOnColour(@PathVariable String colour) throws ControllerException
//	{
//		List<CompanyDto> companiesdto = new ArrayList<>();
//		try
//		{
//			companiesdto = companyservice.getCompaniesByColour(colour);
//		}
//		catch(ServiceException ex)
//		{
//			throw new ControllerException(ex.getMessage());
//		}
//		return new ResponseEntity<>(companiesdto,HttpStatus.ACCEPTED);
//	}
	
	@RequestMapping("/getCompanyByColour/{compName}/{colour}")
	public ResponseEntity<?> getCompanyByColour(@PathVariable String compName, @PathVariable String colour) throws ControllerException
	{
		CompanyDto companydto = null;
		try
		{
			companydto = companyservice.getCompanyByColour(compName,colour);
		}
		catch(ServiceException ex)
		{
			throw new ControllerException(ex.getMessage());
		}
		return new ResponseEntity<>(companydto, HttpStatus.ACCEPTED);
	}
	
	@RequestMapping("/getAvgPriceByCompanyName/{compName}")
	public ResponseEntity<?> getAvgPrice(@PathVariable String compName) throws ControllerException
	{
		int price = 0;
		try
		{
			price = companyservice.getAvgPrice(compName);
		}
		catch(ServiceException ex)
		{
			throw new ControllerException(ex.getMessage());
		}
		return new ResponseEntity<>(price,HttpStatus.ACCEPTED);
	}
}

