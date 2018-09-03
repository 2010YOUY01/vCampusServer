package vcampus.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
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
import java.util.Timer;
import java.awt.event.ActionEvent;

public class ServerGUI extends JFrame {

	private JPanel contentPane;
	private JTextField textOnlineNum;
	private JTextField textIP;
	private JTextField textPort;
	private ServerListener serverListener;
	private JTextArea textArea;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ServerGUI frame = new ServerGUI();
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
	public ServerGUI () {
		setTitle("vCampus Server");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 756, 460);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel label = new JLabel("\u5F53\u524D\u65F6\u95F4");
		
		JLabel label_1 = new JLabel("\u5728\u7EBF\u4EBA\u6570");
		
		JLabel label_2 = new JLabel("\u670D\u52A1\u5668\u5730\u5740");
		
		JLabel label_3 = new JLabel("\u76D1\u542C\u7AEF\u53E3");
		
		textOnlineNum = new JTextField();
		textOnlineNum.setEditable(false);
		textOnlineNum.setColumns(10);
		
		textIP = new JTextField();
		textIP.setEditable(false);
		textIP.setColumns(10);
		
		textPort = new JTextField();
		textPort.setEditable(false);
		textPort.setColumns(10);
		
		JLabel lblServerLog = new JLabel("Server Log");
		
		JScrollPane scrollPane = new JScrollPane();
		
		JButton btnLogin = new JButton("\u542F\u52A8\u670D\u52A1\u5668");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fireLoginServer();
			}
		});
		
		//JLabel timeLabel = new JLabel("New label");
		ClockLabel timeLabel = new ClockLabel("time");
		
		JButton btnLogout = new JButton("\u5173\u95ED\u670D\u52A1\u5668");
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fireLogoutServer();
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(label_2)
								.addComponent(label_3)
								.addComponent(label)
								.addComponent(label_1))
							.addGap(18)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
								.addComponent(textOnlineNum, GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE)
								.addComponent(textPort, GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE)
								.addComponent(textIP, GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE)
								.addComponent(timeLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
							.addGap(71))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(btnLogin)
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(btnLogout)
							.addGap(40)))
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblServerLog)
						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 371, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(51, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(106)
					.addComponent(lblServerLog)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(label)
								.addComponent(timeLabel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(24)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(label_1)
								.addComponent(textOnlineNum, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(label_2)
								.addComponent(textIP, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(label_3)
								.addComponent(textPort, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(33)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(btnLogin)
								.addComponent(btnLogout)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(14)
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 242, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(27, Short.MAX_VALUE))
		);
		
		textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		contentPane.setLayout(gl_contentPane);
	}
	
	public void fireLoginServer() {
		if(this.serverListener == null) {
			System.out.println("nullPtr in fireLoginServer");
		}
		else {
			this.serverListener.LoginServerPerformed();
		}
	}
	
	public void fireLogoutServer() {
		if(this.serverListener == null) {
			System.out.println("nullPtr in fireLogoutServer");
		}
		else {
			this.serverListener.LogoutServerPerformed();
		}
	}


	public void setServerListener(ServerListener serverListener) {
		this.serverListener = serverListener;
	}

	public JTextField getTextOnlineNum() {
		return textOnlineNum;
	}

	public JTextField getTextIP() {
		return textIP;
	}

	public JTextField getTextPort() {
		return textPort;
	}

	public JTextArea getTextArea() {
		return textArea;
	}


	
	
	
	
	
}
