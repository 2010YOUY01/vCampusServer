package vcampus.dao;

import java.util.ArrayList;

import vcampus.vo.Book;
import vcampus.vo.BookBorrowInfo;

public class LibraryDAO {
	//�������߲����鼮
	public ArrayList<Book> serarchByAuthor(String authorName) {
		ArrayList<Book> bookList= null;
		Book book = new Book(0, "234239582938", "��������ԭ��", "�ι���"
				, "���ӹ�ҵ������", false);
		bookList.add(book);
		return bookList;
	}
	
	//�������������鼮
	public ArrayList<Book> serarchByBookname(String bookName) {
		ArrayList<Book> bookList = null;
		Book book = new Book(0, "234239582938", "��������ԭ��", "�ι���"
				, "���ӹ�ҵ������", false);
		bookList.add(book);
		
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
		ArrayList<BookBorrowInfo> history= null;
		
		return history;
	}
}
