package vcampus.biz;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

import vcampus.util.SocketConnection;
import vcampus.vo.LoginFormEvent;
import vcampus.vo.SocketMessage;

public class LoginBiz {
	public static void runServer() throws IOException, ClassNotFoundException {
		SocketConnection socketConnection = SocketConnection.getInstance();
		socketConnection.initServerSocket();
		ObjectInputStream ois = null;
		
		try {
			// start listening on port 
			ServerSocket serverSocket = socketConnection.getServerSocket();
			System.out.println(serverSocket + "start listening");
			
			//keep listening on port
			while(true) {
				final Socket clientSocket = serverSocket.accept();
				Thread t = new Thread() {
					@Override
					public void run() {
						try {
							handleClientSocket(clientSocket);
						} catch (IOException | InterruptedException e) {
							e.printStackTrace();
						} catch (ClassNotFoundException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				};
				t.start();
				
			}


			} catch (IOException e) {
			e.printStackTrace();
			System.exit(-1);
			} catch (Exception e) {
			e.printStackTrace();
			System.exit(-1);
			}
	}

	private static void handleClientSocket(Socket clientSocket) throws IOException, ClassNotFoundException, InterruptedException {
		ObjectInputStream ois;
		ois = new ObjectInputStream(clientSocket.getInputStream());
		SocketMessage messageReceived = (SocketMessage) ois.readObject();
		LoginFormEvent login = (LoginFormEvent) messageReceived.getObj();
		
		//login check
		boolean loginSucceedFlag = false;
		if(login.getUsername().equals("admin") && login.getPassword().equals("admin")) {
			loginSucceedFlag = true;
		}else {
			loginSucceedFlag = false;
		}
		PrintStream printStream = new PrintStream(clientSocket.getOutputStream());
		printStream.print(loginSucceedFlag);
		for(int i=0; i<5; i++) {
			System.out.println(i);
			Thread.sleep(3000);
		}
		//login check
		
		
		//TODO close client socket
		clientSocket.close();
	}
}
