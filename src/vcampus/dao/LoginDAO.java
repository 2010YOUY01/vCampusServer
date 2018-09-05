package vcampus.dao;

import vcampus.vo.LoginFormEvent;

public class LoginDAO {
	public boolean LoginCheck(LoginFormEvent loginFormEvent) {
		boolean loginSucceedFlag = false;
		//TODO implement DAO
		if(loginFormEvent.getUsername().equals("admin") && loginFormEvent.getPassword().equals("admin")) {
			loginSucceedFlag = true;
		}
		return loginSucceedFlag;
	}
}
