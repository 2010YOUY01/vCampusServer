package vcampus.biz;

import java.io.IOException;
import java.net.UnknownHostException;


public class ServerTest {
	Server server;
	public static void main(String[] args) throws UnknownHostException, IOException, InterruptedException {
		ServerTest serverTest = new ServerTest();
		serverTest.toggleRun();
		Thread.sleep(5000);
		serverTest.toggleRun();
		Thread.sleep(5000);
		serverTest.toggleRun();
		Thread.sleep(3000);
		serverTest.toggleRun();
	}
	
	public void toggleRun() throws UnknownHostException, IOException {
		// if running we have to stop
				if(server != null) {
					server.stopServer();
					server = null;
					return;
				}
		      	// OK start the server
				// ceate a new Server
				server = new Server();
				// and start it as a thread
				new ServerRunning().start();
	}
	
	class ServerRunning extends Thread {
		public void run() {
			try {
				server.runServer();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}         // should execute until if fails
			// the server failed
			System.out.println("server failed");
			server = null;
		}
	}
}
