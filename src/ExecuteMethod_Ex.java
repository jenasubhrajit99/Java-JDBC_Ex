import java.util.*;
import java.sql.*;

public class ExecuteMethod_Ex {
	public static void main(String[] args) throws Exception{
		Scanner sc=new Scanner(System.in);
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "system", "jeet");
		Statement st=con.createStatement();
		System.out.println("Enter the SQL Query to execute : ");
		String sqlQuery=sc.nextLine();
		boolean b=st.execute(sqlQuery);
		if(b==true)
		{
			ResultSet rs=st.getResultSet();
			while(rs.next())
			{
				System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getDouble(3)+"\t"+rs.getString(4));
			}
		}
		else {
			int getCount=st.getUpdateCount();
			System.out.println("Total number of rows affected is : "+getCount);
		}
		con.close();
		sc.close();
	}
}
