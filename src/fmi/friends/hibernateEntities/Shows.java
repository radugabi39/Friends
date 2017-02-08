package fmi.friends.hibernateEntities;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "SHOWS", uniqueConstraints = { @UniqueConstraint(columnNames = { "ID" }) })
public class Shows {

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
	
	private Set<Review> reviews = new HashSet<Review>(
			0);
	
	

	public Shows() {
		super();
		this.reviews=null;
	}

	public Shows(int id, String name, Date creationDate, String description, Theater theater, Date startDate,
			Date endDate, String avatarURL, BigDecimal price, Genre genre, Set<Review> reviews) {
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
		this.reviews = null;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID", nullable = false, unique = true, length = 11)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name = "NAME", length = 20, nullable = true)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "DESCRIPTION", length = 500)
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Column(name = "PRICE")
	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	@Column(name = "CREATIONDATE")
	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	@Column(name = "AVATARURL", length = 100)
	public String getAvatarURL() {
		return avatarURL;
	}

	public void setAvatarURL(String avatarURL) {
		this.avatarURL = avatarURL;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "THEATER_ID", nullable = false)
	 @JsonBackReference
	public Theater getTheater() {
		return theater;
	}

	public void setTheater(Theater theater) {
		this.theater = theater;
	}

	@Column(name = "STARTDATE")
	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	@Column(name = "ENDDATE")
	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "GENRE_ID", nullable = false)
	 @JsonBackReference
	public Genre getGenre() {
		return genre;
	}

	public void setGenre(Genre genre) {
		this.genre = genre;
	}
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "show")
	@JsonIgnore
	public Set<Review> getReviews() {
		return reviews;
	}

	public void setReviews(Set<Review> reviews) {
		this.reviews = reviews;
	}
	
	
}