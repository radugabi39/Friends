package fmi.friends.models;

public class ReviewSaveModel {

	private int showId;
	private int userId;
	private String description;
	
	
	public ReviewSaveModel() {
		super();
	}


	public ReviewSaveModel(int showId, int userId, String description) {
		super();
		this.showId = showId;
		this.userId = userId;
		this.description = description;
	}


	public int getShowId() {
		return showId;
	}


	public void setShowId(int showId) {
		this.showId = showId;
	}


	public int getUserId() {
		return userId;
	}


	public void setUserId(int userId) {
		this.userId = userId;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}
	
	
}
