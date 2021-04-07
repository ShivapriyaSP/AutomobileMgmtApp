package com.mindtree.AutomobileManagement.Service.ServiceImpl;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.mindtree.AutomobileManagement.Dto.ModelDto;
import com.mindtree.AutomobileManagement.Entity.Company;
import com.mindtree.AutomobileManagement.Entity.Model;
import com.mindtree.AutomobileManagement.Exception.InvalidCompanyName;
import com.mindtree.AutomobileManagement.Exception.ServiceException;
import com.mindtree.AutomobileManagement.Repository.CompanyRepository;
import com.mindtree.AutomobileManagement.Repository.ModelRepository;
import com.mindtree.AutomobileManagement.Service.ModelService;

@Service
public class ModelServiceImpl implements ModelService{

	@Autowired
	private CompanyRepository companyrepository;
	@Autowired
	private ModelRepository modelrepository;
	
	static ModelMapper mapper = new ModelMapper();
	@Override
	public ModelDto addModel(ModelDto modelD, String companyName) throws ServiceException {
		Model model = mapper.map(modelD, Model.class);
		try {
			Company company = companyrepository.findByName(companyName).orElseThrow(()->new InvalidCompanyName("No company by that name exists"));
			model.setCompany(company);
			model = modelrepository.save(model);
			List<Model> models = company.getModels();
			models.add(model);
		}
		catch(DataAccessException|InvalidCompanyName ex)
		{
			throw new ServiceException(ex.getMessage());
		}
		ModelDto modeldto = mapper.map(model, ModelDto.class);
		return modeldto;
	}
}
