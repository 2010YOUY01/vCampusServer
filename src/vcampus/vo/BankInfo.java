package vcampus.vo;

import java.util.Date;

//example: BankInfo bankInfo = new BankInfo("09016314", true, 10.5, 2018.9.4)
//表示该学生在当天冲了10.5
//true 改成false，代表消费了10.5
public class BankInfo {
	private String username;
	private boolean addOrSub;
	private double money;
	private Date date;
	public BankInfo(String username, boolean addOrSub, double money, Date date) {
		super();
		this.username = username;
		this.addOrSub = addOrSub;
		this.money = money;
		this.date = date;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public boolean isAddOrSub() {
		return addOrSub;
	}
	public void setAddOrSub(boolean addOrSub) {
		this.addOrSub = addOrSub;
	}
	public double getMoney() {
		return money;
	}
	public void setMoney(double money) {
		this.money = money;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
}
