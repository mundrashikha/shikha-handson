package com.stream;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;

import com.data.Employee;
import com.data.EmployeeDatabase;



public class EmployeeStream {
	static Consumer<Employee> cons=(emp)->System.out.println(emp);

	public static void main(String[] args) {
		List<Employee> emplist=EmployeeDatabase.getAllEmployees();
		List<Employee> filteredList=emplist.stream().filter (emp->emp.getSalary()>10000.0).collect(Collectors.toList());
		List<Employee> filteredList1=emplist.stream().filter (emp->emp.getSalary()==10000.0).collect(Collectors.toList());
		List<Employee> filteredList2=emplist.stream().filter (emp->emp.getAge()>30).collect(Collectors.toList());
		List<Employee> maleList=emplist.stream().filter (emp->emp.getGender()=="Male").collect(Collectors.toList());
		List<Employee> femaleList=emplist.stream().filter (emp->emp.getGender()=="Female").collect(Collectors.toList());
		System.out.println("\nFemale Employees");
		emplist.stream().filter (emp->emp.getGender()=="Female").forEach(x->System.out.println("Employee Id="+x.getEmpId()+"Name="+x.getEmpname()+ " Age="+ x.getAge() + " Salary="+x.getSalary()));
		
		System.out.println("\ntotal salary of employee whose age is gt 30");
		//Double totalSalry=emplist.stream().filter(emp->emp.getAge()>30).mapToDouble(emp->emp.getSalary()).sum();
		Double totalSalry=emplist.stream().filter(emp->emp.getAge()>30).collect(Collectors.summingDouble(emp->emp.getSalary()));
		System.out.println("totalSalry="+totalSalry);
		
		Double maxSalary=emplist.stream().filter(emp->emp.getAge()>30).map(emp->emp.getSalary()).max(Double :: compare).get();
		System.out.println("maxSalary="+maxSalary);
		
		Map<String,List<String>> map=emplist.stream().collect(Collectors.groupingBy(Employee::getGender,Collectors.mapping(Employee::getEmpname, Collectors.toList())));
		System.out.println("Employee with gender by grouping::"+map);
		
		
		System.out.println("Employee whose salary gt than 10000");
		filteredList.forEach(x->System.out.println("Employee Id="+x.getEmpId()+"Name="+x.getEmpname()+ " Age="+ x.getAge() + " Salary="+x.getSalary()));
		System.out.println("\nEmployee whose salary is 10000");
		filteredList1.forEach(x->System.out.println("Employee Id="+x.getEmpId()+"Name="+x.getEmpname()+ " Age="+ x.getAge() + " Salary="+x.getSalary()));

		System.out.println("\nEmployee whose age gt than 30");
		filteredList2.forEach(x->System.out.println("Employee Id="+x.getEmpId()+"Name="+x.getEmpname()+ " Age="+ x.getAge() + " Salary="+x.getSalary()));

		System.out.println("\nMale Employees");
		maleList.forEach(x->System.out.println("Employee Id="+x.getEmpId()+"Name="+x.getEmpname()+ " Age="+ x.getAge() + " Salary="+x.getSalary()
		+" Gender="+x.getGender()));

		System.out.println("\nFemale Employees");
		femaleList.forEach(x->System.out.println("Employee Id="+x.getEmpId()+"Name="+x.getEmpname()+ " Age="+ x.getAge() + " Salary="+x.getSalary()
		+" Gender="+x.getGender()));
	}
	private static HashSet<String> s1=new HashSet<>();
	private static Set<String> dictionary = new HashSet<>();
	public static void main4(String[] args) {
		List<Integer> list=Arrays.asList(1,2,3,1,1,3,2,4,5,1);
		Map<Integer,Long> map=list.stream().collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
		System.out.println("map"+map);
		
		/*String str="The quick brown fox jumps over the lazy dog";  //true
		String nstr="The quick brown fox jumps over the lazy cat"; //false
		boolean allLetterPresent=true;
		str=str.toLowerCase();
		for(char c='a' ; c<='z'; c++) {
			
			if(!nstr.contains(String.valueOf(c))) {
				System.out.println("c="+c);
				allLetterPresent=false;
				break;
			}
		}
		System.out.println("allLetterPresent="+allLetterPresent);*/
		String[] temp_dict= {"I","Love","IBM","World"};
		
		Collections.addAll(s1, temp_dict);
		//System.out.println(s1);
		String word="LoveIBMWorld";
		System.out.println("s1"+s1);
		
		System.out.println(wordbreak1(word));
	}
	
	public static boolean wordbreak1(String word) {
		int size=word.length();
		if(size==0) return true;
		
		for(int i=1;i<=size;i++) {
			
			if(s1.contains(word.substring(0,i)) && 
					wordbreak1(word.substring(i,size))) {
				return true;
			}
		}
		return false;
	}
	
    
    public static void main2(String []args)
    {
         
        // array of strings to be added in dictionary set.
       /* String temp_dictionary[] = {"mobile","samsung","sam","sung",
                            "man","mango","icecream","and",
                            "go","i","like","ice","cream"};*/
        
        String[] temp_dictionary= {"I","Love","IBM","World"};
                             
        // loop to add all strings in dictionary set
        for (String temp :temp_dictionary)
        {
            dictionary.add(temp);
        }
         
        String word="ILoveIBMWorld";
		
		System.out.println("11="+wordBreak(word));
        // sample input cases
        System.out.println("1="+wordBreak("ilikesamsung"));
        System.out.println(wordBreak("iiiiiiii"));
        System.out.println(wordBreak(""));
        System.out.println(wordBreak("ilikelikeimangoiii"));
        System.out.println(wordBreak("samsungandmango"));
        System.out.println(wordBreak("samsungandmangok"));
         
    }
     
    // returns true if the word can be segmented into parts such
    // that each part is contained in dictionary
    public static boolean wordBreak(String word)
    {
        int size = word.length();
         
        // base case
        if (size == 0)
        return true;
         
        //else check for all words
        for (int i = 1; i <= size; i++)
        {
            // Now we will first divide the word into two parts ,
            // the prefix will have a length of i and check if it is
            // present in dictionary ,if yes then we will check for
            // suffix of length size-i recursively. if both prefix and
            // suffix are present the word is found in dictionary.
 
            if (dictionary.contains(word.substring(0,i)) &&
                    wordBreak(word.substring(i,size)))
            return true;
        }
         
        // if all cases failed then return false
        return false;
    }
}
 

