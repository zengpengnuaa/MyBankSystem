package bank.system;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextPane;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.SystemColor;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;


public class Withdraw {
	JFrame frame;
	private JTextField textField;
	private JTextField textField_2;
	private JPasswordField passwordField;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Withdraw window = new Withdraw();
					window.frame.setVisible(true);
				}catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public JFrame getFrame() {
		return frame;
	}
	public Withdraw(){
		initialize();
	}
	
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("ȡ ��");
		frame.setBounds(400, 200, 450, 300);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JTextPane textPane = new JTextPane();
		textPane.setBackground(SystemColor.control);
		textPane.setFont(new Font("����", Font.PLAIN, 22));
		textPane.setText(" �˺�");
		textPane.setBounds(37, 37, 116, 45);
		frame.getContentPane().add(textPane);
		
		textField = new JTextField();
		textField.setBounds(176, 37, 186, 45);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JTextPane textPane_1 = new JTextPane();
		textPane_1.setFont(new Font("����", Font.PLAIN, 22));
		textPane_1.setText(" ����");
		textPane_1.setBackground(SystemColor.control);
		textPane_1.setBounds(38, 102, 115, 45);
		frame.getContentPane().add(textPane_1);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(176, 102, 186, 45);
		frame.getContentPane().add(passwordField);
		
		JTextPane textPane_2 = new JTextPane();
		textPane_2.setBackground(SystemColor.control);
		textPane_2.setFont(new Font("����", Font.PLAIN, 22));
		textPane_2.setText(" ȡ����");
		textPane_2.setBounds(37, 170, 116, 45);
		frame.getContentPane().add(textPane_2);
		
		textField_2 = new JTextField();
		textField_2.setBounds(178, 170, 184, 45);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		JButton btnNewButton = new JButton("ȷ��");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String num = textField.getText();
				char[] password =passwordField.getPassword();
				String psw=new String(password);
				try {
					float money =Float.parseFloat(textField_2.getText());
					boolean bl=BankSystem.accountBalance(num,money);
					if(bl==false) {
						JOptionPane.showMessageDialog(btnNewButton,"����������˻�������");
						textField_2.setText("");
					}
					else {
						boolean b =BankSystem.withdraw(num,psw,money);
						if(b==true) {
							JOptionPane.showMessageDialog(btnNewButton, "ȡ��ɹ������պ������ֽ�");
							textField_2.setText("");
							passwordField.setText("");
							textField.setText("");
						}
						else {
							JOptionPane.showMessageDialog(btnNewButton, "�������,����������","Error",JOptionPane.ERROR_MESSAGE);
							passwordField.setText("");
						}
					}
				}catch(Exception e1) {
					JOptionPane.showMessageDialog(btnNewButton, "�����ȡ������������֣�","Error",JOptionPane.ERROR_MESSAGE);
					textField_2.setText("");
				}
			}
		});
		btnNewButton.setBounds(131, 225, 115, 36);
		frame.getContentPane().add(btnNewButton);
	}
}