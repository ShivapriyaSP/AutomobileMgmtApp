package com.mindtree.AutomobileManagement.Dto;

import lombok.Data;

@Data
public class ModelDto {

	private int modelId;
	private String modelName;
	private int price;
	private String colour;
	public ModelDto() {
		super();
	}
	public ModelDto(int modelId, String modelName, int price, String colour) {
		super();
		this.modelId = modelId;
		this.modelName = modelName;
		this.price = price;
		this.colour = colour;
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
	
	
}
