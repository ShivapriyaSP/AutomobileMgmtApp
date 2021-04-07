package com.mindtree.AutomobileManagement.Dto;

import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.mindtree.AutomobileManagement.Entity.Model;

import lombok.Data;

@Data
public class CompanyDto {

	@NotNull(message="id should not be null")
	private int companyId;
	@NotBlank(message="company name should not be blank")
	private String companyName;
	
	List<Model> models;

	public CompanyDto() {
		super();
	}

	public CompanyDto(int companyId, String companyName, List<Model> models) {
		super();
		this.companyId = companyId;
		this.companyName = companyName;
		this.models = models;
	}

	public int getCompanyId() {
		return companyId;
	}

	public String getCompanyName() {
		return companyName;
	}

	public List<Model> getModels() {
		return models;
	}

	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public void setModels(List<Model> models) {
		this.models = models;
	}
	
	
}
