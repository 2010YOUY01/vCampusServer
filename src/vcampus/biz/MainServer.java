package vcampus.biz;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

import vcampus.util.SocketConnection;
import vcampus.view.ServerGUI;
import vcampus.view.ServerListener;
import vcampus.vo.*;


public class MainServer implements ThreadEndListener ,ServerListener{
	private static int uID = 0;
	private ArrayList<ClientThread> clientThreadList;
	private int port;
	private String serverIP;
	private boolean runningFlag;
	private ServerGUI serverGUI;
	
	
	public MainServer() {
		//this.port = port;
		clientThreadList = new ArrayList<ClientThread>();
		port = SocketConnection.getInstance().getPortNum();
	}
	
	public void start() throws IOException {
		runningFlag = true;
		SocketConnection socketConnection = SocketConnection.getInstance();
		socketConnection.initServerSocket();
		ServerSocket serverSocket = socketConnection.getServerSocket();
		while(runningFlag) {
			Socket clientSocket = serverSocket.accept();
			if(!runningFlag)
				break;
			//TODO handle client socket
			ClientThread clientThread = new ClientThread(clientSocket, ++uID);		
			clientThread.setThreadEndListener(this); //this object is the listener of thread
			clientThread.start();
			clientThreadList.add(clientThread);
		}
		
		serverSocket.close();
	}
	
	public void closeServer() {
		runningFlag = false;
	}

	@Override
	public void threadEnd(int id) {
		for(int i=0; i<clientThreadList.size(); i++) {
			ClientThread tmpThread = clientThreadList.get(i);
			if(tmpThread.getID() == id) {
				clientThreadList.remove(i);
				return;
			}
		}
		
	}

	@Override
	public void LoginServerPerformed() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void LogoutServerPerformed() {
		// TODO Auto-generated method stub
		
	}


	public void setServerGUI(ServerGUI serverGUI) {
		this.serverGUI = serverGUI;
	}
	
	
	
	
}
	
	
	

