package vcampus.vo;

import java.io.Serializable;


//this file should always be the same as the one in vCampusClient
public class SocketMessage implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -6732448309933765982L;
	//uid to be implemented
	private int uid = 0;
	private String username = "0";
	private int code = 0;
	public enum TYPE{
		LOGINCHECK, LOGINSUCCEED, LOGINFAIL,
		REGISTER, REGISTERSUCCEED, REGISTERFAIL;
	}
	private TYPE type;
	private Object obj = null;
		
	public SocketMessage(String username, TYPE type) {
		this.username = username;
		this.type = type;
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}


	public Object getObj() {
		return obj;
	}

	public void setObj(Object obj) {
		this.obj = obj;
	}

	public TYPE getType() {
		return type;
	}

	public void setType(TYPE type) {
		this.type = type;
	}
	
	
	
}
