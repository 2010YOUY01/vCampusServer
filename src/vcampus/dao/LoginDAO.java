package vcampus.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import vcampus.util.DataConnection;
import vcampus.vo.LoginFormEvent;
import vcampus.vo.RegisterForm;

//其中username为学号，学生管理员都有，用于唯一确认用户身份
public class LoginDAO{
	//验证loginFormEvent里的用户名与密码，登陆成功返回true，否则返回false
	public boolean LoginCheck(LoginFormEvent loginFormEvent) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		boolean loginSucceedFlag = false;
	    Connection conn=DataConnection.getConnection();
	    PreparedStatement ps=null;
	    ResultSet rs=null;
	    try {
	        String sql="select * from  tbUser where userID=?";
	        ps=conn.prepareStatement(sql);
	        ps.setString(1,((vcampus.vo.LoginFormEvent) loginFormEvent).getUsername());
	        rs=ps.executeQuery();
	        while(rs.next()) {
	        	if(rs.getString("userID").equals(((vcampus.vo.LoginFormEvent) loginFormEvent).getUsername())) {
	        		if(rs.getString("userPassword").equals(((vcampus.vo.LoginFormEvent) loginFormEvent).getPassword())) {
	        			loginSucceedFlag=true;
	        		}
	        	}
	    	}
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    finally {
	        try {
	            if(rs!=null) {
	                rs.close();
	            }
	            if(ps!=null) {
	                ps.close();
	            }
	            if(conn!=null) {
	                conn.close();
	            }
	        }catch(Exception ee) {
	            ee.printStackTrace();
	        }
	       }
		return loginSucceedFlag;
	}
	
	public boolean userCheck(LoginFormEvent loginFormEvent) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		boolean checkSucceedFlag = false;
	    Connection conn=DataConnection.getConnection();
	    PreparedStatement ps=null;
	    ResultSet rs=null;
	    try {
	        String sql="select * from  tbUser where userID=?";
	        ps=conn.prepareStatement(sql);
	        ps.setString(1,((vcampus.vo.LoginFormEvent) loginFormEvent).getUsername());
	        rs=ps.executeQuery();
	        while(rs.next()) {
	        	if(rs.getString("userID").equals(((vcampus.vo.LoginFormEvent) loginFormEvent).getUsername())) {
	        	checkSucceedFlag=true;
	        	}
	    	}
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    finally {
	        try {
	            if(rs!=null) {
	                rs.close();
	            }
	            if(ps!=null) {
	                ps.close();
	            }
	            if(conn!=null) {
	                conn.close();
	            }
	        }catch(Exception ee) {
	            ee.printStackTrace();
	        }
	       }
		return checkSucceedFlag;
	}
	//通过RegisterForm里的用户名，密码，用户姓名在数据库里新增用户，注册成功返回true，否则返回false
	//注意username为唯一学号，如果数据库中有重复，则注册失败
	@SuppressWarnings("null")
	public boolean Register(RegisterForm registerForm) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		boolean registerSucceedFlag = false;
		 Connection conn=DataConnection.getConnection();
		    PreparedStatement ps=null;
		    LoginFormEvent loginForm=new LoginFormEvent("null","null");
		    ((vcampus.vo.LoginFormEvent) loginForm).setUsername(registerForm.getName());
		    ((vcampus.vo.LoginFormEvent) loginForm).setPassword(registerForm.getPassword());
		    if(userCheck(loginForm)==false) {
		    String sql="insert into tbUser (userID,userPassword,userName) "+"values(?,?,?)";
		    ps=conn.prepareStatement(sql);
		    try { ps.setString(1,registerForm.getUserName());
		    ps.setString(2,registerForm.getPassword());
		    ps.setString(3,registerForm.getName());
		    registerSucceedFlag=true;
		     int a=ps.executeUpdate();
	        if(a>0) {
	        	 return true;
	        }else {
	        	 return false;
	        }
	    }
	   catch (Exception e) {
	        e.printStackTrace();
	    }
	   finally {
	        try {

	            if(ps!=null) {
	                ps.close();
	            }
	            if(conn!=null) {
	                conn.close();
	            }
	        }catch(Exception ee) {
	            ee.printStackTrace();
	        }
	        }
	   return true;
		    }
		   else {
			   return false;
		   }
	}
	
	//修改密码
	@SuppressWarnings("null")
	public boolean changePassword(RegisterForm registerForm,String newPassword) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		boolean changePswSucceed = true;
		 Connection conn=DataConnection.getConnection();
		    PreparedStatement ps=null;
		    String sql="update tbUser set userPassword=?"+" where userID=?";
		    LoginFormEvent loginForm=new LoginFormEvent("null","null");
		    loginForm.setUsername(registerForm.getName());
		   loginForm.setPassword(registerForm.getPassword());
		    
		    if(userCheck(loginForm)==true) {
		    try {
		        ps=conn.prepareStatement(sql);
		        ps.setString(1,newPassword);
		        ps.setString(2,((vcampus.vo.LoginFormEvent)loginForm).getUsername());
		        int a=ps.executeUpdate();
		        if(a>0) {
		        	 return true;
		        }else {
		        	return false;
		        }
		    } catch (Exception e) {
		        e.printStackTrace();
		    }finally {
		        try {

		            if(ps!=null) {
		                ps.close();
		            }
		            if(conn!=null) {
		                conn.close();
		            }
		        }catch(Exception ee) {
		            ee.printStackTrace();
		        }
		        }
		    return true;
		    }
		    else return changePswSucceed;
	}
	
}
