import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Types;

public class Callable_Ex {
	public static void main(String[] args) throws Exception{
		Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "system", "jeet");
		CallableStatement cst=conn.prepareCall("{call getEmpInfo(?,?,?,?)}");
		cst.setInt(1, 4715);
		cst.registerOutParameter(2, Types.VARCHAR);
		cst.registerOutParameter(3, Types.FLOAT);
		cst.registerOutParameter(4, Types.VARCHAR);
		cst.execute();
		System.out.println("Employee Name is : "+cst.getString(2));
		System.out.println("Employee Salary is :"+cst.getFloat(3));
		System.out.println("Employee Address is :"+cst.getString(4));
		conn.close();
	}
}



//create or replace procedure getEmpInfo(id IN number, name OUT varchar2, sal OUT number, addr OUT varchar2)
//as
//BEGIN 
//select ename, esal, eaddr into name, sal, addr from employee where eno=id; 
//END;
///
