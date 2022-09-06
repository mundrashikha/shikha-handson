package com.functionalinterfaces;

import java.util.List;
import java.util.function.BiConsumer;

import com.data.Student;
import com.data.StudentDataBase;

public class BiConsumerExample {
	
	
	public static void nameAndActivities() {
		
		BiConsumer<String, List<String>> b1=(name,activities)->System.out.println("Name: "+name+" and Activities:"+activities);
		List<Student> studentList = StudentDataBase.getAllStudents();
		studentList.forEach((student -> b1.accept(student.getName(),student.getActivities())));
	}

	public static void main(String[] args) {
		BiConsumer<String, String> biConsumer=(a,b)->{
			System.out.println("A: "+a);
			System.out.println("B: "+b);
		};
		
		biConsumer.accept("java7", "java8");
		
		BiConsumer<Integer, Integer> mulitply=(a,b)->System.out.println("Mulitplication is "+ (a*b));
		BiConsumer<Integer, Integer> division=(a,b)->System.out.println("Division is "+ (a/b));
		
		mulitply.andThen(division).accept(10, 5);
		
		nameAndActivities();
	}
	
	

}
