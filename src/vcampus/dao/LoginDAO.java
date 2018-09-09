package vcampus.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import vcampus.util.DataConnection;
import vcampus.vo.LoginFormEvent;
import vcampus.vo.RegisterForm;

//����usernameΪѧ�ţ�ѧ������Ա���У�����Ψһȷ���û����
public class LoginDAO{
	//��֤loginFormEvent����û��������룬��½�ɹ�����true�����򷵻�false
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
	//ͨ��RegisterForm����û��������룬�û����������ݿ��������û���ע��ɹ�����true�����򷵻�false
	//ע��usernameΪΨһѧ�ţ�������ݿ������ظ�����ע��ʧ��
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
	
	//�޸�����
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
