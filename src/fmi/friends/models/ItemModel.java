package fmi.friends.models;

import java.math.BigDecimal;

public class ItemModel {
	
	private String name;
	private String description;
	private BigDecimal price;
	private Integer stock;
	private String avatarURL;
	
	public ItemModel(String name, String description, BigDecimal price, Integer stock,String avatarURL) {
		super();
		this.name = name;
		this.description = description;
		this.price = price;
		this.stock = stock;
		this.avatarURL = avatarURL;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public Integer getStock() {
		return stock;
	}

	public void setStock(Integer stock) {
		this.stock = stock;
	}

	public String getAvatarURL() {
		return avatarURL;
	}

	public void setAvatarURL(String avatarURL) {
		this.avatarURL = avatarURL;
	}
	
}
