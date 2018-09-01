package vcampus;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

import vcampus.biz.LoginBiz;
import vcampus.util.SocketConnection;
import vcampus.vo.LoginFormEvent;



public class serverTest {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		LoginBiz login = new LoginBiz();
		login.runServer();
	}
	
	
}
