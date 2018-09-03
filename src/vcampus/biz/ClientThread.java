package vcampus.biz;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import vcampus.vo.SocketMessage;
import vcampus.vo.SocketMessage.TYPE;

public class ClientThread extends Thread {
	private int id;
	private Socket clientSocket;
	private ObjectInputStream ois = null;
	private ObjectOutputStream oos = null;
	private ThreadEndListener threadEndListener;

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
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		boolean runThreadFlag = true;
		while (runThreadFlag) {
			SocketMessage messageReceived = null;
			try {
				messageReceived = (SocketMessage) ois.readObject();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if((messageReceived.getType()) == SocketMessage.TYPE.LOGINCHECK) {
				System.out.println("loginCheck");
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				break;
			}
			else if((messageReceived.getType()) == SocketMessage.TYPE.LOGINSUCCEED){
				System.out.println("other");
			}
			else if((messageReceived.getType()) == SocketMessage.TYPE.LOGINFAIL){
				runThreadFlag = false;
			}

		}
		System.out.println(id+ "out");
		threadEndListener.threadEnd(id);
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

	public void setThreadEndListener(ThreadEndListener threadEndListener) {
		this.threadEndListener = threadEndListener;
	}

	public int getID() {
		return id;
	}
	
	
	
}
