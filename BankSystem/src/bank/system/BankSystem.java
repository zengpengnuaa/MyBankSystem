package bank.system;

import java.sql.*;


public class BankSystem {
	public static Connection connection() throws SQLException, ClassNotFoundException{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:ORCL","SCOTT","199872");
		return conn;
	}
	public static String openAccount(String name,String pwd,String pwd1) throws ClassNotFoundException, SQLException{
		Connection conn=connection();
		 if(pwd.equals(pwd1)) {
			 String sql1="insert into t_user(accountnumber,username,password,balance) values(seq_account.nextval,?,?,100)";
			 PreparedStatement psmt=conn.prepareStatement(sql1);
			 psmt.setString(1, name);
			 psmt.setString(2, pwd);
			 ResultSet rs=psmt.executeQuery();
			 if(rs.next()) {
				 Statement sm =conn.createStatement();
				 ResultSet rs1=sm.executeQuery("select accountnumber from t_user where username='"+name+"'");
				 while(rs1.next()) {
					 String str =rs1.getString(1);
					 return str;
				 }
			 }
		 }
		 return null; 
	}
	 public static String[] balanceInquiry(String num,String psw) throws ClassNotFoundException, SQLException{
		 Connection conn=connection();
		 String sql="select * from t_user where accountnumber='"+num+"' and password='"+psw+"'";
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
	 public static Boolean deposite(String num,String psw,Float money) throws ClassNotFoundException, SQLException{
		 Connection conn=connection();
		 String sql1="update t_user set balance=balance+? where accountnumber=? and password=?";
		 PreparedStatement psmt=conn.prepareStatement(sql1);
		 psmt.setFloat(1, money);
		 psmt.setString(2, num);
		 psmt.setString(3, psw);
		 int rs1=psmt.executeUpdate();
		 String sql2="insert into t_history(hid,accountnumber,money,content) values(seq_hid.nextval,"+num+","+money+",'存款')";
		 psmt=conn.prepareStatement(sql2);	
		 psmt.executeQuery();
		 if(rs1>0) {
			 return true; 
			
		 }
		 else {
			 return false;
		 }
	 }
	 public static boolean withdraw(String num,String psw,float money) throws ClassNotFoundException, SQLException{
		 Connection conn=connection();
		 String sql1="update t_user set balance=balance-? where accountnumber=? and password=?";
		 PreparedStatement psmt=conn.prepareStatement(sql1);
		 psmt.setFloat(1, money);
		 psmt.setString(2, num);
		 psmt.setString(3, psw);
		 int rs1=psmt.executeUpdate();
		 String sql2="insert into t_history(hid,accountnumber,money,content) values(seq_hid.nextval,"+num+","+money+",'取款')";
		 psmt=conn.prepareStatement(sql2);	
		 psmt.executeQuery();
		 if(rs1>0) {
			 return true;
		 }
		 else {
			 return false;
		 }
	 }
	 public static boolean transferAccounts(String fromNum,String psw,String toNum,float money) throws ClassNotFoundException, SQLException{
		 Connection conn=connection();
		 conn.setAutoCommit(false);
		  String sql1="update t_user set balance=balance-"+money+" where accountnumber="+fromNum+" and password="+psw+"";
		  String sql2="update t_user set balance=balance+"+money+" where accountnumber="+toNum+"";
		  String sql3="insert into t_history(hid,accountnumber,money,content) values(seq_hid.nextval,"+fromNum+","+money+",'转账')";
		  PreparedStatement pstmt=conn.prepareStatement(sql1);
		  int result1=pstmt.executeUpdate();
		  pstmt=conn.prepareStatement(sql2);
		  int result2=pstmt.executeUpdate();
		  pstmt=conn.prepareStatement(sql3);
		  pstmt.executeQuery();
		  if(result1>0&&result2>0) {
			  conn.commit();
			  return true;
		  }
		  else {
			  conn.rollback();
			  return false;
		  }
	 }
	 public static boolean accountBalance(String num,float money) throws ClassNotFoundException, SQLException{
		 Connection conn=connection();
		 String sql="select balance from t_user where accountnumber=?";
		 PreparedStatement psmt =conn.prepareStatement(sql);
		 psmt.setString(1, num);
		 ResultSet rs = psmt.executeQuery();
		 if(rs.next()) {
			 float balance=rs.getFloat(1);
			 if(money>balance)
				 return false;
			 else
				 return true;
		 }
		 return false;
	 }
}
