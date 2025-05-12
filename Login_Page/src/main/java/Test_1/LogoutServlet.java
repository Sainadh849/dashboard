package Test_1;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/logout")
public class LogoutServlet extends HttpServlet 

{
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	
	{
		
		          PrintWriter pw =response.getWriter();
		          response.setContentType("text/html");
		          Cookie c[] =request.getCookies();
		          if(c==null)
		          {
		        	  pw.println("Session Expired");
		        	  
		          }
		          else {
		          ServletContext sct=this.getServletContext();
		          sct.removeAttribute("ub");
		          c[0].setMaxAge(0);
		          response.addCookie(c[0]);
		          pw.println("User Loggedout Succesfully..<br>");
		          }
		              
	         
		                
		RequestDispatcher rd = request.getRequestDispatcher("login.html"); 
		rd.include(request, response);
		                	                
	}	                
	
}
