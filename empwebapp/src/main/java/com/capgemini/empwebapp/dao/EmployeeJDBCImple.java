package com.capgemini.empwebapp.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.capgemini.empwebapp.dto.EmployeeBean;



public class EmployeeJDBCImple implements EmployeeDAO {
	
		EmployeeBean bean = new EmployeeBean();
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		@Override
		public EmployeeBean getEmployeeDetailById(int eid) {

			
			try { 
			
				Class.forName("com.mysql.jdbc.Driver").newInstance();
				
				conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/emp_db?useSSL=false","j2ee","root");
					
				stmt = conn.prepareStatement("select * from employee where eid = ?");
				
				stmt.setInt(1, eid);
				
				rs = stmt.executeQuery();

				if(rs.next()) {
				bean.setEid(rs.getInt("eid"));
				bean.setEname(rs.getString("ename"));
				bean.setAge(rs.getInt("age"));
				bean.setSalary(rs.getInt("salary"));
				bean.setDesignation(rs.getString("designation"));
				bean.setPassword(rs.getString("password"));
				
				} else {
					System.out.println("Employee details not found");
				}
				
			}
			catch(Exception e) {
				e.printStackTrace();
			}
			//close connection
			finally {
				try {
					if(conn != null) {
					conn.close();
					} 
					if(stmt != null) {
					stmt.close();
					}
					if(rs != null) {
					rs.close();
					}
				} catch (SQLException e) {

					e.printStackTrace();
				}
			
			}
			return bean;
		}

		@Override
		public boolean deleteEmployeeInfo(int eid) {

			try { 
				//load the driver
				Class.forName("com.mysql.jdbc.Driver").newInstance();
				
				//get db connection via Driver
				conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/emp_db?useSSL=false","j2ee","root");
				
				//issue the sql query via connection
				stmt = conn.prepareStatement("delete from employee where eid = ?");
				
				//set parameters
				stmt.setInt(2,eid);
				
				//process the result "returned by sql queries"
				int status= stmt.executeUpdate();
				
				if(status != 0) {
					return true;
				
				} else {
					return false;
				}
				
			}
			catch(Exception e) {
				e.printStackTrace();
			}
			//close connection
			finally {
				try {
					if(conn != null) {
					conn.close();
					} 
					if(stmt != null) {
					stmt.close();
					}
					if(rs != null) {
					rs.close();
					}
				} catch (SQLException e) {

					e.printStackTrace();
				}
			
			}
			return false;
		}

		@Override
		public boolean updateEmployeeInfo(String ename) {

			try { 
				Class.forName("com.mysql.jdbc.Driver").newInstance();
				
				//get db connection via Driver
     			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/emp_db?useSSL=false","j2ee","root");
				
				//issue the sql query via connection
				stmt = conn.prepareStatement("update employee set name = ? where id = ?");
				
				//set parameters
				stmt.setString(1, bean.getEname());
				stmt.setInt(2,bean.getEid());
				
				//process the result "returned by sql queries"				
				int rowsaffected = stmt.executeUpdate();
								
				if(rowsaffected != 0) {
					return true;
				} else {
					return false;
				}
			}
			catch(Exception e) {
				e.printStackTrace();
			}
			//close connection
			finally {
				try {
					if(conn != null) {
					conn.close();
					} 
					if(stmt != null) {
					stmt.close();
					}
					if(rs != null) {
					rs.close();
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
			
			}
			return false;
		}

		@Override
		public boolean createEmployeeInfo(EmployeeBean bean) {

			try { 
				//load the driver
				Class.forName("com.mysql.jdbc.Driver").newInstance();
				
				//get db connection via Driver
				conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/emp_db?useSSL=false","j2ee","root");
				
				//issue the sql query via connection
				stmt = conn.prepareStatement("insert into employee(id,name,age,salary,designation,password) values (?,?,?,?,?,?)");
				
				//set parameters
				stmt.setInt(1,bean.getEid());
				stmt.setString(2,bean.getEname());
				stmt.setInt(3,bean.getAge());
				stmt.setInt(4,bean.getSalary());
				stmt.setString(5,bean.getDesignation());
				stmt.setString(6, bean.getPassword());
				
				//process the result "returned by sql queries"
				int rowsaffected= stmt.executeUpdate();
				if(rowsaffected != 0) {
					return true;
				} else {
					return false;
				}
			}
			catch(Exception e) {
				e.printStackTrace();
			}
			//close connection
			finally {
				try {
					if(conn != null) {
					conn.close();
					} 
					if(stmt != null) {
					stmt.close();
					}
					if(rs != null) {
					rs.close();
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
			
			}
			return false;
		}

		@Override
		public List<EmployeeBean> getAllEmployeeDetail() {

			Connection conn = null;
			Statement stmt = null;
			ResultSet rs = null;
			try { 
				//load the driver
				Class.forName("com.mysql.jdbc.Driver").newInstance();
				
				//get db connection via Driver
				conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/emp_db?useSSL=false","j2ee","root");
				
				//issue the sql query via connection
				stmt = conn.createStatement();
				
				//process the result "returned by sql queries"
				rs = stmt.executeQuery("select * from employee");
				List<EmployeeBean> list = new ArrayList<EmployeeBean>();
				while(rs.next()) {
					EmployeeBean beans = new EmployeeBean();
					beans.setEid(rs.getInt("eid"));
					beans.setEname(rs.getString("ename"));
					beans.setAge(rs.getInt("age"));
					beans.setSalary(rs.getInt("salary"));
					beans.setDesignation(rs.getString("designation"));
					beans.setPassword(rs.getString("password"));
					list.add(beans);
				}
				return list;
			}
			catch(Exception e) {
				e.printStackTrace();
			}
			//close connection
			finally {
				try {
					if(conn != null) {
					conn.close();
					} 
					if(stmt != null) {
					stmt.close();
					}
					if(rs != null) {
					rs.close();
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
			
			}
			return null;
		}

		@Override
		public EmployeeBean authenticate(int empId, String password) {
			EmployeeBean bean = getId(empId);
			return null;
		}

		private EmployeeBean getId(int empId) {
			// TODO Auto-generated method stub
			return null;
		}	

}  

