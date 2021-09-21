package com.oracle;

public class Employee {
	private int empid;
	private float sal;
	private String ename;

	public int getEmpid() {
		return empid;
	}

	public void setEmpid(int empid) {
		this.empid = empid;
	}

	public float getSal() {
		return sal;
	}

	public void setSal(float sal) {
		this.sal = sal;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public Employee(int empid, float sal, String ename) {
		super();
		this.empid = empid;
		this.sal = sal;
		this.ename = ename;
	}

	@Override
	public String toString() {
		return "Employee [empid=" + empid + ", sal=" + sal + ", ename=" + ename + "]";
	}

}
