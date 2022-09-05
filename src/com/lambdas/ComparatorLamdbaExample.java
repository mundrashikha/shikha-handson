package com.lambdas;

import java.util.Comparator;

public class ComparatorLamdbaExample {

	/**
	 * @param args
	 */
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//Prior Java 8
		Comparator<Integer> comparator=new Comparator<Integer>() {
			
			@Override
			public int compare(Integer o1, Integer o2) {
				// TODO Auto-generated method stub
				return o1.compareTo(o2);
			}
		};
		System.out.println("Result of comparator is :"+comparator.compare(3, 2));
		
		//Lambda Java 8
		Comparator<Integer> comparatorLambda=(Integer a, Integer b)->{
			return a.compareTo(b);
			
		};
		System.out.println("Result of lambda comparator is: "+comparatorLambda.compare(2, 2) );
		
		Comparator<Integer> comparatorLambda1=(a,b)->a.compareTo(b);
		System.out.println("Result of lambda comparator1 is:"+comparatorLambda1.compare(3, 4));
	}

}
