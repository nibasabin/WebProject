package com.web.entity;

import java.io.Serializable;
import java.util.ArrayList;

import javax.xml.bind.annotation.XmlRootElement;
@XmlRootElement
public class FilterCriteriaObject implements Serializable{

	private static final long serialVersionUID = 2122952745937535497L;
	private String category; 
	private ArrayList<String> subCategoryList;
	private Double minAmount;
	private Double maxAmount;
	private Boolean newItem;
	private Boolean usedItem;
	private Boolean itemCondition;
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
	public Double getMinAmount() {
		return minAmount;
	}
	public void setMinAmount(Double minAmount) {
		this.minAmount = minAmount;
	}
	public Double getMaxAmount() {
		return maxAmount;
	}
	public void setMaxAmount(Double maxAmount) {
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
	public Boolean getItemCondition() {
		return itemCondition;
	}
	public void setItemCondition(Boolean itemCondition) {
		this.itemCondition = itemCondition;
	}

	
}
