package vcampus.dao;

import java.util.ArrayList;

import vcampus.vo.Product;
import vcampus.vo.ShoppingInfo;

public class ShopDAO {
	//给指定用户充钱
	boolean addMoney(String username, double money) {
		boolean addSucceedFlag = false;
		//在BankInfo数据库中更新账户
		//BankInfo为每个账户的余额信息
		return addSucceedFlag;
	}
	//给指定用户减钱
	boolean subMoney(String username, double money) {
		boolean subSucceedFlag = false;
		//在BankInfo数据库中更新账户
		return subSucceedFlag;
	}
	
	//获取所有商品列表
	ArrayList<Product> getAllProducts(){
		ArrayList<Product> productList = null;
		
		return productList;
	}
	
	//按照商品名称查找商品
	ArrayList<Product> getAllProducts(String productName){
		ArrayList<Product> productList = null;
		
		return productList;
	}
	
	//购买商品
	boolean buyProduct(String username, Product product) {
		boolean buySucceedFlag = false;
		//在BankInfo中更新用户余额
		//在ShoopingInfo中更新消费记录
		return buySucceedFlag;
	}
	
	//查询购买记录
	ArrayList<ShoppingInfo> getShoppingHistory(String username){
		ArrayList<ShoppingInfo> shoppingHistory= null;
		
		return shoppingHistory;
	}
}
