package com.oracle;

import java.sql.SQLException;

public interface EmployeeDAO {
	public void createTable() throws SQLException;

	public void save(Employee employee) throws SQLException;

	public void update(int empid, float sal) throws SQLException;

	public void deleteEmp(int empid) throws SQLException;

	public void getEmployeeById(int empid) throws SQLException;

	public void getAllEmployees() throws SQLException;

}
