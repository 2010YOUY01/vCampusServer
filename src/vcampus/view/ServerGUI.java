package vcampus.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import vcampus.biz.MainServer;
import vcampus.biz.Server;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JScrollBar;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Timer;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.SwingConstants;

public class ServerGUI extends JFrame {

	private JPanel contentPane;
	private JTextField textOnlineNum;
	private JTextField textPort;
	private Server server;
	private JTextArea textArea;
	private JButton btnLogin;
	private JButton btnLogout;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ServerGUI frame = new ServerGUI();
					Server server1 = new Server();
					server1.setServerGUI(frame);
					frame.setServer(server1);
					
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	/**
	 * Create the frame.
	 */
	
	public void createServer() {
		server = new Server();
		server.setServerGUI(this);
	}
	
	public ServerGUI () {
		
		setTitle("vCampus Server");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 777, 507);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblCurrentTime = new JLabel("current time:");
		lblCurrentTime.setForeground(Color.WHITE);
		lblCurrentTime.setFont(new Font("Eras Light ITC", Font.PLAIN, 24));
		lblCurrentTime.setBounds(19, 95, 152, 35);
		
		JLabel lblOnlineNumber = new JLabel("online number:");
		lblOnlineNumber.setFont(new Font("Eras Light ITC", Font.PLAIN, 24));
		lblOnlineNumber.setForeground(Color.WHITE);
		lblOnlineNumber.setBounds(19, 152, 166, 33);
		
		JLabel lblServerStatus = new JLabel("port:");
		lblServerStatus.setFont(new Font("Eras Light ITC", Font.PLAIN, 24));
		lblServerStatus.setForeground(Color.WHITE);
		lblServerStatus.setBounds(19, 205, 152, 35);
		
		textOnlineNum = new JTextField();
		textOnlineNum.setBackground(new Color(34,87,201));
		textOnlineNum.setForeground(Color.WHITE);
		textOnlineNum.setFont(new Font("Eras Light ITC", Font.PLAIN, 24));
		textOnlineNum.setBounds(199, 152, 135, 31);
		textOnlineNum.setEditable(false);
		textOnlineNum.setColumns(10);
		textOnlineNum.setBorder(null);
		
		textPort = new JTextField();
		textPort.setEditable(false);
		textPort.setFont(new Font("Eras Light ITC", Font.PLAIN, 24));
		textPort.setForeground(Color.WHITE);
		textPort.setBackground(new Color(34,87,201));
		textPort.setBounds(199, 205, 135, 32);
		textPort.setColumns(10);
		textPort.setBorder(null);
		
		JLabel lblServerLog = new JLabel("Server Log");
		lblServerLog.setFont(new Font("Eras Light ITC", Font.PLAIN, 20));
		lblServerLog.setForeground(Color.WHITE);
		lblServerLog.setBounds(348, 13, 124, 24);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(348, 50, 371, 242);
		
		btnLogin = new JButton("");
		btnLogin.setIcon(new ImageIcon(ServerGUI.class.getResource("/material/\u5F00\u542F\u670D\u52A1\u5668.png")));
		btnLogin.setBounds(96, 358, 196, 64);
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// OK start the server
				// ceate a new Server
				createServer();
				// and start it as a thread
				new ServerRunning().start();
				btnLogin.setEnabled(false);
				btnLogout.setEnabled(true);
			}
		});
		
		btnLogout = new JButton("");
		btnLogout.setIcon(new ImageIcon(ServerGUI.class.getResource("/material/\u5173\u95ED\u670D\u52A1\u5668.png")));
		btnLogout.setBounds(453, 358, 196, 64);
		btnLogout.setEnabled(false);
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				server.stopServer();
				server = null;
				btnLogin.setEnabled(true);
				btnLogout.setEnabled(false);
				return;
			}
		});
		
		textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		contentPane.setLayout(null);
		
		
		
		//JLabel timeLabel = new JLabel("New label");
		ClockLabel timeLabel = new ClockLabel("time");
		timeLabel.setFont(new Font("ººÒÇÏ¸Ô²¼ò", Font.PLAIN, 24));
		timeLabel.setBounds(162, 95, 183, 40);
		timeLabel.setForeground(Color.WHITE);
		timeLabel.setHorizontalAlignment(SwingConstants.LEADING);
		contentPane.add(timeLabel);
		contentPane.add(lblCurrentTime);
		contentPane.add(lblOnlineNumber);
		contentPane.add(lblServerStatus);
		contentPane.add(textOnlineNum);
		contentPane.add(textPort);
		contentPane.add(lblServerLog);
		contentPane.add(scrollPane);
		contentPane.add(btnLogin);
		contentPane.add(btnLogout);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setVerticalAlignment(SwingConstants.BOTTOM);
		lblNewLabel.setIcon(new ImageIcon(ServerGUI.class.getResource("/material/\u540E\u53F0\u80CC\u666F.png")));
		lblNewLabel.setBounds(0, 0, 759, 334);
		contentPane.add(lblNewLabel);
		
		getTextOnlineNum().setText(0+"");
	}
	


	public JTextField getTextOnlineNum() {
		return textOnlineNum;
	}



	public JTextField getTextPort() {
		return textPort;
	}

	public JTextArea getTextArea() {
		return textArea;
	}
	
	


	public void setServer(Server server) {
		this.server = server;
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
