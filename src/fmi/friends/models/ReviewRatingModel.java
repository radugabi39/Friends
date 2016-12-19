package fmi.friends.models;

import java.math.BigDecimal;

public class ReviewRatingModel {

	private int reviewId;
	private BigDecimal rating;
	
	public ReviewRatingModel() {
		super();
	}
	
	public ReviewRatingModel(int reviewId, BigDecimal rating) {
		super();
		this.reviewId = reviewId;
		this.rating = rating;
	}

	public int getReviewId() {
		return reviewId;
	}
	public void setReviewId(int reviewId) {
		this.reviewId = reviewId;
	}
	public BigDecimal getRating() {
		return rating;
	}
	public void setRating(BigDecimal rating) {
		this.rating = rating;
	}
	
	
}
