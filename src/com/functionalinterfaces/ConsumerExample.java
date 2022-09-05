package com.functionalinterfaces;

import java.util.List;
import java.util.function.Consumer;

import com.data.Student;
import com.data.StudentDataBase;

public class ConsumerExample {
	static Consumer<Student> c=(student)->System.out.println(student);
	static Consumer<Student> c1=(student)->System.out.print(student.getName());
	static Consumer<Student> c2=(student)->System.out.println(student.getActivities());
	

	public static void printName() {
		
		List<Student> studentList= StudentDataBase.getAllStudents();
		studentList.forEach(c);
	}
	public static void printNameAndActivities() {	
		
		List<Student> studentList= StudentDataBase.getAllStudents();
		studentList.forEach(c1.andThen(c2)); //consumer chain
	}
	
	public static void printNameAndActivitiesUsingCondition() {	
		
		List<Student> studentList= StudentDataBase.getAllStudents();
		studentList.forEach(student -> {
			if (student.getGradeLevel() > 3) {
				c1.andThen(c2).accept(student);
			}
		}); 
	}
	
	public static void main(String[] args) {	
		//printNameAndActivities();
		//printNameAndActivitiesUsingCondition();
		printName();
	}

}
