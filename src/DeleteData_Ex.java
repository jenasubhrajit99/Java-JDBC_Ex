import java.sql.*;
import java.util.*;

public class DeleteData_Ex {
	public static void main(String[] args) throws Exception {
		Class.forName("oracle.jdbc.OracleDriver");
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "system", "jeet");
		Statement st=con.createStatement();
		Scanner scan=new Scanner(System.in);
		System.out.println("Enter the cutoff Salary");
		double cutoff=scan.nextDouble();
		String sql_query=String.format("delete from employee where esal>=%f", cutoff);
		int updateCount=st.executeUpdate(sql_query);
		System.out.println("The number of rows deleted : "+updateCount);
		scan.close();
		con.close();
	}
}
