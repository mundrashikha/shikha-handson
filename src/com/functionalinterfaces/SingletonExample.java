package com.functionalinterfaces;

public class SingletonExample {
	
	private static SingletonExample x=null;
	private SingletonExample() {
			
	}
	public static SingletonExample getInstance() {
		//public static synchronized SingletonExample getInstance(){
		if (x==null) {
			synchronized(SingletonExample.class) {
				if(x==null)
					x= new SingletonExample();
			}
			
		}
		return x;
	}

	public String demoMethod()
	{
		return "hi";
	}
	
}
