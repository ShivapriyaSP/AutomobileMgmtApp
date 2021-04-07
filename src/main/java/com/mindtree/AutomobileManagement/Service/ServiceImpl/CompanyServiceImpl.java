package com.mindtree.AutomobileManagement.Service.ServiceImpl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.mindtree.AutomobileManagement.Dto.CompanyDto;
import com.mindtree.AutomobileManagement.Entity.Company;
import com.mindtree.AutomobileManagement.Entity.Model;
import com.mindtree.AutomobileManagement.Exception.InvalidCompanyName;
import com.mindtree.AutomobileManagement.Exception.NoCompaniesPresentException;
import com.mindtree.AutomobileManagement.Exception.ServiceException;
import com.mindtree.AutomobileManagement.Repository.CompanyRepository;
import com.mindtree.AutomobileManagement.Repository.ModelRepository;
import com.mindtree.AutomobileManagement.Service.CompanyService;

@Service
public class CompanyServiceImpl implements CompanyService{

	@Autowired
	private CompanyRepository companyrepository;
	@Autowired
	private ModelRepository modelrepository;
	
	static ModelMapper mapper = new ModelMapper();
	@Override
	public CompanyDto addCompany(CompanyDto companyD) throws ServiceException {
		Company company = mapper.map(companyD, Company.class);
		try {
			company = companyrepository.save(company);
		}
		catch(DataAccessException e)
		{
			throw new ServiceException(e.getMessage());
		}
		CompanyDto compdto = mapper.map(company, CompanyDto.class);
		return compdto;
	}
	@Override
	public List<CompanyDto> getAllCompanies() throws ServiceException {
		List<CompanyDto> companiesdto = new ArrayList<>();
		try
		{
			List<Company> companies = companyrepository.findAll();
			if(companies.size()==0)
				throw new NoCompaniesPresentException("There are no companies in the database");
			Collections.sort(companies,(o1,o2)->{
				return o1.getCompanyName().compareTo(o2.getCompanyName());
				});
			for(Company c : companies)
			{
				CompanyDto cd = new CompanyDto();
				cd = mapper.map(c, CompanyDto.class);
				companiesdto.add(cd);
			}
		}
		catch(DataAccessException|NoCompaniesPresentException ex)
		{
			throw new ServiceException(ex.getMessage());
		}
		return companiesdto;
	}
//	@Override
//	public List<CompanyDto> getCompaniesByColour(String carColour) {
//		List<CompanyDto> companiesdto = new ArrayList<>();
//		List<Company> companies = companyrepository.findAll();
//		companies = companies.stream()
//								.filter(models.stream().filter(colour.equals(carColour))
//										.collect(Collectors.toList()));
//		return null;
//	}
	@Override
	public CompanyDto getCompanyByColour(String compName, String colour) throws ServiceException {
		List<Company> companies = companyrepository.findAll();
		CompanyDto companydto = new CompanyDto();
		try {
		Company comp = companies.stream().filter((c)->{
					boolean validName = false;
					if(c.getCompanyName().equals(compName))
						validName = true;
					List<Model> models = c.getModels();
					boolean validColour = false;
					for(Model m : models)
					{
						if(m.getColour().equals(colour))
						{
							validColour = true;
							break;
						}
					}
					if(validName==true && validColour == true)
						return true;
					else 
						return false;
			}).findAny().orElseThrow(()->new InvalidCompanyName("No company with that name or no company has car of this colour"));
		companydto = mapper.map(comp, CompanyDto.class);
		}
		catch(DataAccessException|InvalidCompanyName ex)
		{
			throw new ServiceException(ex.getMessage());
		}
		return companydto;
	}
	@Override
	public int getAvgPrice(String compName) throws ServiceException {
		int price =0;
		try
		{
		Company c = companyrepository.findByName(compName).orElseThrow(()->new InvalidCompanyName("No company by that name exists"));
		List<Model> models = c.getModels();
		price = (int) models.stream().mapToInt((m)->m.getPrice()).average().orElse(0);
		}
		catch(DataAccessException | InvalidCompanyName ex)
		{
			throw new ServiceException(ex.getMessage());
		}
		return price;
	}
}







