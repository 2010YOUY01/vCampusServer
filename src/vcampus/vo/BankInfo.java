package vcampus.vo;

import java.io.Serializable;
import java.util.Date;

//example: BankInfo bankInfo = new BankInfo("09016314", true, 10.5, 2018.9.4)
//��ʾ��ѧ���ڵ������10.5
//true �ĳ�false������������10.5
public class BankInfo implements Serializable{
	private String username;
	private double money; //���� ����-10������10Ԫ +100 ��ֵ100Ԫ
	private double balance; //�˻����
	private Date date;
	public BankInfo(String username, double money, double balance, Date date) {
		super();
		this.username = username;
		this.money = money;
		this.balance = balance;
		this.date = date;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public double getMoney() {
		return money;
	}
	public void setMoney(double money) {
		this.money = money;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	
	
}
