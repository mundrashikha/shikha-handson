package com.data;


import java.util.Arrays;
import java.util.List;

public class EmployeeDatabase {

	public static List<Employee> getAllEmployees(){
		List<Employee> emplist=null;
		
		Employee emp1=new Employee("101","Nirav","Male",30,100000.0);
		Employee emp2=new Employee("102","Shikha","Female",32,60000.0);
		Employee emp3=new Employee("103","Vishal","Male",29,10000.0);
		Employee emp4=new Employee("104","Mayur","Male",31,40000.0);
		Employee emp5=new Employee("105","Nidhi","Female",32,8000.0);
		
		emplist=Arrays.asList(emp1,emp2,emp3,emp4,emp5);
		
		return emplist;
	}
}
