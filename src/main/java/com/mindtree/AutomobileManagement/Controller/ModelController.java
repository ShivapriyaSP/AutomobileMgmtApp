package com.mindtree.AutomobileManagement.Controller;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mindtree.AutomobileManagement.Dto.ModelDto;
import com.mindtree.AutomobileManagement.Exception.ControllerException;
import com.mindtree.AutomobileManagement.Exception.ServiceException;
import com.mindtree.AutomobileManagement.Service.ModelService;

@RestController
@RequestMapping("/model")
public class ModelController {

	@Autowired
	private ModelService modelservice;
	
	@PostMapping("/addModel/{companyName}")
	public ResponseEntity<?> addModel(@RequestBody ModelDto modelD, @PathVariable @NotBlank(message="mention company name") String companyName) throws ControllerException
	{
		ModelDto modeldto = null;
		try
		{
			modeldto = modelservice.addModel(modelD,companyName);
		}
		catch(ServiceException ex)
		{
			throw new ControllerException(ex.getMessage());
		}
		return new ResponseEntity<ModelDto>(modeldto,HttpStatus.ACCEPTED);
	}
}
