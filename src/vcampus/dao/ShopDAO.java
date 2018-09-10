package vcampus.dao;

import java.util.ArrayList;
import java.util.Date;

import vcampus.vo.BankInfo;
import vcampus.vo.Product;
import vcampus.vo.ShoppingInfo;

public class ShopDAO {
	//��ָ���û���Ǯ
	public boolean addMoney(String username, double money) {
		boolean addSucceedFlag = false;
		//��BankInfo���ݿ��и����˻�
		//BankInfoΪÿ���˻��������Ϣ
		return addSucceedFlag;
	}

	
	//��ȡ������Ʒ�б�
	public ArrayList<Product> getAllProducts(){
		ArrayList<Product> productList = new ArrayList<Product>();
		Product p1 = new Product(1, "ţ��", 3.5, "ʳ��");
		Product p2 = new Product(2, "����", 2, "�ľ�");
		productList.add(p1);
		productList.add(p2);
		return productList;
	}
	
	//������Ʒ���Ʋ�����Ʒ
	public ArrayList<Product> getProducts(String productName){
		ArrayList<Product> productList = new ArrayList<Product>();
		Product p1 = new Product(1, "����", 3.5, "ʳ��");
		Product p2 = new Product(2, "�ֱ�", 2, "�ľ�");
		productList.add(p1);
		productList.add(p2);
		return productList;
	}
	
	//������Ʒ
	//
	//�и���
	//
	public boolean buyProduct(String username, int productUID) {
		boolean buySucceedFlag = false;
		//��BankInfo�и����û����
		//��ShoopingInfo�и������Ѽ�¼
		buySucceedFlag = true;
		return buySucceedFlag;
	}
	
	//��ѯ�����¼
	public ArrayList<ShoppingInfo> getShoppingHistory(String username){
		ArrayList<ShoppingInfo> shoppingHistory= new ArrayList<ShoppingInfo>();
		Date date = new Date(2018,9,11);
		ShoppingInfo info1 = new ShoppingInfo(username, 1, "��", 3.5, date);
		ShoppingInfo info2 = new ShoppingInfo(username, 2, "ƻ��", 4.5, date);
		ShoppingInfo info3 = new ShoppingInfo(username, 3, "����", 5.5, date);
		shoppingHistory.add(info1);
		shoppingHistory.add(info2);
		shoppingHistory.add(info3);
		return shoppingHistory;
	}
	
	//��ѯ�˻����
	public double getBalance(String username) {
		double balance = 3.4;
		
		return balance;
	}
	
	//��ѯ�˻���ʷ
	public ArrayList<BankInfo> getAccountHistory(String username){
		ArrayList<BankInfo> accountHistory= new ArrayList<BankInfo>();
		Date date = new Date(2018,9,9);
		BankInfo info1 = new BankInfo("yyt", -10, 90, date);
		BankInfo info2 = new BankInfo("yyyt", 10, 100, date);
		BankInfo info3 = new BankInfo("yyyyt", 30, 130, date);
		accountHistory.add(info1);
		accountHistory.add(info2);
		accountHistory.add(info3);

		
		return accountHistory;
	}
}
