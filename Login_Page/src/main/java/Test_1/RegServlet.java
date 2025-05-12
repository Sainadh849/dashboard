package Test_1;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/reg")
public class RegServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		PrintWriter pw = response.getWriter();
		response.setContentType("text/html");
		UserBean ub = new UserBean();
		ub.setUname(request.getParameter("uname"));
		ub.setMid(request.getParameter("mid"));
		ub.setPword(request.getParameter("pword"));
		ub.setCtry(request.getParameter("cty"));
		ub.setCity(request.getParameter("city"));
		ub.setPhno(request.getParameter("phno"));
		//ub.setPhno(Long.parseLong(request.getParameter("phno")));
		int k=new RegisterDAO().register(ub);
		
		if(k>0)
		{
			pw.println(" User Registration Succsesfuly..");
			
			RequestDispatcher rd = request.getRequestDispatcher("login.html");
			rd.include(request, response);
		} else
		{
			pw.println(" User Registration Unsuccsesfull.. <br>");
			pw.println("Please check it your eMail ID and Password if you have already given ..<br><br>");
			RequestDispatcher rd = request.getRequestDispatcher("register.html");
			rd.include(request, response);
			
			
		}
        
		
	}

	
	
}
