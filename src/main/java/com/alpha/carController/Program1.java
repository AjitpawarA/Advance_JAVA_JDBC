package com.alpha.carController;

public class Program1 {
	
	public static void main(String[] args) {
		
		Singleton singleton1 = Singleton.getSingleton();
		Singleton singleton2 = Singleton.getSingleton();
		
		System.out.println(singleton1.equals(singleton2));
		System.out.println(singleton1);
		System.out.println(singleton2);
	}
}
