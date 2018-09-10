package vcampus.vo;

import java.io.Serializable;
import java.util.Date;

public class ShoppingInfo implements Serializable{
	private String username;
	private int productUID;
	private String productName;
	private double price;
	private Date purchaseDate;
	public ShoppingInfo(String username, int productUID, String productName, double price, Date purchaseDate) {
		super();
		this.username = username;
		this.productUID = productUID;
		this.productName = productName;
		this.price = price;
		this.purchaseDate = purchaseDate;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public int getProductUID() {
		return productUID;
	}
	public void setProductUID(int productUID) {
		this.productUID = productUID;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public Date getPurchaseDate() {
		return purchaseDate;
	}
	public void setPurchaseDate(Date purchaseDate) {
		this.purchaseDate = purchaseDate;
	}

	
	
	
	
	
	
	
	
}
