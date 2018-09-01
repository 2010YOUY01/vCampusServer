package vcampus.vo;

import java.io.Serializable;

public class SocketMessage implements Serializable{
	//uid to be implemented
	private int uid = 0;
	private int code = 0;
	public enum TYPE{
		LOGINCHECK, LOGINSUCCEED, LOGINFAIL;
	}
	private TYPE type;
	private Object obj = null;
		
	public SocketMessage() {

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
