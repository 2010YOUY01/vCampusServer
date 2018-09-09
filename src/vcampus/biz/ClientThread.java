package vcampus.biz;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.sql.SQLException;

import vcampus.dao.LoginDAO;
import vcampus.vo.LoginFormEvent;
import vcampus.vo.SocketMessage;
import vcampus.vo.SocketMessage.TYPE;

public class ClientThread extends Thread {
	private int id;
	private Socket clientSocket;
	private ObjectInputStream ois = null;
	private ObjectOutputStream oos = null;
	private ThreadListener threadListener;
	private boolean runThreadFlag;
	public ClientThread(Socket clientSocket, int id) throws IOException {
		this.clientSocket = clientSocket;
		this.id = id;
	}

	// handle different kinds of messages in run
	@Override
	public void run() {
		System.out.println(id+ "in");
		try {
			ois = new ObjectInputStream(clientSocket.getInputStream());
			oos = new ObjectOutputStream(clientSocket.getOutputStream());
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		SocketMessage messageReceived = null;
		SocketMessage messageBack = null;
		runThreadFlag = true;
		while (runThreadFlag) {
			try {
				//read message Obj from socket
				messageReceived = (SocketMessage) ois.readObject();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			
			
			try {
				messageBack = MessageHandling.handleMessage(messageReceived);
			} catch (InstantiationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			
			
			//send back the msg
			try {
					oos.writeObject(messageBack);
				
				
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			break;
		}
		
		
		System.out.println(id+ "out");
		threadListener.threadEnd(id);
		try {
			if(ois != null)
				ois.close();
			if(oos != null)
				oos.close();
			clientSocket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		

		
	}

	public void setThreadListener(ThreadListener threadListener) {
		this.threadListener = threadListener;
	}
	
	public void stopThread() {
		this.runThreadFlag = false;
	}

	public int getID() {
		return id;
	}

	public Socket getClientSocket() {
		return clientSocket;
	}


	public ObjectInputStream getOis() {
		return ois;
	}


	public ObjectOutputStream getOos() {
		return oos;
	}

	
	
	
	
}
