package vcampus.dao;

import vcampus.vo.LoginFormEvent;
import vcampus.vo.RegisterForm;

//其中username为学号，学生管理员都有，用于唯一确认用户身份
public class LoginDAO {
	//验证loginFormEvent里的用户名与密码，登陆成功返回true，否则返回false
	public boolean LoginCheck(LoginFormEvent loginFormEvent) {
		boolean loginSucceedFlag = false;
		//TODO implement DAO
		if(loginFormEvent.getUsername().equals("admin") && loginFormEvent.getPassword().equals("admin")) {
			loginSucceedFlag = true;
		}
		return loginSucceedFlag;
	}
	
	//通过RegisterForm里的用户名，密码，用户姓名在数据库里新增用户，注册成功返回true，否则返回false
	//注意username为唯一学号，如果数据库中有重复，则注册失败
	public boolean Register(RegisterForm registerForm) {
		boolean registerSucceedFlag = false;
		
		
		return registerSucceedFlag;
	}
}
