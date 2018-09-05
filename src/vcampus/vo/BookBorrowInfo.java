package vcampus.vo;

import java.util.Date;

public class BookBorrowInfo {
	private Book book;
	private String username;
	private Date borrowDate;
	private Date returnDate;
	public BookBorrowInfo(Book book, String username, Date borrowDate, Date returnDate) {
		super();
		this.book = book;
		this.username = username;
		this.borrowDate = borrowDate;
		this.returnDate = returnDate;
	}
	
}
