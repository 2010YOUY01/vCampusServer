package vcampus.vo;

import java.util.Date;

public class ShoppingInfo {
	private String username;
	private Product product;
	private Date purchaseDate;
	public ShoppingInfo(String username, Product product, Date purchaseDate) {
		super();
		this.username = username;
		this.product = product;
		this.purchaseDate = purchaseDate;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public Date getPurchaseDate() {
		return purchaseDate;
	}
	public void setPurchaseDate(Date purchaseDate) {
		this.purchaseDate = purchaseDate;
	}
	
	
}
