package com.lambdas;

public class RunnableLambdaExample {

	public static void main(String[] args) {
		Runnable runnable=new Runnable() {
			//Prior Java 8
			
			@Override
			public void run() {
				System.out.println("Inside Runnable 1");
			}
		};
		new Thread(runnable).start();
		
		// Java 8 Lambda Syntax
		//()->{}
		Runnable runnableLambda = ()->{
			System.out.println("Inside Runnable 2");
		};
		new Thread(runnableLambda).start();
	}

}
