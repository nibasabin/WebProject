package com.web.entity;

import java.io.Serializable;

public class ItemObject implements Serializable {

	private static final long serialVersionUID = 3219436977433972296L;
	private String description;
	private String type;
	private Integer price;
	private String image;
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	
	
	
	
	/*private int itemNo;
	private int itemId;
	private File image;
	private  String itemName;
	private  String itemDescription;
	private  int itemQuantity;
	private  int itemUnitPrice;

	@Override
	public String toString() {
		return "ItemObject [itemId=" + itemId + ", itemName=" + itemName + ", itemDescription=" + itemDescription
				+ ", itemQuantity=" + itemQuantity + ", itemUnitPrice=" + itemUnitPrice + "]";
	}
	public ItemObject()
	{
		this.itemNo=0;
		this.itemId=0;
		this.itemName="itemName";
		this.itemDescription="itemDescription";
		this.itemQuantity=0;
		this.itemUnitPrice=0;
	}
	public ItemObject(int itemId,String itemName,String itemDescription, int itemQuantity,int itemUnitPrice)
	{
		this.itemId=itemId;
		this.itemName=itemName;
		this.itemDescription=itemDescription;
		this.itemQuantity=itemQuantity;
		this.itemUnitPrice=itemUnitPrice;
	}

	public File getImage() {
		return image;
	}
	public void setImage(File image) {
		this.image = image;
	}
	public int getItemNo() {
		return itemNo;
	}
	public void setItemNo(int itemNo) {
		this.itemNo = itemNo;
	}
	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getItemDescription() {
		return itemDescription;
	}

	public void setItemDescription(String itemDescription) {
		this.itemDescription = itemDescription;
	}

	public int getItemQuantity() {
		return itemQuantity;
	}

	public void setItemQuantity(int itemQuantity2) {
		this.itemQuantity = itemQuantity2;
	}

	public int getItemUnitPrice() {
		return itemUnitPrice;
	}

	public void setItemUnitPrice(int itemUnitPrice) {
		this.itemUnitPrice = itemUnitPrice;
	}*/
}
