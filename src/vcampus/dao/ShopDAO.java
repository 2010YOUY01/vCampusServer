package vcampus.dao;

import java.util.ArrayList;

import vcampus.vo.BankInfo;
import vcampus.vo.Product;
import vcampus.vo.ShoppingInfo;

public class ShopDAO {
	//给指定用户充钱
	public boolean addMoney(String username, double money) {
		boolean addSucceedFlag = false;
		//在BankInfo数据库中更新账户
		//BankInfo为每个账户的余额信息
		return addSucceedFlag;
	}
	//给指定用户减钱
	public boolean subMoney(String username, double money) {
		boolean subSucceedFlag = false;
		//在BankInfo数据库中更新账户
		return subSucceedFlag;
	}
	
	//获取所有商品列表
	public ArrayList<Product> getAllProducts(){
		ArrayList<Product> productList = null;
		
		return productList;
	}
	
	//按照商品名称查找商品
	public ArrayList<Product> getProducts(String productName){
		ArrayList<Product> productList = null;
		
		return productList;
	}
	
	//购买商品
	//
	//有更改
	//
	public boolean buyProduct(String username, int productUID) {
		boolean buySucceedFlag = false;
		//在BankInfo中更新用户余额
		//在ShoopingInfo中更新消费记录
		return buySucceedFlag;
	}
	
	//查询购买记录
	public ArrayList<ShoppingInfo> getShoppingHistory(String username){
		ArrayList<ShoppingInfo> shoppingHistory= null;
		
		return shoppingHistory;
	}
	
	//查询账户余额
	public double getBalance(String username) {
		double balance = 3.4;
		
		return balance;
	}
	
	//查询账户历史
	public ArrayList<BankInfo> getAccountHistory(String username){
		ArrayList<BankInfo> accountHistory= null;
		
		return accountHistory;
	}
}
