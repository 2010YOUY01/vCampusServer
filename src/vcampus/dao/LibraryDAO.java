package vcampus.dao;

import java.util.ArrayList;
import java.util.Date;

import vcampus.vo.Book;
import vcampus.vo.BookBorrowInfo;

public class LibraryDAO {
	//�������߲����鼮
	public ArrayList<Book> serarchByAuthor(String authorName) {
		ArrayList<Book> bookList= new ArrayList<Book>();
		Book book1 = new Book(0, "234239582938", "��������ԭ��", "�ι���"
				, "���ӹ�ҵ������", false);
		Book book2 = new Book(1, "234239582938", "���������ԭ��", "������"
				, "���ӹ�ҵ������", false);
		bookList.add(book1);
		bookList.add(book2);
		return bookList;
	}
	
	//�������������鼮
	public ArrayList<Book> serarchByBookname(String bookName) {
		ArrayList<Book> bookList= new ArrayList<Book>();
		Book book1 = new Book(0, "234239582938", "�Ͼ��������ŵ���ͨ", "�ι���"
				, "���ӹ�ҵ������", false);
		Book book2 = new Book(1, "234239582938", "�ҵĿ������", "������"
				, "���ӹ�ҵ������", false);
		bookList.add(book1);
		bookList.add(book2);
		return bookList;
	}
	
	//�ǵø����鼮������ʷ
	//���ݽ����ߵ�ѧ�ţ����uid����
	//���� borrowBook("09016314", 0)��0Ϊ�鼮���
	public boolean borrowBook(String username, int uID) {
		boolean borrowSucceedFlag = false;
		
		return borrowSucceedFlag;
	}
	
	//�ǵø����鼮������ʷ
	//���ݽ����ߵ�ѧ�ţ����uid����
	public boolean returnBook(String username, int uID) {
		boolean returnBookSucceed = false;
		
		return returnBookSucceed;
	}
	
	//ͨ��ѧ�Ų���һ���˵Ľ�����ʷ
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
