package vcampus.vo;

import java.io.Serializable;

public class Book implements Serializable{
	private int uID;//0
	private String ISBN;//9787121095467
	private String bookName;//计算机组成原理
	private String author;//任国林
	private String publichser;//电子工业出版社
	private boolean alreadyBorrowed;//true 表示已经外借，false表示可以借阅
	public Book(int uID, String iSBN, String bookName, String author, String publichser, boolean alreadyBorrowed) {
		super();
		this.uID = uID;
		ISBN = iSBN;
		this.bookName = bookName;
		this.author = author;
		this.publichser = publichser;
		this.alreadyBorrowed = alreadyBorrowed;
	}
	public int getuID() {
		return uID;
	}
	public void setuID(int uID) {
		this.uID = uID;
	}
	public String getISBN() {
		return ISBN;
	}
	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getPublichser() {
		return publichser;
	}
	public void setPublichser(String publichser) {
		this.publichser = publichser;
	}
	public boolean isAlreadyBorrowed() {
		return alreadyBorrowed;
	}
	public void setAlreadyBorrowed(boolean alreadyBorrowed) {
		this.alreadyBorrowed = alreadyBorrowed;
	}
	
	
}
