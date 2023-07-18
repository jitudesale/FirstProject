package com.dao;
import java.util.Date;
//ServiceRecord class
public class ServiceRecord {
	private Vehicle vehicle;
	private Date date;
	private String description;
	private double cost;
	public ServiceRecord(Vehicle vehicle, Date date, String description, double cost) {
		super();
		this.vehicle = vehicle;
		this.date = date;
		this.description = description;
		this.cost = cost;
	}
	public Vehicle getVehicle() {
		return vehicle;
	}
	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public double getCost() {
		return cost;
	}
	public void setCost(double cost) {
		this.cost = cost;
	}
	

}
