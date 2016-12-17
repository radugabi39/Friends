package fmi.friends.hibernateEntities;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "ITEM", uniqueConstraints = { @UniqueConstraint(columnNames = { "ID" }) })
public class Item {

	private int id;

	private String name;

	private String description;

	private BigDecimal price;

	private Date creationDate;

	private String avatarURL;
	
	private Integer stock;

	private Set<Orders> orders = new HashSet<Orders>(0);

	public Item() {
		super();
	}

	public Item(int id, String name, String description, BigDecimal price, Date creationDate, String avatarURL,
			Set<Orders> orders) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.price = price;
		this.creationDate = creationDate;
		this.avatarURL = avatarURL;
		this.orders = orders;
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

	@Column(name = "DESCRIPTION", length = 100)
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Column(name = "PRICE", length = 100)
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

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
	 @JsonManagedReference
	public Set<Orders> getOrders() {
		return orders;
	}

	public void setOrders(Set<Orders> orders) {
		this.orders = orders;
	}
	
	@Column(name = "STOCK", length = 100)
	public Integer getStock() {
		return stock;
	}
	
	public void setStock(Integer stock) {
		this.stock = stock;
	}
}
