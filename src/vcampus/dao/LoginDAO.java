package vcampus.dao;

import vcampus.vo.LoginFormEvent;
import vcampus.vo.RegisterForm;

//����usernameΪѧ�ţ�ѧ������Ա���У�����Ψһȷ���û����
public class LoginDAO {
	//��֤loginFormEvent����û��������룬��½�ɹ�����true�����򷵻�false
	public boolean LoginCheck(LoginFormEvent loginFormEvent) {
		boolean loginSucceedFlag = false;
		//TODO implement DAO
		if(loginFormEvent.getUsername().equals("admin") && loginFormEvent.getPassword().equals("admin")) {
			loginSucceedFlag = true;
		}
		return loginSucceedFlag;
	}
	
	//ͨ��RegisterForm����û��������룬�û����������ݿ��������û���ע��ɹ�����true�����򷵻�false
	//ע��usernameΪΨһѧ�ţ�������ݿ������ظ�����ע��ʧ��
	public boolean Register(RegisterForm registerForm) {
		boolean registerSucceedFlag = false;
		
		
		return registerSucceedFlag;
	}
	
	//�޸�����
	public boolean changePassword(RegisterForm registerForm) {
		boolean changePswSucceed = true;
		
		
		return changePswSucceed;
	}
	
}
