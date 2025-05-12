package Test_1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;


public class LoginDAO 

{
	
	public UserBean ub = null;
	
	public UserBean login(HttpServletRequest request) throws SQLException
	 
    {
		
		Connection con = DBConnection.getCon();
		PreparedStatement ps;
		try {
			ps = con.prepareStatement("SELECT * FROM users WHERE MailId = ? AND password = ? ");
			ps.setString(1, request.getParameter("mid"));
			ps.setString(2, request.getParameter("pword"));
		
			ResultSet rs = ps.executeQuery() ;
			
			if(rs.next()) {
				
				ub = new UserBean();
				ub.setUname(rs.getString(1));
				ub.setMid(rs.getString(2));
				ub.setPword(rs.getString(3));
				ub.setCmpy(rs.getString(4));
				ub.setCtry(rs.getString(5));
				ub.setCity(rs.getString(6));
				ub.setPhno(rs.getString(7));
				
			}
			
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	
		
		return ub;
		
	}

}
