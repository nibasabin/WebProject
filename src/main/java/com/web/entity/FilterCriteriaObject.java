package com.web.entity;

import java.io.Serializable;
import java.util.ArrayList;

import javax.xml.bind.annotation.XmlRootElement;
@XmlRootElement
public class FilterCriteriaObject implements Serializable{

	private static final long serialVersionUID = 2122952745937535497L;
	private String category; 
	private ArrayList<String> subCategoryList;
	private Float minAmount;
	private Float maxAmount;
	private Boolean newItem;
	private Boolean usedItem;
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public ArrayList<String> getSubCategoryList() {
		return subCategoryList;
	}
	public void setSubCategoryList(ArrayList<String> subCategoryList) {
		this.subCategoryList = subCategoryList;
	}
	public Float getMinAmount() {
		return minAmount;
	}
	public void setMinAmount(Float minAmount) {
		this.minAmount = minAmount;
	}
	public Float getMaxAmount() {
		return maxAmount;
	}
	public void setMaxAmount(Float maxAmount) {
		this.maxAmount = maxAmount;
	}
	public Boolean getNewItem() {
		return newItem;
	}
	public void setNewItem(Boolean newItem) {
		this.newItem = newItem;
	}
	public Boolean getUsedItem() {
		return usedItem;
	}
	public void setUsedItem(Boolean usedItem) {
		this.usedItem = usedItem;
	}

	
}
