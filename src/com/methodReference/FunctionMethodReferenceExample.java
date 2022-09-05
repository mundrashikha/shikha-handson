package com.methodReference;

import java.util.function.Function;

public class FunctionMethodReferenceExample {

	static Function<String, String> toUpperCaseLambda=(s)->s.toUpperCase();
	static Function<String, String> toUpperMethodRef=String::toUpperCase;
	public static void main(String[] args) {
		
		
		System.out.println("String is :"+toUpperCaseLambda.apply("abc"));
		System.out.println("String by method ref :"+toUpperMethodRef.apply("java8"));
	}

}
