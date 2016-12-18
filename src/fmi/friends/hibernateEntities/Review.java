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
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "REVIEW", uniqueConstraints = { @UniqueConstraint(columnNames = { "ID" }) })
public class Review {

	private int id;

	private User user;

	private String description;

	private BigDecimal rating;

	private Date creationDate;

	private Shows show;

	private Set<Comment> comments = new HashSet<Comment>(
			0);


	public Review() {
		super();
	}

	public Review(int id, User user, String description, BigDecimal rating, Date creationDate, Shows show,
			Set<Comment> comments) {
		super();
		this.id = id;
		this.user = user;
		this.description = description;
		this.rating = rating;
		this.creationDate = creationDate;
		this.show = show;
		this.comments = comments;
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


	@Column(name = "DESCRIPTION", length = 100)
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Column(name = "RATING", length = 100)
	public BigDecimal getRating() {
		return rating;
	}

	public void setRating(BigDecimal rating) {
		this.rating = rating;
	}

	@Column(name = "CREATIONDATE")
	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "USER_ID", nullable = false)
	@JsonBackReference
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "SHOW_ID", nullable = false)
	 @JsonBackReference
	public Shows getShow() {
		return show;
	}

	public void setShow(Shows show) {
		this.show = show;
	}
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "review")
	@JsonIgnore
	public Set<Comment> getComments() {
		return comments;
	}

	public void setComments(Set<Comment> comments) {
		this.comments = comments;
	}



}