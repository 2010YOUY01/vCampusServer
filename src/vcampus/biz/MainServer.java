package vcampus.biz;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;

import vcampus.util.SocketConnection;
import vcampus.view.ServerGUI;
import vcampus.view.ServerListener;
import vcampus.vo.*;


public class MainServer  implements ThreadListener ,ServerListener{
	private static int uID = 0;
	private ArrayList<ClientThread> clientThreadList;
	private int port;
	private String serverIP;
	private boolean runningFlag;
	private ServerGUI serverGUI;
	private ServerSocket serverSocket;
	
	public static void main(String[] args) throws InterruptedException, UnknownHostException, IOException {
		MainServer mainServer = new MainServer();
		mainServer.start();

		mainServer.closeServer();
	}
	public MainServer() {
		//this.port = port;
		clientThreadList = new ArrayList<ClientThread>();
		port = SocketConnection.getInstance().getPortNum();
		SocketConnection socketConnection = SocketConnection.getInstance();
		socketConnection.initServerSocket();
		this.serverSocket = socketConnection.getServerSocket();
	}
	public void start() {
		System.out.println("server started");
		runningFlag = true;
		while(runningFlag) {
			Socket clientSocket = null;
			try {
				clientSocket = this.serverSocket.accept();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(!runningFlag)
				break;
			//TODO handle client socket
			ClientThread clientThread = null;
			try {
				clientThread = new ClientThread(clientSocket, ++uID);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			clientThread.setThreadEndListener(this); //this object is the listener of thread
			clientThreadList.add(clientThread);
			serverGUI.getTextOnlineNum().setText(clientThreadList.size()+"");
			clientThread.start();
			
		}
		
		try {
			System.out.println("trying to exit");
			serverSocket.close();
			
			return;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("at the end of server thread");
		return;
	}
	public void startServer()  throws IOException {
		
	}
	
	public void closeServer() throws UnknownHostException, IOException {
		System.out.println("in closeServer");
		runningFlag = false;
		new Socket("localhost", this.port);
		clientThreadList.clear();
	}
	@Override
	public void threadEnd(int id) {
		for(int i=0; i<clientThreadList.size(); i++) {
			ClientThread tmpThread = clientThreadList.get(i);
			if(tmpThread.getID() == id) {
				clientThreadList.remove(i);
				serverGUI.getTextOnlineNum().setText(clientThreadList.size()+"");
				return;
			}
		}
		
	}

	@Override
	public void LoginServerPerformed() {
		serverGUI.getTextOnlineNum().setText(clientThreadList.size()+"");
		serverGUI.getTextPort().setText(SocketConnection.getInstance().getPortNum()+"");
		this.start();
		
		//set LogInfo
		System.out.println("Server started. Port: " + port);
	}

	@Override
	public void LogoutServerPerformed() {
		try {
			this.closeServer();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("server closed");
		serverGUI.getTextOnlineNum().setText(clientThreadList.size()+"");
	}


	public void setServerGUI(ServerGUI serverGUI) {
		this.serverGUI = serverGUI;
	}
	
	
	
	
}
	
	
	

