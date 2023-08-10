package com.revature.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.revature.model.Employee;
import com.revature.util.ConnectionUtil;

public class EmployeeDAOImpl_Postgres implements EmployeeDAO {

	@Override
	public Employee selectEmployeeById(Integer id) {
		Employee toReturn = null;
		try {
			Connection conn = ConnectionUtil.getConnection();
			
			/*
			 * Statement objects allow you to craft SQL queries in your Java application
			 * 
			 * -Statement : basic statements, based on a String that we provide
			 * -PreparedStatement : statements that can include placeholders, and allow us to create "templates"
			 * 		-PreparedStatements are MUCH better for SQL querying with JDBC because it prevents SQL Injection
			 * -CallableStatement : 
			 * 
			 * SQL Injection : Malicious code meant to disrupt or threaten the integrity of your data
			 * 		-Inserting SQL statements within larger statements to manipulate the results
			 * 
			 * 		"SELECT * FROM employees WHERE emp_name=" + name;
			 * 			"SELECT emp_address, emp_email, emp_password FROM employees WHERE salary > 100,000";
			 */
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM lecture.employees WHERE emp_id=?");
			ps.setInt(1, id);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				/* You can get data from a ResultSet using the column number OR column name */
//				System.out.println(rs.getInt(1));
//				System.out.println(rs.getString(2));
//				System.out.println(rs.getDouble("emp_salary"));
//				System.out.println(rs.getString(4));
				
				toReturn = new Employee(
						rs.getInt("emp_id"),
						rs.getString("emp_name"),
						rs.getDouble("emp_salary"),
						rs.getString("emp_title")
						);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return toReturn;
	}

	@Override
	public Employee selectEmployeeByName(String name) {
		try {
			Connection conn = ConnectionUtil.getConnection();
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM lecture.employees WHERE emp_name=?");
			ps.setString(1, name);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				return new Employee( rs.getInt("emp_id"),rs.getString("emp_name"),
						rs.getDouble("emp_salary"),rs.getString("emp_title"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Boolean insertIntoEmployee(Employee emp) {
		try {
			Connection conn = ConnectionUtil.getConnection();
			String query = "INSERT INTO lecture.employees VALUES(?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, emp.getEmp_id());
			ps.setString(2, emp.getEmp_name());
			ps.setDouble(3, emp.getEmp_salary());
			ps.setString(4, emp.getEmp_title());
			
			if (ps.executeUpdate() > 0)
				return true;
			else
				return false;
			
		} catch (SQLException e) {
		
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public List<Employee> selectAllEmployees() {
		// TODO Auto-generated method stub
		return null;
	}

}
