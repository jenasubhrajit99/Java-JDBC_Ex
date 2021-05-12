import java.sql.*;

public class ViewOrDropTable_Ex {
	public static void main(String[] args) throws Exception {
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "system", "jeet");
		Statement st=con.createStatement();
		ResultSet rs = st.executeQuery("select * from employee");
		while(rs.next())
		{
			System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getDouble(3)+"\t"+rs.getString(4));
			System.out.println();
		}
		st.executeQuery("Drop table employee");
		System.out.println("Table Droped");
		con.close();
	}
}
