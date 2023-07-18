package com.dao;

public interface VehicleServiceManagement {
	public void addVehicle()throws VehicleException;
	public void removeVehicle()throws VehicleException;
	public void displayAllVehicle();
	public void searchByMake();
	public void searchByModel();
	public void searchByType();
	public void addServiceRecord()throws VehicleException;
	public void displayServiceHistory();

}
