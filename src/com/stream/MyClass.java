package com.stream;

public class MyClass implements MyInterface{
	
	@Override
	public void printName() {
		System.out.println("Ruchi");
	}

	@Override
	public double printSalary() {
		return 1000;
	} 
	
	/*public String displayCompany() {
		return "Accenture";
	}*/
	
	public static void main(String[] args) {
		MyInterface m=new MyClass();
		m.printName();
		m.printSalary();
		System.out.println("Display Company = "+m.displayCompany());
		MyInterface.printGender();
	}

	

}
