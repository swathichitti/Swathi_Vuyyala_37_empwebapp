package com.capgemini.empwebapp.service;

import java.util.List;

import com.capgemini.empwebapp.dto.EmployeeBean;

public interface EmployeeService {
	
public EmployeeBean authenticate(int empId,String password);
	
	public EmployeeBean getEmployeeDetailById(int eid);
	public boolean deleteEmployeeInfo(int eid);
	public boolean updateEmployeeInfo(String ename);
	public boolean createEmployeeInfo(EmployeeBean bean);
	public List<EmployeeBean> getAllEmployeeDetail();
}
