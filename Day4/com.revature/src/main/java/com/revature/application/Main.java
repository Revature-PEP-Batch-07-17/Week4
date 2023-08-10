package com.revature.application;

import com.revature.model.Employee;
import com.revature.repository.EmployeeDAOImpl_Postgres;

public class Main {
	public static void main(String[] args) {
		EmployeeDAOImpl_Postgres edao = new EmployeeDAOImpl_Postgres();
		System.out.println("Select By ID:");
		System.out.println(edao.selectEmployeeById(1000));
		System.out.println(edao.selectEmployeeById(1005));
		
		System.out.println("Select By Name:");
		System.out.println(edao.selectEmployeeByName("Phil"));
		
		Employee newbie = new Employee(2000, "Java App", 150000.00, "CEO");
		edao.insertIntoEmployee(newbie);
		
		System.out.println(edao.selectEmployeeByName("Java App"));
	}
}
