package com.dao;

public class Vehicle {
	private int id;
	private String make;
	private String model;
	private VehicleType type;
	private int year;
	private int mileage;
	public Vehicle(int id, String make, String model, VehicleType type, int year, int mileage) {
		super();
		this.id = id;
		this.make = make;
		this.model = model;
		this.type = type;
		this.year = year;
		this.mileage = mileage;
	}
	public int getId() {
		return id;
	}
	
	public String getMake() {
		return make;
	}
	public void setMake(String make) {
		this.make = make;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public VehicleType getType() {
		return type;
	}
	public void setType(VehicleType type) {
		this.type = type;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public int getMileage() {
		return mileage;
	}
	public void setMileage(int mileage) {
		this.mileage = mileage;
	}
	

}
