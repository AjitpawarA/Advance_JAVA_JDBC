package com.alpha.carController;

public class Singleton {
	
	private Singleton() {
		System.out.println("Hi");
	}
	
	private static Singleton singleton= null;
	
	public static Singleton getSingleton() {
		if(singleton==null) {
			singleton= new Singleton();
		}
		return singleton;
	}
	
}
