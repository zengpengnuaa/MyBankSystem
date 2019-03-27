package admin;

import java.awt.EventQueue;
import javax.swing.JFrame;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JTextField;

import javax.swing.JTable;


import java.awt.SystemColor;


public class List {
	private JFrame frame;
	private JTextField textField;
	private JTextField passwordField;
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					List window = new List();
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
	
	public List() {
		initialize();
	}
	
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(SystemColor.control);
		frame.setTitle("职工列表");
		frame.setBounds(400, 200, 450, 300);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		JTable mm=new JTable();
		
		JButton btnNewButton = new JButton("查询");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					
					 AdminSystem.operatorlist();	
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

