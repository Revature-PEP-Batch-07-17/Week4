package com.revature.repository;

import java.util.List;

import com.revature.model.Employee;

/*
 * DAO stands for 'Data Access Object'
 * 
 * DAO is a design pattern used commonly to communicate a server-side application
 * with a relational database.
 * 
 * The DAO is responsible for describing what SQL queries/functionality we want to
 * perform on our database to support business logic
 * 
 * CRUD operations are favored in a DAO.
 * Insert
 * Select
 * Update
 * Delete
 */
public interface EmployeeDAO {
	public Employee selectEmployeeById(Integer id);
	public Employee selectEmployeeByName(String name);
	public Boolean insertIntoEmployee(Employee emp);
	public List<Employee> selectAllEmployees();
}
