package bank.system;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JTextPane;
import java.awt.Font;
import java.awt.SystemColor;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Inquiry {
	private JFrame frame;
	private JPasswordField passwordField;
	private JTextField textField;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Inquiry window = new Inquiry();
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
	public Inquiry() {
		initialize();
	}
	
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("–≈œ¢≤È—Ø");
		frame.setBounds(400, 200, 450, 300);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(144, 136, 204, 43);
		frame.getContentPane().add(passwordField);
		
		textField = new JTextField();
		textField.setBounds(144, 59, 208, 43);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JTextPane textPane = new JTextPane();
		textPane.setBackground(SystemColor.control);
		textPane.setFont(new Font("ÀŒÃÂ", Font.PLAIN, 20));
		textPane.setText("      ’À∫≈");
		textPane.setBounds(23, 59, 111, 43);
		frame.getContentPane().add(textPane);
		
		JTextPane textPane_1 = new JTextPane();
		textPane_1.setBackground(SystemColor.control);
		textPane_1.setFont(new Font("ÀŒÃÂ", Font.PLAIN, 20));
		textPane_1.setText("  √‹¬Î");
		textPane_1.setBounds(59, 136, 82, 43);
		frame.getContentPane().add(textPane_1);
		
		JButton btnNewButton = new JButton("»∑∂®");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String num=textField.getText();
				char[] password =passwordField.getPassword();
				String psw=new String(password);
				try {
					String[] str =BankSystem.balanceInquiry(num,psw);
					JOptionPane.showMessageDialog(btnNewButton, "’À∫≈£∫"+str[0]+"  ”√ªß√˚£∫"+str[1]+"  ”‡∂Ó£∫"+str[2]);
				}catch (Exception e1) {
					JOptionPane.showMessageDialog(btnNewButton,"’À∫≈Œ¥◊¢≤·ªÚ√‹¬Î¥ÌŒÛ£°","Error", JOptionPane.ERROR_MESSAGE);
					
				}
			}
		});
		btnNewButton.setBounds(172, 213, 111, 38);
		frame.getContentPane().add(btnNewButton);
	}
}
