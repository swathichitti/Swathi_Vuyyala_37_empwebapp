package com.capgemini.empwebapp.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.capgemini.empwebapp.dto.EmployeeBean;
import com.capgemini.empwebapp.service.EmployeeService;
import com.capgemini.empwebapp.service.EmployeeServiceImple;

;

@WebServlet("/AddEmployee")
public class AddEmployeeServlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		EmployeeService service = new EmployeeServiceImple();
		
		String empIdVal = req.getParameter("eid");
		int id = Integer.parseInt(empIdVal);
		String name = req.getParameter("ename");
		String ageVal = req.getParameter("age");
		int age = Integer.parseInt(ageVal);
		String salaryVal = req.getParameter("salary");
		int salary = Integer.parseInt(salaryVal);
		String designation = req.getParameter("designation");
		String password = req.getParameter("password");

		EmployeeBean bean = new EmployeeBean();
		
		bean.setEid(id);
		bean.setEname(name);
		bean.setAge(age);
		bean.setSalary(salary);
		bean.setDesignation(designation);
		bean.setPassword(password);
		
		boolean added = service.createEmployeeInfo(bean);
		
		PrintWriter out = resp.getWriter();
		
		out.print("<html>");
		out.print("<body>");
		
		if(added) {
			out.print("<h2 style = 'color:green'>Employee added.....</h2>");
		} else {
			out.print("<h2 style = 'color:red'>Employee not added!!!!</h2>");
		}
		
		RequestDispatcher res = req.getRequestDispatcher("/form.html");
        res.include(req, resp);  
		
		out.print("</body>");
		out.print("</html>");

		
		
		out.close();
	}

	
	

}
