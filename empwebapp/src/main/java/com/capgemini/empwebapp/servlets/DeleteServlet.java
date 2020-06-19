package com.capgemini.empwebapp.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.capgemini.empwebapp.dao.EmployeeDAO;
import com.capgemini.empwebapp.dao.EmployeeJDBCImple;
import com.capgemini.empwebapp.service.EmployeeService;
import com.capgemini.empwebapp.service.EmployeeServiceImple;


@WebServlet("/DeleteServlet")  
public class DeleteServlet extends HttpServlet{
	
	EmployeeService service = new EmployeeServiceImple();
	
	    protected void doPost(HttpServletRequest req, HttpServletResponse resp)   
	             throws ServletException, IOException {  
	      
	    	String sid=req.getParameter("eid");  
	        
	    	int id=Integer.parseInt(sid);  
	        			
			boolean deleted = service.deleteEmployeeInfo(id);
	        
	        PrintWriter out = resp.getWriter();
			
			out.print("<html>");
			out.print("<body>");
			
			if(deleted == true) {
				out.print("<h2 style = 'color:green'>Employee deleted successfully.....</h2>");
			} else {
				out.print("<h2 style = 'color:red'>Employee not deleted!!!!</h2>");
			}
			
	  	    RequestDispatcher res = req.getRequestDispatcher("/form.html");
		    res.include(req, resp);  
			
		    out.print("</body>");
			out.print("</html>");
	      
	    }  

}
