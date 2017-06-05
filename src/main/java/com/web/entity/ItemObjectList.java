package com.web.entity;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
@XmlRootElement
public class ItemObjectList implements Serializable {

	private static final long serialVersionUID = 5763478037966261478L;
	@XmlAttribute
	private List<ItemObject> itemEntityList;

	public List<ItemObject> getItemEntityList() {
		return itemEntityList;
	}

	public void setItemEntityList(List<ItemObject> itemEntityList) {
		this.itemEntityList = itemEntityList;
	}
	

}
