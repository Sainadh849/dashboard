package Test_1;


import java.sql.Connection;
import java.sql.DriverManager;


public class DBConnection 

{
	
	private static Connection con = null;
	private DBConnection () {}
	static
	{
		try {
			
			    Class.forName("com.mysql.cj.jdbc.Driver");
			
			      con=DriverManager.getConnection("jdbc:mysql://localhost:3306/valisedatabase","root","9381174689");
			
			
			 
		} catch (Exception e) { e.printStackTrace();  }
		
	}
		public static  Connection getCon()
		
    {
		
		return con;
		
	}

}
