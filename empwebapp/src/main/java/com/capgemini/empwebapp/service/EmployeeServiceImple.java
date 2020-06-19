package com.capgemini.empwebapp.service;



import java.util.List;

import com.capgemini.empwebapp.dao.EmployeeDAO;
import com.capgemini.empwebapp.dao.EmployeeJDBCImple;
import com.capgemini.empwebapp.dto.EmployeeBean;

public class EmployeeServiceImple implements EmployeeService{
	
	EmployeeDAO dao = new EmployeeJDBCImple();

	@Override
	public EmployeeBean getEmployeeDetailById(int eid) {
		if(eid!= 0) {
			return dao.getEmployeeDetailById(eid);
		}
		return null;
	}

	@Override
	public boolean deleteEmployeeInfo(int eid) {
		if(eid!=0) {
			return dao.deleteEmployeeInfo(eid);
		}
		return false;
	}

	@Override
	public boolean updateEmployeeInfo(String ename) {
		if(ename!=null) {
			return dao.updateEmployeeInfo(ename);
		}
		return false;
		
	}

	@Override
	public boolean createEmployeeInfo(EmployeeBean bean) {
		if(bean!=null) {
			return dao.createEmployeeInfo(bean);
		}
		return false;
	}

	@Override
	public List<EmployeeBean> getAllEmployeeDetail() {
		return dao.getAllEmployeeDetail();
	}

	@Override
	public EmployeeBean authenticate(int empId, String password) {
		if(empId < 0 || password == null || password.trim().isEmpty()) {
			return null;
		}
		return dao.authenticate(empId,password);
	}

}
