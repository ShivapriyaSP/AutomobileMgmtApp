package com.mindtree.AutomobileManagement.Service;

import com.mindtree.AutomobileManagement.Dto.ModelDto;
import com.mindtree.AutomobileManagement.Exception.ServiceException;

public interface ModelService {

	ModelDto addModel(ModelDto modelD,String companyName) throws ServiceException;

}
