package fmi.friends.hibernateEntities;


import java.io.Serializable;
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

@Entity
@Table(name = "USERTITLE", uniqueConstraints = { @UniqueConstraint(columnNames = { "TITLE_ID", "USER_ID"}) })
public class UserTitle implements Serializable {

	private Integer id;
	private Title title;
	private User user;
	private Boolean active;
	
	public UserTitle() {
		super();
	}
	public UserTitle(Integer id,Title title, User user, Boolean active) {
		super();
		this.id=id;
		this.title = title;
		this.user = user;
		this.active = active;
	}
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID", nullable=false, unique=true, length=11)
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	@ManyToOne
	@JoinColumn(name = "TITLE_ID", unique = true, nullable = false)
	 @JsonBackReference
	public Title getTitle() {
		return title;
	}
	public void setTitle(Title title) {
		this.title = title;
	}


	@ManyToOne
	@JoinColumn(name = "USER_ID", unique = true, nullable = false)
	 @JsonBackReference
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	@Column(name="ACTIVE", length=20)
	public Boolean getActive() {
		return active;
	}
	public void setActive(Boolean active) {
		this.active = active;
	}

}