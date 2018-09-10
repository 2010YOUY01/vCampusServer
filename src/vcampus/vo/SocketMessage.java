package vcampus.vo;

import java.io.Serializable;


//this file should always be the same as the one in vCampusClient
public class SocketMessage implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -6732448309933765982L;
	//uid to be implemented
	private int uid = 0;
	private String username = "0";
	private int code = 0;
	public enum TYPE{
		LOGINCHECK, //登陆
		LOGINSUCCEED, 
		LOGINFAIL, 
		REGISTER, //注册
		REGISTERSUCCEED, 
		REGISTERFAIL, 
		SEARCH_PERSONINFO,  //查学籍信息
		SELECT_COURSE, //选课
		SELECT_COURSE_SUCCEED, 
		SELECT_COURSE_FAIL, 
		DROP_COURSE, //退课
		DROP_COURSE_SUCCEED, 
		DROP_COURSE_FAIL, 
		GET_COURSE_TABLE, //查课表
		GET_ALL_COURSE, //获取所有课
		GET_COURSE_TABLE_SUCCEED, 
		GET_COURSE_TABLE_FAIL, 
		SEARCH_PRODUCT, //查询商品
		GET_ALL_PRODUCTS, //获得商品列表
		BUY_PRODUCT, //购买商品
		BUY_PRODUCT_SUCCEED, 
		BUY_PRODUCT_FAIL, 
		SEARCH_SHOPPING_HISTORY, //查询购买记录
		CHARGE, //充值
		CHARGE_SUCCEED, 
		CHARGE_FAIL, 
		CHECK_ACCOUNT_BALANCE, //查询账户余额
		CHECK_ACCOUNT_HISTORY, //查看消费记录
		SEARCH_BOOK_NAME, //按照书名查找
		SEARCH_BOOK_AUTHOR, //按照作者查找
		BORROW_BOOK, //借书
		BORROW_BOOK_SUCCEED,
		BORROW_BOOK_FAIL,
		RETURN_BOOK, //还书
		RETURN_BOOK_SUCCEED,
		RETURN_BOOK_FAIL,
		CHECK_LIBRARY_HISTORY, //查询借阅记录
		PASSING_DATA,
		CHECK_COURSE_SELECTED,
		COURSE_SELECTED,
		COURSE_NOT_SELECTED,
		LOGOUT;
		
		
	}
	private TYPE type;
	private Object obj = null;
		
	public SocketMessage(String username, TYPE type) {
		this.username = username;
		this.type = type;
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}


	public Object getObj() {
		return obj;
	}

	public void setObj(Object obj) {
		this.obj = obj;
	}

	public TYPE getType() {
		return type;
	}

	public void setType(TYPE type) {
		this.type = type;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
	
	
}
