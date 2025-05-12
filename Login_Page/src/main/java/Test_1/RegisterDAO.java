package Test_1;


import java.sql.*;

public class RegisterDAO
{
	
	public int k=0;
	public int register(UserBean ub)
	{
		Connection con = DBConnection.getCon()  ;                                                                                       
		try {
			String sql = "INSERT INTO users (FullName, MailId, Password, Campany, Country, City, phoneNumber) VALUES (?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement ps = con.prepareStatement(sql);
			
			
			ps.setString(1, ub.getUname());
			ps.setString(2, ub.getMid());
			ps.setString(3, ub.getPword());
			ps.setString(4, ub.getCmpy());
			ps.setString(5, ub.getCtry());
			ps.setString(6, ub.getCity());
			ps.setString(7, ub.getPhno());
			
					
		} catch (SQLException e)
		
		   {
			
			e.printStackTrace();
		   }
		
		return k;
		
	}
		
	

}
