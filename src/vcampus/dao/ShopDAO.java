package vcampus.dao;

import java.util.ArrayList;

import vcampus.vo.Product;
import vcampus.vo.ShoppingInfo;

public class ShopDAO {
	//��ָ���û���Ǯ
	boolean addMoney(String username, double money) {
		boolean addSucceedFlag = false;
		//��BankInfo���ݿ��и����˻�
		//BankInfoΪÿ���˻��������Ϣ
		return addSucceedFlag;
	}
	//��ָ���û���Ǯ
	boolean subMoney(String username, double money) {
		boolean subSucceedFlag = false;
		//��BankInfo���ݿ��и����˻�
		return subSucceedFlag;
	}
	
	//��ȡ������Ʒ�б�
	ArrayList<Product> getAllProducts(){
		ArrayList<Product> productList = null;
		
		return productList;
	}
	
	//������Ʒ���Ʋ�����Ʒ
	ArrayList<Product> getAllProducts(String productName){
		ArrayList<Product> productList = null;
		
		return productList;
	}
	
	//������Ʒ
	boolean buyProduct(String username, Product product) {
		boolean buySucceedFlag = false;
		//��BankInfo�и����û����
		//��ShoopingInfo�и������Ѽ�¼
		return buySucceedFlag;
	}
	
	//��ѯ�����¼
	ArrayList<ShoppingInfo> getShoppingHistory(String username){
		ArrayList<ShoppingInfo> shoppingHistory= null;
		
		return shoppingHistory;
	}
}
