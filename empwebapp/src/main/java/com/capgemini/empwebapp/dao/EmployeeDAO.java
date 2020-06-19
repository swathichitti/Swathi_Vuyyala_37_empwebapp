package com.capgemini.empwebapp.dao;

import java.util.List;

import com.capgemini.empwebapp.dto.EmployeeBean;



public interface EmployeeDAO {

	public EmployeeBean authenticate(int empId,String password);
	
	public EmployeeBean getEmployeeDetailById(int eid);
	public boolean deleteEmployeeInfo(int eid);
	public boolean updateEmployeeInfo(String ename);
	public boolean createEmployeeInfo(EmployeeBean bean);
	public List<EmployeeBean> getAllEmployeeDetail();
}


