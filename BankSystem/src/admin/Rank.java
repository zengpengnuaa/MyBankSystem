package admin;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JTable;

import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Color;

public class Rank {
	private JFrame frame;
	private JTextField textField;
	private JTextField passwordField;
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Rank window = new Rank();
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
	
	public Rank() {
		initialize();
	}
	
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(SystemColor.control);
		frame.setTitle("富豪排行榜");
		frame.setBounds(400, 200, 450, 300);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		JTable mm=new JTable();
		
/*		JTextPane textPane = new JTextPane();
		textPane.setBackground(SystemColor.control);
		textPane.setFont(new Font("宋体", Font.PLAIN, 22));
		textPane.setText(" 总储蓄人数");
		textPane.setBounds(20, 42, 200, 42);
		frame.getContentPane().add(textPane);
		
		textField = new JTextField();
		textField.setBounds(148, 42, 178, 42);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		passwordField = new JTextField();
		passwordField.setBounds(148, 94, 178, 44);
		frame.getContentPane().add(passwordField);
		
	
		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(148, 148, 178, 42);
		frame.getContentPane().add(passwordField_1);
		
		JTextPane textPane_1 = new JTextPane();
		textPane_1.setBackground(SystemColor.control);
		textPane_1.setFont(new Font("宋体", Font.PLAIN, 22));
		textPane_1.setForeground(new Color(0, 0, 0));
		textPane_1.setText(" 总储蓄额");
		textPane_1.setBounds(45, 94, 150, 44);
		frame.getContentPane().add(textPane_1);
		
		JTextPane textPane_2 = new JTextPane();
		textPane_2.setBackground(SystemColor.control);
		textPane_2.setFont(new Font("宋体", Font.PLAIN, 22));
		textPane_2.setText("确认密码");
		textPane_2.setBounds(33, 148, 105, 52);
		frame.getContentPane().add(textPane_2);
*/	
		JButton btnNewButton = new JButton("查询");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					
					 AdminSystem.rank();	
					}
						
				
					catch (Exception e1) {
						e1.printStackTrace();
					}
				}
			});
	btnNewButton.setBounds(183, 209, 85, 42);
	frame.getContentPane().add(btnNewButton);
	}
}
