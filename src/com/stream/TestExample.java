package com.stream;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;


public class TestExample {
	public static void main(String[] args) {
		
		Integer[] intarr= {1,2,3,4,4,1,1,2,2,2,3,2};
		
		List<Integer> list= Arrays.asList(intarr);
		Map<Integer,Long> map=list.stream().collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
		List<Long> l= new ArrayList<Long>(map.values());
		/*Long maxC=l.stream().reduce(0l, Long::max);
		System.out.println("maxC="+maxC);*/
		
		Long maxcount=l.stream().map(x->x).max(Long::compare).get();
		System.out.println("maxcount="+maxcount);
		Integer highestOccurence=0;
		for(Map.Entry<Integer,Long> m:map.entrySet()) {
			
			if(m.getValue()==maxcount) {
				highestOccurence=m.getKey();
				break;
				
			}
			
		}
		System.out.println("highestOccurence="+highestOccurence);
		
		Integer sum=list.stream().collect(Collectors.summingInt(x->x));
		System.out.println("sum="+sum);
		
	}

	public static void main1(String[] args) {
		Integer[] intarr= {1,2,3,4,4,1,1,2};
		
		List<Integer> list= Arrays.asList(intarr);

		Map<Integer,Long> map=list.stream().collect(Collectors.groupingBy(Function.identity(),Collectors.counting())); //[1=3,]
		int min=0;
		int max=0;
		Long minVal=Long.parseLong(String.valueOf(intarr.length));
		Long maxVal=0l;
		for(Map.Entry<Integer, Long> m:map.entrySet()) {
			
			if(m.getValue()<minVal) {
				minVal=m.getValue();
				min=m.getKey();
			}
			if(m.getValue()>maxVal) {
				maxVal=m.getValue();
				max=m.getKey();
			}
		}
		
		System.out.println(min+":::"+max);

		
		
		List<Employee> empList= new ArrayList<Employee>();
		String[] arr = {"Swimming", "Dancing", "Driving"};
		String[] arr1 = {"Reading", "Dancing", "Driving"};
		String[] arr2 = {"Dancing"};
		List<String> hobbieslist1=Arrays.asList(arr);
		List<String> hobbieslist2=Arrays.asList(arr1);
		List<String> hobbieslist3=Arrays.asList(arr2);
		
		Employee emp1 = new Employee("Emp1",25,60000.00,hobbieslist1);
		Employee emp2 = new Employee("Emp2",32,70000.00,hobbieslist2);
		Employee emp3 = new Employee("Emp3",25,30000.00,hobbieslist3);
		
		empList.add(emp1);
		empList.add(emp2);
		empList.add(emp3);

		
		Map<String,Integer> collect = empList.stream()
		.filter(e->e.getSalary()>10000 && e.getSalary()< 80000)
		.filter(e->e.getAge() > 18 && e.getAge()<30)
		.flatMap(e->e.getHobbies().stream())
		.collect( Collectors.groupingBy( Function.identity(), Collectors.summingInt(e -> 1) ));
		
		Integer max1=0;
		StringBuilder maxHobby=null;;
		for(Map.Entry<String,Integer> m : collect.entrySet()) {
			if(m.getValue() > max1) {
				max1=m.getValue();
				maxHobby= new StringBuilder(m.getKey());
			}
		}
		
		System.out.print(maxHobby);
		
		
	}

}

class Employee{
	public String name;
	public int age;
	public Double salary;
	public List<String> hobbies;
	
	public Employee(String name, int age, Double salary, List<String> hobbies) {
		super();
		this.name = name;
		this.age = age;
		this.salary = salary;
		this.hobbies = hobbies;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

	public List<String> getHobbies() {
		return hobbies;
	}

	public void setHobbies(List<String> hobbies) {
		this.hobbies = hobbies;
	}
	
	
}

	
