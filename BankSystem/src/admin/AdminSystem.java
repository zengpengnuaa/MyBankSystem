package admin;

import java.sql.*;
import java.lang.String;
import javax.swing.*;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class AdminSystem {
	public static Connection connection() throws SQLException, ClassNotFoundException{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:ORCL","SCOTT","199872");
		return conn;
	}
	public static String addOperator(String name,String pwd,String pwd1,int grade) throws ClassNotFoundException, SQLException{
		Connection conn=connection();
		 if(pwd.equals(pwd1)) {
			 String sql1="insert into t_operator(usernumber,name,password,state,grade) values(seq_operator.nextval,?,?,'在职',?)";
			 PreparedStatement psmt=conn.prepareStatement(sql1);
			 psmt.setString(1, name);
			 psmt.setString(2, pwd);
			 psmt.setInt(3, grade);
			 ResultSet rs=psmt.executeQuery();
			 if(rs.next()) {
				 Statement sm =conn.createStatement();
				 ResultSet rs1=sm.executeQuery("select usernumber from t_operator where name='"+name+"'");
				 while(rs1.next()) {
					 String str =rs1.getString(1);
					 return str;
				 }
			 }
		 }
		 return null; 
	}
	 public static Float TotalSavings() throws ClassNotFoundException, SQLException{
		 
		 float sum=0;
		 Connection conn=connection();
		 String sql="select * from t_user";
		 PreparedStatement psmt=conn.prepareStatement(sql);
		 ResultSet rs=psmt.executeQuery();
		 while(rs.next()) {
			 
			 sum=sum+rs.getFloat(4);
			
		 }
		 return sum;
	 }
	 public static int Totalaccounts() throws ClassNotFoundException, SQLException{
		 int n=0;
		 
		 Connection conn=connection();
		 String sql="select * from t_user";
		 PreparedStatement psmt=conn.prepareStatement(sql);
		 ResultSet rs=psmt.executeQuery();
		 while(rs.next()) {
			 n++;
			 
			 
		 }
		 return n;
		 
	 }
	 public static void rank() throws ClassNotFoundException, SQLException {
		 JFrame jf=new JFrame();
		 JTable jt=new JTable();
		 JScrollPane jsp=null;
		 String[] col = { "帐号", "客户名","账户余额"};
		 DefaultTableModel mm = new DefaultTableModel(col, 0); 
		 Connection conn=connection();
		 String sql="select * from t_user order by balance desc";
		 PreparedStatement psmt=conn.prepareStatement(sql);
		 ResultSet rs=psmt.executeQuery();
		 while(rs.next()) {
			 String accountnumber=rs.getString(1);
			 String name=rs.getString(2);
			 String balance=rs.getString(4);
			 String[] str_row = {accountnumber,name,balance}; 
			 mm.addRow(str_row);
		 }
		 jt.setModel(mm);
		 jsp= new JScrollPane(jt);
		 jf.add(jsp);
		 jf.setTitle("富豪排行榜");	
		 jf.setSize(500, 400);	
		 jf.setLocation(300, 200);	
//		 jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		this.setResizable(false);		
		 jf.setVisible(true);
	 }

	 public static String[] Inquiry(String num) throws ClassNotFoundException, SQLException{
		 Connection conn=connection();
		 String sql="select * from t_operator where usernumber='"+num+"'";
		 PreparedStatement psmt=conn.prepareStatement(sql);
		 ResultSet rs=psmt.executeQuery();
		 if(rs.next()) {
			 String[] str =new String[3];
			 str[0]=rs.getString(1);
			 str[1]=rs.getString(2);
			 str[2]=rs.getString(4);
			 return str;
		 }
		 return null;
	 }
	 
	 public static int Login(String num,String psw) throws ClassNotFoundException, SQLException{
		 int grade=0;
		 Connection conn=connection();
		 String sql="select * from t_operator where usernumber='"+num+"' and password='"+psw+"'";
		 PreparedStatement psmt=conn.prepareStatement(sql);
		 ResultSet rs=psmt.executeQuery();
		 if(rs.next()) {
			
			 grade=rs.getInt(5);
		 }
		 return grade;
	 }
	 
	 public static void operatorlist() throws ClassNotFoundException, SQLException {
		 JFrame jf=new JFrame();
		 JTable jt=new JTable();
		 JScrollPane jsp=null;
		 String[] col = { "编号", "姓名","状态","等级"};
		 DefaultTableModel mm = new DefaultTableModel(col, 0); 
		 Connection conn=connection();
		 String sql="select * from t_operator";
		 PreparedStatement psmt=conn.prepareStatement(sql);
		 ResultSet rs=psmt.executeQuery();
		 while(rs.next()) {
			 String usernumber=rs.getString(1);
			 String name=rs.getString(2);
			 String state=rs.getString(4);
			 String grade=rs.getString(5);
			 String[] str_row = {usernumber,name,state,grade}; 
			 mm.addRow(str_row);
		 }
		 jt.setModel(mm);
		 jsp= new JScrollPane(jt);
		 jf.add(jsp);
		 jf.setTitle("职工列表");	
		 jf.setSize(500, 400);	
		 jf.setLocation(300, 200);	
//		 jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		this.setResizable(false);		
		 jf.setVisible(true);
	 }
}
