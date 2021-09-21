package com.oracle;

import java.sql.SQLException;

public class EmployeeTest {

	public static void main(String[] args) throws SQLException {
		EmployeeDAOImpl dao = new EmployeeDAOImpl();
		dao.createTable();
		Employee emp=new Employee(6889,500.2f,"Naveen");
		dao.save(emp);
		dao.update(6889, 5325.2f);
        dao.deleteEmp(6889);
		dao.getEmployeeById(6430);
		dao.getAllEmployees();

}
}
