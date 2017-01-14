package fmi.friends.hibernateEntities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="TOKEN")
public class Token {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID", nullable = false, unique = true, length = 11)
	private Long id;
	private Integer userID; // security
	private String token;
	private Date expiration;
	public Token(){};
	public Token(Long id,Integer userID, String token, Date expiration) {
		super();
		this.id=id;
		this.userID = userID;
		this.token = token;
		this.expiration = expiration;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	@Column(name="USERID", length=20, nullable=true)
	public Integer getUserID() {
		return userID;
	}
	public void setUserID(Integer userID) {
		this.userID = userID;
	}
	@Column(name="TOKEN", length=20, nullable=true)
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	@Column(name="EXPIRATION", length=20, nullable=true)
	public Date getExpiration() {
		return expiration;
	}
	public void setExpiration(Date expiration) {
		this.expiration = expiration;
	}
	
}
