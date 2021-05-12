import java.sql.*;
import java.util.*;

public class SelectCondition_Ex {
	public static void main(String[] args) throws Exception {
		Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "system", "jeet");
		Statement st=conn.createStatement();
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the Salary");
		double Salary=sc.nextDouble();
		String sqlQuery=String.format("select * from employee where esal >=%f", Salary); 
		ResultSet rs=st.executeQuery(sqlQuery);
		boolean flag=false;
		while(rs.next()) {
			flag=true;
			System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getDouble(3)+"\t"+rs.getString(4));
			System.out.println();
		}
		if(flag==false)
			System.out.println("Data is not available");
		conn.close();
		sc.close();
	}
}
