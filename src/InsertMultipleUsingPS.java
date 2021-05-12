import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class InsertMultipleUsingPS {
	public static void main(String[] args) throws Exception{
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "system", "jeet");
		String sqlQuery="insert into employee values(?, ?, ?, ?)";
		PreparedStatement pst=con.prepareStatement(sqlQuery);
		Scanner scan=new Scanner(System.in);
		while(true)
		{
			System.out.println("Enter the Employee Number");
			int eno=scan.nextInt();
			System.out.println("Enter the employee name");
			String ename=scan.next();
			System.out.println("Enter the Employee Salary");
			Double esal=scan.nextDouble();
			System.out.println("Enter the Employee Address");
			String eaddr=scan.next();
			pst.setInt(1, eno);
			pst.setString(2, ename);
			pst.setDouble(3, esal);
			pst.setString(4, eaddr);
			pst.executeUpdate();
			System.out.println("Insertion Successful");
			System.out.println("You want to insert more (Yes/No)");
			String option=scan.next();
			if(option.equalsIgnoreCase("No"))
				break;
		}
		con.close();
		scan.close();
	}
}
