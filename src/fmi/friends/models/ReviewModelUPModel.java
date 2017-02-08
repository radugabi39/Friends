package fmi.friends.models;

import java.math.BigDecimal;

public class ReviewModelUPModel {

	
	private String descrReview;
	private Integer points;
	private BigDecimal rating;
	private Integer noVotes;
	
	public ReviewModelUPModel(String descrReview, BigDecimal rating,Integer noVotes) {
		super();
		this.descrReview = descrReview;
		if(noVotes!=null && rating!=null)
		this.points = rating.multiply(new BigDecimal(noVotes)).intValue();
		this.rating=rating;
		this.noVotes=noVotes;
	}
	
	public String getDescrReview() {
		return descrReview;
	}
	public void setDescrReview(String descrReview) {
		this.descrReview = descrReview;
	}
	public Integer getPoints() {
		return points;
	}
	public void setPoints(Integer points) {
		this.points = points;
	}

	public Integer getNoVotes() {
		return noVotes;
	}

	public void setNoVotes(Integer noVotes) {
		this.noVotes = noVotes;
	}

	public BigDecimal getRating() {
		return rating;
	}

	public void setRating(BigDecimal rating) {
		this.rating = rating;
	}
	
}
