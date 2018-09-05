import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;

import java.util.Date;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JTextPane;
import javax.swing.JTextArea;
import javax.swing.JScrollBar;
import javax.swing.DropMode;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

import javax.swing.Timer;

public class background extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					background frame = new background();
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
	public background() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 685, 426);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton button = new JButton("\u5F00\u542F\u670D\u52A1\u5668");
		button.setBounds(100, 298, 163, 40);
		contentPane.add(button);
		
		JButton button_1 = new JButton("\u5173\u95ED\u670D\u52A1\u5668");
		button_1.setBounds(372, 298, 163, 40);
		contentPane.add(button_1);
		
		JLabel label = new JLabel("\u5F53\u524D\u65F6\u95F4\uFF1A");
		label.setFont(new Font("宋体", Font.PLAIN, 18));
		label.setBounds(63, 68, 109, 24);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("\u670D\u52A1\u5668\u72B6\u6001\uFF1A");
		label_1.setFont(new Font("宋体", Font.PLAIN, 18));
		label_1.setBounds(63, 116, 109, 24);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("\u5728\u7EBF\u4EBA\u6570\uFF1A");
		label_2.setFont(new Font("宋体", Font.PLAIN, 18));
		label_2.setBounds(63, 163, 109, 24);
		contentPane.add(label_2);
		
		JLabel label_times = new JLabel("\u65F6\u95F4");
		label_times.setFont(new Font("宋体", Font.PLAIN, 18));
		label_times.setBounds(169, 68, 72, 24);
		contentPane.add(label_times);
		
		//DatePicker datePicker=new DatePicker(new Date(),"yyyy-MM-dd",
				//new Font("Times New Roman",Font.BOLD,14),new Dimension(120,24));
		//date
		
		JLabel label_status = new JLabel("\u5F00\u542F");
		label_status.setFont(new Font("宋体", Font.PLAIN, 18));
		label_status.setBounds(169, 121, 72, 19);
		contentPane.add(label_status);
		
		JLabel label_person = new JLabel("1");
		label_person.setFont(new Font("宋体", Font.PLAIN, 18));
		label_person.setBounds(169, 168, 72, 18);
		contentPane.add(label_person);
		
		JTextArea tip = new JTextArea();
		tip.setText("1111\r\n22222\r\n3333\r\n44444\r\n55555\r\n66666\r\n77777\r\n888\r\n");
		tip.setLineWrap(true);
		JScrollPane text2=new JScrollPane(tip);
		text2.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		text2.setSize(199, 143);
		text2.setLocation(356, 70);
		text2.setViewportView(tip);
		contentPane.add(text2);
	}
}
