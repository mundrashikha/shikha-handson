package com.stream;

public interface MyInterface {
	
	public void printName();
	double printSalary();
	static void printGender() {
		System.out.println("Male");
	}

	default String displayCompany() {
		return "TCS";
	}
}
