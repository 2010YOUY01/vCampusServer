package vcampus.biz;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import vcampus.util.SocketConnection;
import vcampus.view.ServerGUI;
import vcampus.view.ServerListener;

public class Server implements ThreadListener {
	private static int uID = 0;
	private ArrayList<ClientThread> clientThreadList;
	private int port;
	private String serverIP;
	private boolean runningFlag;
	private ServerGUI serverGUI;
	private ServerSocket serverSocket;
	private static int size = 0;

	// initialize server
	public Server() {
		clientThreadList = new ArrayList<ClientThread>();
		port = SocketConnection.getInstance().getPortNum();
	}

	public void runServer() throws IOException {
		runningFlag = true;

		ServerSocket serverSocket = new ServerSocket(port);
		while (runningFlag) {
			System.out.println("Server wating on port " + port);
			Socket clientSocket = serverSocket.accept();

			// if i asked to stop
			if (!runningFlag) {
				break;
			}
			// use accepted socket to create a new client thread
			System.out.println("dealing with clientSocket");
			ClientThread clientThread = new ClientThread(clientSocket, ++uID);
			size++;
			clientThread.setThreadListener(this);
			// add the thread to list
			clientThreadList.add(clientThread);
			serverGUI.getTextOnlineNum().setText(size + "");
			clientThread.start();
		}

		// close server socket
		// close all client sockets
		serverSocket.close();
		for (int i = 0; i < clientThreadList.size(); i++) {
			ClientThread tmpClientThread = clientThreadList.get(i);
			if (tmpClientThread.getOis() != null) {
				tmpClientThread.getOis().close();
			}
			if (tmpClientThread.getOos() != null) {
				tmpClientThread.getOos().close();
			}
			tmpClientThread.getClientSocket().close();
			tmpClientThread.interrupt();
		}
		serverGUI.getTextOnlineNum().setText(size + "");
		System.out.println("close server");
	}

	public void stopServer() {
		System.out.println("in stop server");
		runningFlag = false;
		Socket s;
		try {
			s = new Socket("localhost", port);
		} catch (UnknownHostException e) {
			System.out.println("unknownhost");
		} catch (IOException e) {
			// System.out.println("ioexception");
		}

	}

	public void setServerGUI(ServerGUI serverGUI) {
		this.serverGUI = serverGUI;
	}

	@Override
	public void threadEnd(int id) {
		for (int i = 0; i < clientThreadList.size(); i++) {
			ClientThread tmpThread = clientThreadList.get(i);
			if (tmpThread.getID() == id) {
				clientThreadList.remove(i);
				serverGUI.getTextOnlineNum().setText(size + "");
				return;
			}
		}
	}

	@Override
	public void displayLog(String log) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("hh:mm:ss");
		Calendar calendar = Calendar.getInstance();
		String time = dateFormat.format(calendar.getTime());
		serverGUI.getTextArea().append(time + log);
	}

}
