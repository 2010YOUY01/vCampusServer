package vcampus.util;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketConnection {
	static SocketConnection obj = new SocketConnection();
	private int portNum = 8308;
	private String serverAddress = "127.0.0.1";
	private ServerSocket serverSocket = null;
	private Socket socket = null;
	
	private SocketConnection() {
	}
	
	public void initSocket() {
		try {
			socket = new Socket(serverAddress, portNum);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void initServerSocket() {
		try {
			serverSocket = new ServerSocket(portNum);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void closeSocket() {
		try {
			socket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void closeServerSocket() {
		try {
			serverSocket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static SocketConnection getInstance() {
		return obj;
	}

	public ServerSocket getServerSocket() {
		return serverSocket;
	}
	
	public Socket getSocket() {
		return socket;
	}

	public int getPortNum() {
		return portNum;
	}

	public void setPortNum(int portNum) {
		this.portNum = portNum;
	}

	public String getServerAddress() {
		return serverAddress;
	}

	public void setServerAddress(String serverAddress) {
		this.serverAddress = serverAddress;
	}
	
	

	
	
	
	
	
}
