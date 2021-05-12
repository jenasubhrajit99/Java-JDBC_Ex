import java.sql.*;
public class Type4_Driver_Ex_CreateTable {
	public static void main(String[] args) throws Exception{
		//String driver="oracle.jdbc.OracleDriver";
		String jdbc_url="jdbc:oracle:thin:@localhost:1521:XE";
		String user="system";
		String pwd="jeet";
		String sql_query="create table employee (eno number, ename varchar2(20), esal number(10,2), eaddr varchar2(10))";
		//Class.forName(driver);
		Connection con=DriverManager.getConnection(jdbc_url,user,pwd);
		Statement st=con.createStatement();
		st.executeUpdate(sql_query);
		System.out.println("Table ctreated Successfully");
		con.close();
	}
}
