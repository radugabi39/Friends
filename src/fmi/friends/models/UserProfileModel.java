package fmi.friends.models;

import java.util.List;

public class UserProfileModel {
	
	private String name;
	private Integer noPoints;
	private List<ReviewModelUPModel> revList;
	private List<ItemUPModel> itemList;
	
	public UserProfileModel(String name, Integer noPoints, List<ReviewModelUPModel> revList, List<ItemUPModel> itemList) {
		super();
		this.name = name;
		this.noPoints = noPoints;
		this.revList = revList;
		this.itemList = itemList;
	}
	
	public UserProfileModel(String name, Integer noPoints) {
		super();
		this.name = name;
		this.noPoints = noPoints;

	}
	public UserProfileModel() {
		super();


	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getNoPoints() {
		return noPoints;
	}

	public void setNoPoints(Integer noPoints) {
		this.noPoints = noPoints;
	}

	public List<ReviewModelUPModel> getRevList() {
		return revList;
	}

	public void setRevList(List<ReviewModelUPModel> revList) {
		this.revList = revList;
	}

	public List<ItemUPModel> getItemList() {
		return itemList;
	}

	public void setItemList(List<ItemUPModel> itemList) {
		this.itemList = itemList;
	}
	
	

}
