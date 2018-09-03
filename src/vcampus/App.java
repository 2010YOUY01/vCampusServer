package vcampus;

import java.io.IOException;

import vcampus.biz.MainServer;

public class App {
	public static void main(String[] args) throws IOException {
		MainServer mainServer = new MainServer();
		mainServer.start();
	}
	
}
