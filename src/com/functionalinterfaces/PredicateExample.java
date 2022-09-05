package com.functionalinterfaces;

import java.util.function.Predicate;

public class PredicateExample {

	static Predicate<Integer> p1=(a)->{return a%2==0;};
	static Predicate<Integer> p2=(a)->{return a%5==0;};
	public static void main(String[] args) {
		
		System.out.println(p1.test(4));
		System.out.println(p1.and(p2).test(10));
		System.out.println(p1.or(p2).test(8));
		System.out.println(p1.negate().test(10));
	}

}
