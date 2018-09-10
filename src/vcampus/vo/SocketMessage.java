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
		LOGINCHECK, //��½
		LOGINSUCCEED, 
		LOGINFAIL, 
		REGISTER, //ע��
		REGISTERSUCCEED, 
		REGISTERFAIL, 
		SEARCH_PERSONINFO,  //��ѧ����Ϣ
		SELECT_COURSE, //ѡ��
		SELECT_COURSE_SUCCEED, 
		SELECT_COURSE_FAIL, 
		DROP_COURSE, //�˿�
		DROP_COURSE_SUCCEED, 
		DROP_COURSE_FAIL, 
		GET_COURSE_TABLE, //��α�
		GET_ALL_COURSE, //��ȡ���п�
		GET_COURSE_TABLE_SUCCEED, 
		GET_COURSE_TABLE_FAIL, 
		SEARCH_PRODUCT, //��ѯ��Ʒ
		GET_ALL_PRODUCTS, //�����Ʒ�б�
		BUY_PRODUCT, //������Ʒ
		BUY_PRODUCT_SUCCEED, 
		BUY_PRODUCT_FAIL, 
		SEARCH_SHOPPING_HISTORY, //��ѯ�����¼
		CHARGE, //��ֵ
		CHARGE_SUCCEED, 
		CHARGE_FAIL, 
		CHECK_ACCOUNT_BALANCE, //��ѯ�˻����
		CHECK_ACCOUNT_HISTORY, //�鿴���Ѽ�¼
		SEARCH_BOOK_NAME, //������������
		SEARCH_BOOK_AUTHOR, //�������߲���
		BORROW_BOOK, //����
		BORROW_BOOK_SUCCEED,
		BORROW_BOOK_FAIL,
		RETURN_BOOK, //����
		RETURN_BOOK_SUCCEED,
		RETURN_BOOK_FAIL,
		CHECK_LIBRARY_HISTORY, //��ѯ���ļ�¼
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
