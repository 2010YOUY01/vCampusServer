package vcampus.vo;

import java.io.Serializable;

public class Product implements Serializable{
	private int uID;
	private String name;
	private double price;
	private String label;
	public Product(int uID, String name, double price, String label) {
		super();
		this.uID = uID;
		this.name = name;
		this.price = price;
		this.label = label;
	}
	public int getuID() {
		return uID;
	}
	public void setuID(int uID) {
		this.uID = uID;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	
	
}
