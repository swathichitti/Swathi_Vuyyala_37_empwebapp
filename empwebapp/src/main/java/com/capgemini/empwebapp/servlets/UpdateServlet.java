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
import com.capgemini.empwebapp.dto.EmployeeBean;
import com.capgemini.empwebapp.service.EmployeeService;
import com.capgemini.empwebapp.service.EmployeeServiceImple;


@WebServlet("/EditEmployee")
public class UpdateServlet extends HttpServlet {

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		EmployeeBean bean = new EmployeeBean();
		EmployeeService service = new EmployeeServiceImple();

		String id = req.getParameter("eid");
		String name = req.getParameter("ename");
		
		bean.setEid(Integer.parseInt(id));
		bean.setEname(name);

		boolean check = service.updateEmployeeInfo(name);
		PrintWriter out = resp.getWriter();
		
		out.println("<html>");
		out.println("<head>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>");

		if (check == true) {
			out.print("<h2 style = 'color:black'>Updated successfully.....</h2>");
		} else {
			out.print("<h2 style = 'color:red'>Updation not done!!!!!</h2>");
		}
		
		RequestDispatcher res = req.getRequestDispatcher("/form.html");
		res.include(req, resp);  
		
		out.println("</h1>");
		out.println("</body>");
		out.println("</html>");
	}

}
