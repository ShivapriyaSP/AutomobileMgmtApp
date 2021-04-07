package com.mindtree.AutomobileManagement.Entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Company {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int companyId;
	private String companyName;
	
	@OneToMany(mappedBy="company")
	List<Model> models;

	public Company() {
		super();
	}


	public Company(int companyId, String companyName, List<Model> models) {
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
