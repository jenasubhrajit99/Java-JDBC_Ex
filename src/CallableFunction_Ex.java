import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Types;

public class CallableFunction_Ex {
	public static void main(String[] args) throws Exception{
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "system", "jeet");
		CallableStatement cst=con.prepareCall("{?=call getAvg(?, ?)}");
		cst.setInt(2, 4715);
		cst.setInt(3, 4716);
		cst.registerOutParameter(1, Types.FLOAT);
		cst.execute();
		System.out.println("The Average value is : "+cst.getFloat(1));
		con.close();
	}
}


//create or replace function getAvg(id1 IN number, id2 IN number) return number as
//sal1 number;
//sal2 number;
//BEGIN
//select esal into sal1 from employee where eno=id1;
//select esal into sal2 from employee where eno=id2;
//return (sal1+sal2)/2;
//END;
///