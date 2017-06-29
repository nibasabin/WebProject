package com.web.entity;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;
@XmlRootElement
public class ItemObject implements Serializable {

	private static final long serialVersionUID = 3219436977433972296L;
	
	private Integer id;
	private Integer typeId;

	private String category;
	private String type;
	private Double price;
	private String description;
	//@XmlElement(type = Byte.class)
	private String image;
	private Boolean newItem;
	private Boolean usedItem;
	private String condition;
	private String sellerName;
	private Boolean itemSold;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getTypeId() {
		return typeId;
	}
	public void setTypeId(Integer typeId) {
		this.typeId = typeId;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
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
	public String getCondition() {
		return condition;
	}
	public void setCondition(String condition) {
		this.condition = condition;
	}
	public String getSellerName() {
		return sellerName;
	}
	public void setSellerName(String sellerName) {
		this.sellerName = sellerName;
	}
	public Boolean getItemSold() {
		return itemSold;
	}
	public void setItemSold(Boolean itemSold) {
		this.itemSold = itemSold;
	}
	

}