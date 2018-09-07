package vcampus.vo;

import java.io.Serializable;

public class RegisterForm implements Serializable{
	private String userName;
	private String password;
	private String repeatPassword;
	private String name;
	public RegisterForm(String userName, String password, String repeatPassword, String name) {
		super();
		this.userName = userName;
		this.password = password;
		this.repeatPassword = repeatPassword;
		this.name = name;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRepeatPassword() {
		return repeatPassword;
	}
	public void setRepeatPassword(String repeatPassword) {
		this.repeatPassword = repeatPassword;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	
	
	
	
}
