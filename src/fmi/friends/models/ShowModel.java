package fmi.friends.models;

import java.math.BigDecimal;
import java.util.Date;

import fmi.friends.hibernateEntities.Genre;
import fmi.friends.hibernateEntities.Theater;

public class ShowModel {
	
	private int id;

	private String name;

	private Date creationDate;

	private String description;

	private Theater theater;

	private Date startDate;

	private Date endDate;

	private String avatarURL;

	private BigDecimal price;

	private Genre genre;

	public ShowModel(int id, String name, Date creationDate, String description, Theater theater, Date startDate,
			Date endDate, String avatarURL, BigDecimal price, Genre genre) {
		super();
		this.id = id;
		this.name = name;
		this.creationDate = creationDate;
		this.description = description;
		this.theater = theater;
		this.startDate = startDate;
		this.endDate = endDate;
		this.avatarURL = avatarURL;
		this.price = price;
		this.genre = genre;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Theater getTheater() {
		return theater;
	}

	public void setTheater(Theater theater) {
		this.theater = theater;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getAvatarURL() {
		return avatarURL;
	}

	public void setAvatarURL(String avatarURL) {
		this.avatarURL = avatarURL;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public Genre getGenre() {
		return genre;
	}

	public void setGenre(Genre genre) {
		this.genre = genre;
	}
	
	
}
