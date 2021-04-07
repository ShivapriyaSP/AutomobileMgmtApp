package com.mindtree.AutomobileManagement.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Model {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int modelId;
	private String modelName;
	private int price;
	private String colour;
	
	@ManyToOne
	@JsonIgnore
	private Company company;

	public Model() {
		super();
	}

	public Model(int modelId, String modelName, int price, String colour, Company company) {
		super();
		this.modelId = modelId;
		this.modelName = modelName;
		this.price = price;
		this.colour = colour;
		this.company = company;
	}

	public int getModelId() {
		return modelId;
	}

	public String getModelName() {
		return modelName;
	}

	public int getPrice() {
		return price;
	}

	public String getColour() {
		return colour;
	}

	public Company getCompany() {
		return company;
	}

	public void setModelId(int modelId) {
		this.modelId = modelId;
	}

	public void setModelName(String modelName) {
		this.modelName = modelName;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public void setColour(String colour) {
		this.colour = colour;
	}

	public void setCompany(Company company) {
		this.company = company;
	}
	
	
}
