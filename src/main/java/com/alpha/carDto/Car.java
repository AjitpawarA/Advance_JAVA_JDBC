package com.alpha.carDto;
public class Car {
	
	private int id;
	private String name;
	private String brand;
	private int cost;
	private int manufact_year;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Car() {
		
	}
	public Car(int id, String name, String brand, int cost, int manufact_year) {
		super();
		this.id = id;
		this.name = name;
		this.brand = brand;
		this.cost = cost;
		this.manufact_year = manufact_year;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public int getCost() {
		return cost;
	}
	public void setCost(int cost) {
		this.cost = cost;
	}
	public int getManufact_year() {
		return manufact_year;
	}
	public void setManufact_year(int manufact_year) {
		this.manufact_year = manufact_year;
	}
	
}
