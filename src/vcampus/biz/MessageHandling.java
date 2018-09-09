package vcampus.biz;

import java.sql.SQLException;
import java.util.ArrayList;

import vcampus.dao.CourseDAO;
import vcampus.dao.InfoDAO;
import vcampus.dao.LibraryDAO;
import vcampus.dao.LoginDAO;
import vcampus.dao.ShopDAO;
import vcampus.vo.BankInfo;
import vcampus.vo.Book;
import vcampus.vo.Course;
import vcampus.vo.LoginFormEvent;
import vcampus.vo.PersonInfo;
import vcampus.vo.Product;
import vcampus.vo.RegisterForm;
import vcampus.vo.ShoppingInfo;
import vcampus.vo.SocketMessage;

public class MessageHandling {
	public static SocketMessage handleMessage(SocketMessage msg) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		SocketMessage msgBack = null;
		switch (msg.getType()) {
		case LOGINCHECK:
			msgBack = loginCheck(msg);
			break;
		case REGISTER:
			msgBack = register(msg);
			break;
		case SEARCH_PERSONINFO:
			msgBack = searchPersonInfo(msg);
			break;
		case SELECT_COURSE:
			msgBack = selectCourse(msg);
			break;
		case DROP_COURSE:
			msgBack = dropCourse(msg);
			break;
		case GET_COURSE_TABLE:
			msgBack = getCourseTable(msg);
			break;
		case SEARCH_PRODUCT:
			msgBack = searchProduct(msg);
			break;
		case BUY_PRODUCT:
			msgBack = buyProduct(msg);
			break;
		case SEARCH_SHOPPING_HISTORY:
			msgBack = searchShoppingHistory(msg);
			break;
		case CHARGE:
			msgBack = charge(msg);
			break;
		case CHECK_ACCOUNT_BALANCE:
			msgBack = checkAccountBalance(msg);
			break;
		case CHECK_ACCOUNT_HISTORY:
			msgBack = checkAccountHistory(msg);
			break;
		case SEARCH_BOOK_NAME:
			msgBack = searchBookName(msg);
			break;
		case SEARCH_BOOK_AUTHOR:
			msgBack = searchBookAuthor(msg);
			break;
		case BORROW_BOOK:
			msgBack = borrowBook(msg);
			break;
		case RETURN_BOOK:
			msgBack = returnBook(msg);
			break;
		case CHECK_LIBRARY_HISTORY:
			msgBack = checkLibraryHistory(msg);
			break;
		case GET_ALL_PRODUCTS:
			msgBack = getAllProduct(msg);
			break;
		case GET_ALL_COURSE:
			msgBack = getAllCourse(msg);
			break;

		}
		return msgBack;

	}






	private static SocketMessage checkLibraryHistory(SocketMessage msg) {
		// init DAO, msg
		LibraryDAO libraryDAO = new LibraryDAO();
		SocketMessage msgBack = new SocketMessage("server", SocketMessage.TYPE.PASSING_DATA);
		// deal with received msg
		String username = msg.getUsername();
		// modify msgBack
		msgBack.setObj(libraryDAO.searchHistory(username));

		return msgBack;
	}

	private static SocketMessage returnBook(SocketMessage msg) {
		// init DAO, msg
		LibraryDAO libraryDAO = new LibraryDAO();
		SocketMessage msgBack = new SocketMessage("server", SocketMessage.TYPE.PASSING_DATA);
		// deal with received msg
		String username = msg.getUsername();
		int bookUID = (int) msg.getObj();
		boolean returnSucceedFlag = libraryDAO.returnBook(username, bookUID);
		// modify msgBack
		if(returnSucceedFlag == true) {
			msgBack.setType(SocketMessage.TYPE.RETURN_BOOK_SUCCEED);
		}else {
			msgBack.setType(SocketMessage.TYPE.RETURN_BOOK_FAIL);
		}
		
		return msgBack;
	}

	private static SocketMessage borrowBook(SocketMessage msg) {
		// init DAO, msg
		LibraryDAO libraryDAO = new LibraryDAO();
		SocketMessage msgBack = new SocketMessage("server", SocketMessage.TYPE.PASSING_DATA);
		// deal with received msg
		String username = msg.getUsername();
		int bookUID = (int) msg.getObj();
		boolean borrowSucceedFlag = libraryDAO.borrowBook(username, bookUID);
		// modify msgBack
		if(borrowSucceedFlag = true) {
			msgBack.setType(SocketMessage.TYPE.BORROW_BOOK_SUCCEED);
		}else {
			msgBack.setType(SocketMessage.TYPE.BORROW_BOOK_FAIL);
		}
		
		return msgBack;
	}

	private static SocketMessage searchBookAuthor(SocketMessage msg) {
		// init DAO, msg
		LibraryDAO libraryDAO = new LibraryDAO();
		SocketMessage msgBack = new SocketMessage("server", SocketMessage.TYPE.PASSING_DATA);
		// deal with received msg
		String authorName = (String) msg.getObj();
		ArrayList<Book> bookList = libraryDAO.serarchByAuthor(authorName);
		// modify msgBack
		msgBack.setObj(bookList);
		
		return msgBack;
	}

	private static SocketMessage searchBookName(SocketMessage msg) {
		// init DAO, msg
		LibraryDAO libraryDAO = new LibraryDAO();
		SocketMessage msgBack = new SocketMessage("server", SocketMessage.TYPE.PASSING_DATA);
		// deal with received msg
		String bookName = (String) msg.getObj();
		ArrayList<Book> bookList = libraryDAO.serarchByBookname(bookName);
		// modify msgBack
		msgBack.setObj(bookList);

		return msgBack;
	}

	private static SocketMessage checkAccountHistory(SocketMessage msg) {
		// init DAO, msg
		ShopDAO shopDAO = new ShopDAO();
		SocketMessage msgBack = new SocketMessage("server", SocketMessage.TYPE.PASSING_DATA);
		// deal with received msg
		String username = msg.getUsername();
		ArrayList<BankInfo> accountHistory = shopDAO.getAccountHistory(username);
		msgBack.setObj(accountHistory);
		// modify msgBack
		return msgBack;
	}

	private static SocketMessage checkAccountBalance(SocketMessage msg) {
		// init DAO, msg
		ShopDAO shopDAO = new ShopDAO();
		SocketMessage msgBack = new SocketMessage("server", SocketMessage.TYPE.PASSING_DATA);
		// deal with received msg
		String username = msg.getUsername();
		double balance = shopDAO.getBalance(username);
		// modify msgBack
		msgBack.setObj(balance);
		return msgBack;
	}

	private static SocketMessage charge(SocketMessage msg) {
		// init DAO, msg
		ShopDAO shopDAO = new ShopDAO();
		SocketMessage msgBack = new SocketMessage("server", SocketMessage.TYPE.PASSING_DATA);
		// deal with received msg
		String username = msg.getUsername();
		double money = (double)msg.getObj();
		boolean chargeSucceedFlag = shopDAO.addMoney(username, money);
		// modify msgBack
		if(chargeSucceedFlag == true) {
			msgBack.setType(SocketMessage.TYPE.CHARGE_SUCCEED);
		}
		
		return msgBack;
	}

	private static SocketMessage searchShoppingHistory(SocketMessage msg) {
		// init DAO, msg
		SocketMessage msgBack = new SocketMessage("server", SocketMessage.TYPE.PASSING_DATA);
		ShopDAO shopDAO = new ShopDAO();
		// deal with received msg
		String username = msg.getUsername();
		ArrayList<ShoppingInfo> shoppingHistory = shopDAO.getShoppingHistory(username);
		// modify msgBack
		msgBack.setObj(shoppingHistory);
		
		return msgBack;
	}

	private static SocketMessage buyProduct(SocketMessage msg) {
		// init DAO, msg
		SocketMessage msgBack = new SocketMessage("server", SocketMessage.TYPE.PASSING_DATA);
		ShopDAO shopDAO = new ShopDAO();
		// deal with received msg
		String username = msg.getUsername();
		int productID = (int)msg.getObj();
		boolean buySucceedFlag = shopDAO.buyProduct(username, productID);
		// modify msgBack
		if(buySucceedFlag = true) {
			msgBack.setType(SocketMessage.TYPE.BUY_PRODUCT_SUCCEED);
		}
		else {
			msgBack.setType(SocketMessage.TYPE.BUY_PRODUCT_FAIL);
		}
		return msgBack;
	}

	private static SocketMessage searchProduct(SocketMessage msg) {
		// init DAO, msg
		SocketMessage msgBack = new SocketMessage("server", SocketMessage.TYPE.PASSING_DATA);
		ShopDAO shopDAO = new ShopDAO();
		// deal with received msg
		String productName = (String)msg.getObj();
		ArrayList<Product> productList = shopDAO.getProducts(productName);
		// modify msgBack
		msgBack.setObj(productList);
		
		return msgBack;
	}
	

	private static SocketMessage getAllProduct(SocketMessage msg) {
		// init DAO, msg
		SocketMessage msgBack = new SocketMessage("server", SocketMessage.TYPE.PASSING_DATA);
		ShopDAO shopDAO = new ShopDAO();
		// deal with received msg
		ArrayList<Product> productList = shopDAO.getAllProducts();
		// modify msgBack
		msgBack.setObj(productList);

		return msgBack;
	}

	private static SocketMessage getAllCourse(SocketMessage msg) {
		// init DAO, msg
		SocketMessage msgBack = new SocketMessage("server", SocketMessage.TYPE.PASSING_DATA);
		CourseDAO courseDAO = new CourseDAO();
		// deal with received msg
		ArrayList<Course> courseList = courseDAO.getAllCourses();
		// modify msgBack
		msgBack.setObj(courseList);
		
		return msgBack;
	}
	
	private static SocketMessage getCourseTable(SocketMessage msg) {
		// init DAO, msg
		SocketMessage msgBack = new SocketMessage("server", SocketMessage.TYPE.PASSING_DATA);
		CourseDAO courseDAO = new CourseDAO();
		// deal with received msg
		String username = msg.getUsername();
		ArrayList<Course> courseList = courseDAO.getSelectedCourses(username);
		// modify msgBack
		msgBack.setObj(courseList);
		
		return msgBack;
	}

	private static SocketMessage dropCourse(SocketMessage msg) {
		// init DAO, msg
		SocketMessage msgBack = new SocketMessage("server", SocketMessage.TYPE.PASSING_DATA);
		CourseDAO courseDAO = new CourseDAO();
		// deal with received msg
		String username = msg.getUsername();
		int courseUID = (int) msg.getObj();
		boolean dropSucceedFlag = courseDAO.dropCourse(username, courseUID);
		// modify msgBack
		if(dropSucceedFlag == true) {
			msgBack.setType(SocketMessage.TYPE.DROP_COURSE_SUCCEED);
		}else {
			msgBack.setType(SocketMessage.TYPE.DROP_COURSE_FAIL);
		}
		
		return msgBack;
	}

	private static SocketMessage selectCourse(SocketMessage msg) {
		// init DAO, msg
		SocketMessage msgBack = new SocketMessage("server", SocketMessage.TYPE.PASSING_DATA);
		CourseDAO courseDAO = new CourseDAO();
		// deal with received msg
		String username = msg.getUsername();
		int courseUID = (int) msg.getObj();
		boolean selectSucceedFlag = courseDAO.selectCourse(username, courseUID);
		// modify msgBack
		if(selectSucceedFlag == true) {
			msgBack.setType(SocketMessage.TYPE.SELECT_COURSE_SUCCEED);
		}else {
			msgBack.setType(SocketMessage.TYPE.SELECT_COURSE_FAIL);
		}
		
		return msgBack;
	}

	private static SocketMessage searchPersonInfo(SocketMessage msg) {
		// init DAO, msg
		SocketMessage msgBack = new SocketMessage("server", SocketMessage.TYPE.PASSING_DATA);
		InfoDAO infoDAO = new InfoDAO();
		// deal with received msg
		String username = msg.getUsername();
		PersonInfo personInfo = infoDAO.getPersonInfo(username);
		// modify msgBack
		msgBack.setObj(personInfo);
		
		return msgBack;
	}

	private static SocketMessage loginCheck(SocketMessage msg) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		SocketMessage messageBack = new SocketMessage("user", SocketMessage.TYPE.LOGINCHECK);
		LoginDAO loginDAO = new LoginDAO();
		LoginFormEvent loginFormEvent = (LoginFormEvent) msg.getObj();
		boolean loginSucceedFlag = loginDAO.LoginCheck(loginFormEvent);
		// set msg according to the flag
		if (loginSucceedFlag) {
			messageBack.setType(SocketMessage.TYPE.LOGINSUCCEED);
		} else {
			messageBack.setType(SocketMessage.TYPE.LOGINFAIL);
		}

		return messageBack;
	}

	private static SocketMessage register(SocketMessage msg) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		SocketMessage messageBack = new SocketMessage("user", SocketMessage.TYPE.LOGINCHECK);
		LoginDAO loginDAO = new LoginDAO();

		RegisterForm registerForm = (RegisterForm) msg.getObj();
		boolean registerSucceedFlag = loginDAO.Register(registerForm);
		if (registerSucceedFlag) {
			messageBack.setType(SocketMessage.TYPE.REGISTERSUCCEED);
		} else {
			messageBack.setType(SocketMessage.TYPE.REGISTERFAIL);
		}

		return messageBack;
	}
}
