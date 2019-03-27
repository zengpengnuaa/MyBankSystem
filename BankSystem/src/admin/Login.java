package admin;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JTextPane;

import org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper;

import bank.system.BankSystem;
import bank.system.BankWindow;
import bank.system.Inquiry;

import java.awt.Font;
import java.awt.SystemColor;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Login {
	private JFrame frame;
	private JPasswordField passwordField;
	private JTextField textField;
	
	public static void main(String[] args) {
		try
	    {
			BeautyEyeLNFHelper.frameBorderStyle = BeautyEyeLNFHelper.FrameBorderStyle.generalNoTranslucencyShadow;
	        org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper.launchBeautyEyeLNF();
	    }
	    catch(Exception e)
	    {
	        //TODO exception
	    }
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
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
	public Login() {
		initialize();
	}
	
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("登录");
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
		textPane.setFont(new Font("宋体", Font.PLAIN, 20));
		textPane.setText("  账号");
		textPane.setBounds(59, 59, 82, 43);
		frame.getContentPane().add(textPane);
		
		JTextPane textPane_1 = new JTextPane();
		textPane_1.setBackground(SystemColor.control);
		textPane_1.setFont(new Font("宋体", Font.PLAIN, 20));
		textPane_1.setText("  密码");
		textPane_1.setBounds(59, 136, 82, 43);
		frame.getContentPane().add(textPane_1);
		
		JButton btnNewButton = new JButton("确定");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String num=textField.getText();
				char[] password =passwordField.getPassword();
				String psw=new String(password);
				try {
					int g=AdminSystem.Login(num, psw);
					if(g==0) {
								BankWindow window = new BankWindow();
								window.getFrame().setVisible(true);
								frame.setVisible(false);
					}
					else {
						AdminWindow window=new AdminWindow();
						window.getFrame().setVisible(true);
						frame.setVisible(false);	
					}
				}catch (Exception e1) {
					JOptionPane.showMessageDialog(btnNewButton,"账号未注册或密码错误！","Error", JOptionPane.ERROR_MESSAGE);
					
				}
			}
		});
		btnNewButton.setBounds(102, 213, 111, 38);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton1 = new JButton("退出");
		btnNewButton1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(btnNewButton1, "期待您下次使用，再见");
				System.exit(0);
			}
		});
		btnNewButton1.setBounds(252, 213, 111, 38);
		frame.getContentPane().add(btnNewButton1);
	}
	
}
