package com.functionalinterfaces;

public class SingletonDemo {

	public static void main(String[] args) {
		SingletonExample s=SingletonExample.getInstance();
		System.out.println(s.demoMethod());
		System.out.println("singleton object="+s);
	}

}
