import java.sql.*;
import java.util.*;

public class InputMultipleData_Ex {
	public static void main(String[] args) throws Exception{
		Scanner scan=new Scanner(System.in);
		while(true) {
			System.out.println("Enter Employee Number");
			int eno=scan.nextInt();
			System.out.println("Enter Employee Name");
			String ename=scan.next();
			System.out.println("Enter Employee Salary");
			double esal=scan.nextDouble();
			System.out.println("Enter Employee address");
			String eaddr=scan.next();
			//String sql_query="insert into employee values("+eno+",'"+ename+"',"+esal+",'"+eaddr+"')";
			String sql_query=String.format("insert into employee values(%d,'%s', %f, '%s')", eno, ename, esal, eaddr);
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "system", "jeet");
			Statement st=con.createStatement();
			st.executeUpdate(sql_query);
			System.out.println("Data inserted");
			System.out.println("Insert more (Yes/No)");
			String s=scan.next();
			if(s.equalsIgnoreCase("No"))
				break;
			con.close();
		}
		scan.close();
	}
}
