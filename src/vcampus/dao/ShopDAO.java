package vcampus.dao;

import java.util.ArrayList;

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
	//��ָ���û���Ǯ
	public boolean subMoney(String username, double money) {
		boolean subSucceedFlag = false;
		//��BankInfo���ݿ��и����˻�
		return subSucceedFlag;
	}
	
	//��ȡ������Ʒ�б�
	public ArrayList<Product> getAllProducts(){
		ArrayList<Product> productList = null;
		
		return productList;
	}
	
	//������Ʒ���Ʋ�����Ʒ
	public ArrayList<Product> getProducts(String productName){
		ArrayList<Product> productList = null;
		
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
		return buySucceedFlag;
	}
	
	//��ѯ�����¼
	public ArrayList<ShoppingInfo> getShoppingHistory(String username){
		ArrayList<ShoppingInfo> shoppingHistory= null;
		
		return shoppingHistory;
	}
	
	//��ѯ�˻����
	public double getBalance(String username) {
		double balance = 3.4;
		
		return balance;
	}
	
	//��ѯ�˻���ʷ
	public ArrayList<BankInfo> getAccountHistory(String username){
		ArrayList<BankInfo> accountHistory= null;
		
		return accountHistory;
	}
}
