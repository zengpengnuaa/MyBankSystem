package admin;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Color;

public class AddOperator {
  
	
	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddOperator window = new AddOperator();
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
	
	public AddOperator() {
		initialize();
	}
	
	private void initialize() {
		
		frame = new JFrame();
		frame.getContentPane().setBackground(SystemColor.control);
		frame.setTitle("注册职员");
		frame.setBounds(400, 200, 450, 400);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JTextPane textPane = new JTextPane();
		textPane.setBackground(SystemColor.control);
		textPane.setFont(new Font("宋体", Font.PLAIN, 22));
		textPane.setText(" 用户名");
		textPane.setBounds(45, 42, 93, 42);
		frame.getContentPane().add(textPane);
		
		textField = new JTextField();
		textField.setBounds(148, 42, 178, 42);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(148, 94, 178, 44);
		frame.getContentPane().add(passwordField);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(148, 148, 178, 42);
		frame.getContentPane().add(passwordField_1);
		
		textField_1 = new JTextField();
		textField_1.setBounds(148, 202, 178, 42);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JTextPane textPane_1 = new JTextPane();
		textPane_1.setBackground(SystemColor.control);
		textPane_1.setFont(new Font("宋体", Font.PLAIN, 22));
		textPane_1.setForeground(new Color(0, 0, 0));
		textPane_1.setText(" 密码");
		textPane_1.setBounds(55, 94, 85, 44);
		frame.getContentPane().add(textPane_1);
		
		JTextPane textPane_2 = new JTextPane();
		textPane_2.setBackground(SystemColor.control);
		textPane_2.setFont(new Font("宋体", Font.PLAIN, 22));
		textPane_2.setText("确认密码");
		textPane_2.setBounds(45, 148, 105, 42);
		frame.getContentPane().add(textPane_2);
		
		JTextPane textPane_3 = new JTextPane();
		textPane_3.setBackground(SystemColor.control);
		textPane_3.setFont(new Font("宋体", Font.PLAIN, 22));
		textPane_3.setText(" 职员等级");
		textPane_3.setBounds(45, 202, 125, 42);
		frame.getContentPane().add(textPane_3);
		
		JButton btnNewButton = new JButton("注册");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = textField.getText();
				char[] password =passwordField.getPassword();
				String psw=new String(password);
				char[] password1 =passwordField_1.getPassword();
				String psw1=new String(password1);
				String grade =textField_1.getText();
				int g=Integer.parseInt(grade); 
				try {
					String str=AdminSystem.addOperator(name, psw, psw1,g);
					if(str!=null) {
						JOptionPane.showMessageDialog(btnNewButton,"注册成功，职工号为"+str);
						
					}
					else 
						JOptionPane.showMessageDialog(btnNewButton,"错误，请重新输入！","Error", JOptionPane.ERROR_MESSAGE);
						textField.setText("");
						passwordField.setText("");
						passwordField_1.setText("");
				}
					catch (Exception e1) {
						e1.printStackTrace();
					}
				}
			});
	btnNewButton.setBounds(172, 253, 111, 38);
	frame.getContentPane().add(btnNewButton);
	}
}
