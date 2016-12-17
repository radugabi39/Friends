package fmi.friends.hibernateEntities;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "USER", uniqueConstraints = { @UniqueConstraint(columnNames = { "USERNAME","EMAIL","ID" }) })
public class User {
	
	private Integer id;

	private String password;

	private Role role;

	private Date creationDate;

	private Date modificationDate;

	private String avatarURL;

	private String firstName;

	private String lastName;

	private String userName;
	
	private String email;
	
	private Integer points;

	private Set<Review> reviews = new HashSet<Review>(0);

	private Set<Comment> comments = new HashSet<Comment>(0);

	private Set<Orders> orders = new HashSet<Orders>(0);

	 private Set<UserTitle> userTitles = new HashSet<UserTitle>(0);

	public User() {
		super();
	}

	public User(Integer id, String password, Role role, Date creationDate, Date modificationDate, String avatarURL,
			String firstName, String lastName, String userName, String email, Integer points, Set<Review> reviews,
			Set<Comment> comments, Set<Orders> orders, Set<UserTitle> userTitles) {
		super();
		this.id = id;
		this.password = password;
		this.role = role;
		this.creationDate = creationDate;
		this.modificationDate = modificationDate;
		this.avatarURL = avatarURL;
		this.firstName = firstName;
		this.lastName = lastName;
		this.userName = userName;
		this.email = email;
		this.points = points;
		this.reviews = reviews;
		this.comments = comments;
		this.orders = orders;
		this.userTitles = userTitles;
	}

	@Column(name = "PASSWORD", length = 20)
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ROLE_ID", nullable = false)
	 @JsonBackReference
	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	@Column(name = "CREATIONDATE")
	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	@Column(name = "MODIFICATIONDATE")
	public Date getModificationDate() {
		return modificationDate;
	}

	public void setModificationDate(Date modificationDate) {
		this.modificationDate = modificationDate;
	}

	@Column(name = "AVATARURL", length = 20)
	public String getAvatarURL() {
		return avatarURL;
	}

	public void setAvatarURL(String avatarURL) {
		this.avatarURL = avatarURL;
	}

	@Column(name = "FIRSTNAME", length = 20)
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	@Column(name = "LASTNAME", length = 20)
	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
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

	@Column(name = "POINTS")
	public Integer getPoints() {
		return points;
	}

	public void setPoints(Integer points) {
		this.points = points;
	}

	@OneToMany(mappedBy = "user")
	 @JsonManagedReference
	public Set<Review> getReviews() {
		return reviews;
	}

	public void setReviews(Set<Review> reviews) {
		this.reviews = reviews;
	}

	@OneToMany(mappedBy = "user")
	 @JsonManagedReference
	public Set<Comment> getComments() {
		return comments;
	}

	public void setComments(Set<Comment> comments) {
		this.comments = comments;
	}

	
	@OneToMany(mappedBy = "user")
	 @JsonManagedReference
	public Set<Orders> getOrders() {
		return orders;
	}

	public void setOrders(Set<Orders> orders) {
		this.orders = orders;
	}
	@Column(name = "USERNAME",unique=true,length = 20)
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	@Column(name = "EMAIL",unique=true, length = 20)
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	 @OneToMany(mappedBy = "user")
	 @JsonManagedReference
	 public Set<UserTitle> getUserTitles() {
	 return userTitles;
	 }
	
	 public void setUserTitles(Set<UserTitle> userTitles) {
	 this.userTitles = userTitles;
	 }

}