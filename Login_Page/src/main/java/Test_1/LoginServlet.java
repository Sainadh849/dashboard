package Test_1;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/log")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {
		PrintWriter pw = response.getWriter();
		response.setContentType("text/html");
		
		try {
			
			UserBean ub = new LoginDAO().login(request);
			if(ub==null)
			{
				pw.println(" Invalid Login Process..<br>");
				RequestDispatcher rd = request.getRequestDispatcher("login.html");
			    rd.include(request, response);
			}
			
			else {
				Cookie ck = new Cookie("uname",ub.getUname());
				ServletContext sct = this.getServletContext();
				sct.setAttribute("ub",ub);
				response.addCookie(ck);  //Adding Cookie to response
				pw.println("WellCome User " +ub.getUname()+"<br>");
				RequestDispatcher rd = request.getRequestDispatcher("link.html");
				rd.include(request, response);
			}
				
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
    		
	}

}
