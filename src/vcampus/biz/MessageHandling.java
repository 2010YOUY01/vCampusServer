package vcampus.biz;

import vcampus.dao.LoginDAO;
import vcampus.vo.LoginFormEvent;
import vcampus.vo.RegisterForm;
import vcampus.vo.SocketMessage;

public class MessageHandling {
	public static SocketMessage handleMessage(SocketMessage msg) {
		SocketMessage messageBack = new SocketMessage("0",SocketMessage.TYPE.LOGINCHECK);
		LoginDAO loginDAO = new LoginDAO();
		switch(msg.getType()) {
		case LOGINCHECK:
			LoginFormEvent loginFormEvent = (LoginFormEvent) msg.getObj();
			boolean loginSucceedFlag = loginDAO.LoginCheck(loginFormEvent);
			//set msg according to the flag
			if(loginSucceedFlag) {
				messageBack.setType(SocketMessage.TYPE.LOGINSUCCEED);
			}
			else {
				messageBack.setType(SocketMessage.TYPE.LOGINFAIL);
			}
			break;
		case REGISTER:
			RegisterForm registerForm = (RegisterForm) msg.getObj();
			boolean registerSucceedFlag = loginDAO.Register(registerForm);
			if(registerSucceedFlag) {
				messageBack.setType(SocketMessage.TYPE.REGISTERSUCCEED);
			}
			else {
				messageBack.setType(SocketMessage.TYPE.REGISTERFAIL);
			}
			
			break;
		}
		
		return messageBack;
	}
}
