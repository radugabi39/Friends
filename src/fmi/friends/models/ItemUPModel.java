package fmi.friends.models;

import java.math.BigDecimal;
import java.util.Date;

public class ItemUPModel {

	
	private String name;
	private BigDecimal price;
	private Date purchaseDate;
	public ItemUPModel(String name, BigDecimal price,Date purchaseDate) {
		super();
		this.name = name;
		this.price = price;
		this.purchaseDate=purchaseDate;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public Date getPurchaseDate() {
		return purchaseDate;
	}

	public void setPurchaseDate(Date purchaseDate) {
		this.purchaseDate = purchaseDate;
	}
	
}
