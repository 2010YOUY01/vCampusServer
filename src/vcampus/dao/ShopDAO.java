package vcampus.dao;

import java.util.ArrayList;
import java.util.Date;

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

	
	//获取所有商品列表
	public ArrayList<Product> getAllProducts(){
		ArrayList<Product> productList = new ArrayList<Product>();
		Product p1 = new Product(1, "牛奶", 3.5, "食物");
		Product p2 = new Product(2, "本子", 2, "文具");
		productList.add(p1);
		productList.add(p2);
		return productList;
	}
	
	//按照商品名称查找商品
	public ArrayList<Product> getProducts(String productName){
		ArrayList<Product> productList = new ArrayList<Product>();
		Product p1 = new Product(1, "西瓜", 3.5, "食物");
		Product p2 = new Product(2, "钢笔", 2, "文具");
		productList.add(p1);
		productList.add(p2);
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
		buySucceedFlag = true;
		return buySucceedFlag;
	}
	
	//查询购买记录
	public ArrayList<ShoppingInfo> getShoppingHistory(String username){
		ArrayList<ShoppingInfo> shoppingHistory= new ArrayList<ShoppingInfo>();
		Date date = new Date(2018,9,11);
		ShoppingInfo info1 = new ShoppingInfo(username, 1, "书", 3.5, date);
		ShoppingInfo info2 = new ShoppingInfo(username, 2, "苹果", 4.5, date);
		ShoppingInfo info3 = new ShoppingInfo(username, 3, "泡面", 5.5, date);
		shoppingHistory.add(info1);
		shoppingHistory.add(info2);
		shoppingHistory.add(info3);
		return shoppingHistory;
	}
	
	//查询账户余额
	public double getBalance(String username) {
		double balance = 3.4;
		
		return balance;
	}
	
	//查询账户历史
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
