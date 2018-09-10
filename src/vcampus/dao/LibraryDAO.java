package vcampus.dao;

import java.util.ArrayList;
import java.util.Date;

import vcampus.vo.Book;
import vcampus.vo.BookBorrowInfo;

public class LibraryDAO {
	//根据作者查找书籍
	public ArrayList<Book> serarchByAuthor(String authorName) {
		ArrayList<Book> bookList= new ArrayList<Book>();
		Book book1 = new Book(0, "234239582938", "计算机组成原理", "任国林"
				, "电子工业出版社", false);
		Book book2 = new Book(1, "234239582938", "计算器组成原理", "程书林"
				, "电子工业出版社", false);
		bookList.add(book1);
		bookList.add(book2);
		return bookList;
	}
	
	//根据书名查找书籍
	public ArrayList<Book> serarchByBookname(String bookName) {
		ArrayList<Book> bookList= new ArrayList<Book>();
		Book book1 = new Book(0, "234239582938", "南京话从入门到精通", "任国林"
				, "电子工业出版社", false);
		Book book2 = new Book(1, "234239582938", "我的烤烤面筋", "程书林"
				, "电子工业出版社", false);
		bookList.add(book1);
		bookList.add(book2);
		return bookList;
	}
	
	//记得更新书籍借阅历史
	//根据借书者的学号，书的uid借书
	//例： borrowBook("09016314", 0)，0为书籍编号
	public boolean borrowBook(String username, int uID) {
		boolean borrowSucceedFlag = false;
		
		return borrowSucceedFlag;
	}
	
	//记得更新书籍借阅历史
	//根据借书者的学号，书的uid还书
	public boolean returnBook(String username, int uID) {
		boolean returnBookSucceed = false;
		
		return returnBookSucceed;
	}
	
	//通过学号查找一个人的借阅历史
	public ArrayList<BookBorrowInfo> searchHistory(String username){
		ArrayList<BookBorrowInfo> history= new ArrayList<BookBorrowInfo>();
		Date date = new Date(2018, 9, 10);
		BookBorrowInfo info1 = new BookBorrowInfo(2, "tony", "bookname", date, date);
		BookBorrowInfo info2 = new BookBorrowInfo(2, "john", "bookname2", date, date);
		history.add(info1);
		history.add(info2);
		
		return history;
	}
}
