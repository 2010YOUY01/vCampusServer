package vcampus.vo;

import java.io.Serializable;
import java.util.Date;

public class BookBorrowInfo implements Serializable{
	private int uID;
	private String bookname;
	private String username;
	private Date borrowDate;
	private Date returnDate;
	
	
	public BookBorrowInfo(int uID, String bookname, String username, Date borrowDate, Date returnDate) {
		super();
		this.uID = uID;
		this.bookname = bookname;
		this.username = username;
		this.borrowDate = borrowDate;
		this.returnDate = returnDate;
	}
	public int getuID() {
		return uID;
	}
	public void setuID(int uID) {
		this.uID = uID;
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public Date getBorrowDate() {
		return borrowDate;
	}
	public void setBorrowDate(Date borrowDate) {
		this.borrowDate = borrowDate;
	}
	public Date getReturnDate() {
		return returnDate;
	}
	public void setReturnDate(Date returnDate) {
		this.returnDate = returnDate;
	}
	public String getBookname() {
		return bookname;
	}
	public void setBookname(String bookname) {
		this.bookname = bookname;
	}
	
	
	
	
	
}
