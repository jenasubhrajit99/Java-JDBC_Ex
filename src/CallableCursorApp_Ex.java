import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

import oracle.jdbc.OracleTypes;

public class CallableCursorApp_Ex {
	public static void main(String[] args) throws Exception{
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "system", "jeet");
		CallableStatement cst=con.prepareCall("{call getAllEmpInfo(?)}");
		
		cst.registerOutParameter(1, OracleTypes.CURSOR);
		cst.execute();
		ResultSet rs=(ResultSet) cst.getObject(1);
		System.out.println("ENO\tENAME\tESAL\tEADDR");
		System.out.println("========================");
		boolean flag=false;
		while(rs.next())
		{
			flag=true;
			System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getFloat(3)+"\t"+rs.getString(4));
		}
		if(flag==false)
			System.out.println("No Record Found");
		con.close();
	}
}


//create or replace procedure getAllEmpInfo(emp OUT SYS_REFCURSOR) as
//BEGIN
//open emp for
//select * from employee;
//END;
///