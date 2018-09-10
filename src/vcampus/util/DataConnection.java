package vcampus.util;

import java.sql.Connection; 

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet; 
import java.sql.Statement; 

public class DataConnection {
public static Connection getConnection() throws InstantiationException, IllegalAccessException, ClassNotFoundException {
	 try{
		 Class.forName("com.hxtt.sql.access.AccessDriver").newInstance();
		 Connection conn = DriverManager.getConnection("jdbc:Access:///./eCampus.accdb","","");
	     return conn; 
	 }
	 catch(Exception e){}
	 return null; 
	 }
	public static void main(String[] args) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		Connection conn=DataConnection.getConnection();
		    System.out.println(conn);
	}
}
