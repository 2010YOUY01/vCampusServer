import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class register extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					register frame = new register();
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
	public register() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 451, 468);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton button = new JButton("\u6CE8\u518C");
		button.setBounds(155, 322, 133, 56);
		contentPane.add(button);
		
		textField = new JTextField();
		textField.setText("\u8F93\u5165\u60A8\u7684\u4E00\u5361\u901A\u53F7");
		textField.setToolTipText("");
		textField.setBounds(170, 121, 172, 29);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setText("\u8F93\u5165\u60A8\u7684\u5B66\u53F7");
		textField_1.setColumns(10);
		textField_1.setBounds(170, 163, 172, 29);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setText("\u8F93\u5165\u5BC6\u7801");
		textField_2.setColumns(10);
		textField_2.setBounds(170, 205, 172, 29);
		contentPane.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setText("\u786E\u8BA4\u5BC6\u7801");
		textField_3.setColumns(10);
		textField_3.setBounds(170, 247, 172, 29);
		contentPane.add(textField_3);
		
		JLabel label = new JLabel("\u4E00\u5361\u901A\u53F7");
		label.setBounds(67, 126, 72, 18);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("\u5B66\u53F7");
		label_1.setBounds(67, 168, 72, 18);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("\u5BC6\u7801");
		label_2.setBounds(67, 210, 72, 18);
		contentPane.add(label_2);
		
		JLabel label_3 = new JLabel("\u786E\u8BA4\u5BC6\u7801");
		label_3.setBounds(67, 252, 72, 18);
		contentPane.add(label_3);
	}
}
