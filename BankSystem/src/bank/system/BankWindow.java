package bank.system;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;

import admin.Login;

import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Window;

public class BankWindow {
	private JFrame frame;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BankWindow window = new BankWindow();
					window.frame.setVisible(true);
				}catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public BankWindow() {
		initialize();
	}
	
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("���д���ϵͳ");
		frame.setForeground(Color.DARK_GRAY);
		frame.getContentPane().setFont(new Font("΢���ź�", Font.BOLD, 16));
		frame.getContentPane().setForeground(new Color(0, 0, 0));
		frame.getContentPane().setBackground(SystemColor.control);
		frame.setFont(null);
		frame.setBackground(Color.GRAY);
		frame.setBounds(400, 250, 450, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JButton btnNewButton = new JButton("��    ��");
		btnNewButton.setBounds(10, 83, 175, 33);
		btnNewButton.setBackground(SystemColor.control);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					OpenAccount window = new OpenAccount();
					window.getFrame().setVisible(true);
				}catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("��    ��");
		btnNewButton_1.setBounds(10, 155, 175, 33);
		btnNewButton_1.setForeground(new Color(0, 0, 0));
		btnNewButton_1.setBackground(SystemColor.control);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Deposite window = new Deposite();
				window.getFrame().setVisible(true);
			}
		});
		frame.getContentPane().add(btnNewButton_1);
		
		JButton button = new JButton("ȡ    ��");
		button.setBounds(10, 220, 175, 33);
		button.setBackground(SystemColor.control);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Withdraw window = new Withdraw();
				window.getFrame().setVisible(true);
			}
		});
		frame.getContentPane().add(button);
		
		JButton btnNewButton_2 = new JButton("ת    ��");
		btnNewButton_2.setBounds(249, 157, 175, 29);
		btnNewButton_2.setBackground(SystemColor.control);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Transfer window =new  Transfer();
				window.getFrame().setVisible(true);
			}
		});
		frame.getContentPane().add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("��    ��");
		btnNewButton_3.setBounds(249, 222, 178, 29);
		btnNewButton_3.setBackground(SystemColor.control);
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login window=new Login();
				window.getFrame().setVisible(true);
				frame.setVisible(false);
			}
		});
		frame.getContentPane().add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("��   ѯ");
		btnNewButton_4.setBounds(249, 83, 175, 33);
		btnNewButton_4.setBackground(SystemColor.control);
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Inquiry window = new Inquiry();
					window.getFrame().setVisible(true);
				}catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		frame.getContentPane().add(btnNewButton_4);
		
		JTextPane textPane = new JTextPane();
		textPane.setBounds(80, 20, 298, 33);
		frame.getContentPane().add(textPane);
		textPane.setFont(new Font("����", Font.BOLD, 14));
		textPane.setBackground(SystemColor.control);
		textPane.setText("��ӭʹ�����д���ϵͳ����ѡ���������");
		
		JTextPane textPane_1 = new JTextPane();
		textPane_1.setForeground(new Color(0, 0, 0));
		textPane_1.setBackground(SystemColor.control);
		textPane_1.setText("   �����������й�Ա��¼");
		textPane_1.setBounds(143, 52, 250, 21);
		frame.getContentPane().add(textPane_1);
	}
	public JFrame getFrame() {
		return frame;
	}
}
