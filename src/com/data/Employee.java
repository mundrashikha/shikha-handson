package com.data;

public class Employee {
	
	private String empId;
	private String empname;
	private int age;
	private double salary;
	private String gender;
	
	public Employee (String empId, String empname, String gender, Integer age, Double salary) {
		this.empId=empId;
		this.empname=empname;
		this.gender=gender;
		this.age=age;
		this.salary=salary;
		
	}

	public String getEmpId() {
		return empId;
	}

	public void setEmpId(String empId) {
		this.empId = empId;
	}

	public String getEmpname() {
		return empname;
	}

	public void setEmpname(String empname) {
		this.empname = empname;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}
	

}
