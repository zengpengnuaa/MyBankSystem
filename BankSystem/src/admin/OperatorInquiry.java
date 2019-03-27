package admin;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JTextPane;

import bank.system.BankSystem;
import bank.system.Inquiry;

import java.awt.Font;
import java.awt.SystemColor;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class OperatorInquiry {
	private JFrame frame;
	private JPasswordField passwordField;
	private JTextField textField;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OperatorInquiry window = new OperatorInquiry();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public JFrame getFrame() {
		return frame;
	}
	public OperatorInquiry() {
		initialize();
	}
	
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("ְԱ��Ϣ��ѯ");
		frame.setBounds(400, 200, 450, 300);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
/*		passwordField = new JPasswordField();
		passwordField.setBounds(144, 136, 204, 43);
		frame.getContentPane().add(passwordField);
*/		
		textField = new JTextField();
		textField.setBounds(144, 59, 208, 43);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JTextPane textPane = new JTextPane();
		textPane.setBackground(SystemColor.control);
		textPane.setFont(new Font("����", Font.PLAIN, 20));
		textPane.setText("      �˺�");
		textPane.setBounds(23, 59, 111, 43);
		frame.getContentPane().add(textPane);
		
/*		JTextPane textPane_1 = new JTextPane();
		textPane_1.setBackground(SystemColor.control);
		textPane_1.setFont(new Font("����", Font.PLAIN, 20));
		textPane_1.setText("  ����");
		textPane_1.setBounds(59, 136, 82, 43);
		frame.getContentPane().add(textPane_1);
*/		
		JButton btnNewButton = new JButton("ȷ��");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String num=textField.getText();
				try {
					String[] str =AdminSystem.Inquiry(num);
					JOptionPane.showMessageDialog(btnNewButton, "��ţ�"+str[0]+"  ְԱ������"+str[1]+"  ״̬��"+str[2]);
				}catch (Exception e1) {
					JOptionPane.showMessageDialog(btnNewButton,"���δע����������","Error", JOptionPane.ERROR_MESSAGE);
					
				}
			}
		});
		btnNewButton.setBounds(172, 213, 111, 38);
		frame.getContentPane().add(btnNewButton);
	}
}
