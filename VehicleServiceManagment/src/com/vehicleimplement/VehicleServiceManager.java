package com.vehicleimplement;
import com.dao.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
public class VehicleServiceManager implements VehicleServiceManagement {
	private Map<Integer, Vehicle> vehicles;
    private List<ServiceRecord> serviceRecords;
    Scanner sc = new Scanner(System.in);

	public VehicleServiceManager() {
		super();
		vehicles = new HashMap<>();
		serviceRecords = new ArrayList<>();
	}

	@Override
	public void addVehicle() throws VehicleException {
		
		System.out.println("Enter Vehicle id");
		int id = sc.nextInt();
		sc.nextLine();//new line
		System.out.println("Enter Vehicle Make");
		String make = sc.nextLine();
		System.out.println("Enter Vehicle Model");
		String model = sc.nextLine();
		System.out.println("Enter Vehicle Type");
		String typeStr=sc.nextLine();
		
		VehicleType type;
		try
		{
			type = VehicleType.valueOf(typeStr.toUpperCase());
		}
		catch(IllegalArgumentException e)
		{
			throw new VehicleException("Invalid Vehicle Type");
		}
		System.out.println("Enter Vehicle year");
		int year = sc.nextInt();
		System.out.println("Enter Vehicle Mileage");
		int mileage=sc.nextInt();
		Vehicle vehicle=new Vehicle(id,make,model,type,year,mileage);
		vehicles.put(id, vehicle);
		System.out.println("Vehicle Successfully added");
		
	}

	@Override
	public void removeVehicle() throws VehicleException {
		System.out.println("Enter Vehicle ID");
		int vid=sc.nextInt();
		if(!vehicles.containsKey(vid))
		{
			throw new VehicleException("Invalid vehicle ID");
		}
		vehicles.remove(vid);
		System.out.println("Vehicle removesd successfully");
	}

	@Override
	public void displayAllVehicle() {
		System.out.println("All Vehicles:");
		for(Vehicle vehicle:vehicles.values())
		{
			System.out.println("Id:"+vehicle.getId()+"\n"+"Make:"+vehicle.getMake()+"\n"+"Model:"+vehicle.getModel()+"\n"+"Type:"+vehicle.getType()+"\n"+"Year:"+vehicle.getYear()+"\n"+"Mileage:"+vehicle.getMileage());
		}
		
	}

	@Override
	public void searchByMake() {
		System.out.println("Enter Vehicle Make:");
		String make=sc.nextLine();
		System.out.println("Search By make");
		for(Vehicle vehicle:vehicles.values())
		{
			if(vehicle.getMake().equalsIgnoreCase(make))
		{
				System.out.println("Id:"+vehicle.getId()+"\n"+"Make:"+vehicle.getMake()+"\n"+"Model:"+vehicle.getModel()+"\n"+"Type:"+vehicle.getType()+"\n"+"Year:"+vehicle.getYear()+"\n"+"Mileage:"+vehicle.getMileage());
				System.out.println("------------------------");
		}
	}		
		
	}

	@Override
	public void searchByModel() {
		System.out.println("Enter the vehicle model:");
		String model = sc.nextLine();
		System.out.println("Search results by model:");
		for(Vehicle vehicle:vehicles.values())
		{
			if(vehicle.getModel().equalsIgnoreCase(model))
			{
				System.out.println("Id:"+vehicle.getId()+"\n"+"Make:"+vehicle.getMake()+"\n"+"Model:"+vehicle.getModel()+"\n"+"Type:"+vehicle.getType()+"\n"+"Year:"+vehicle.getYear()+"\n"+"Mileage:"+vehicle.getMileage());
				System.out.println("-------------------");

			}
			
		}
		
	}

	@Override
	public void searchByType() {
		System.out.println("Enter the Vehicle Type (CAR,TRUCK,MOTORCYCLE):");
		String typestr = sc.nextLine();
		VehicleType type;
		try
		{
			type = VehicleType.valueOf(typestr.toUpperCase());
		}
		catch(IllegalArgumentException e)
		{
			System.out.println("Invalid vehicle type");
			return;
		}
		System.out.println("Search results by type:");
		for(Vehicle vehicle:vehicles.values())
		{
			if (vehicle.getType()==type)
			{
				System.out.println("Id:"+vehicle.getId()+"\n"+"Make:"+vehicle.getMake()+"\n"+"Model:"+vehicle.getModel()+"\n"+"Type:"+vehicle.getType()+"\n"+"Year:"+vehicle.getYear()+"\n"+"Mileage:"+vehicle.getMileage());

			}
		}
		
	}
	@Override
	public void addServiceRecord()throws VehicleException {
		System.out.println("Enter the Vehicle Id:");
		int vid=sc.nextInt();
		Vehicle vehicle = vehicles.get(vid);
		if(vehicle == null)
		{
			throw new VehicleException("Invalid vehicle Id");
		}
		sc.nextLine();
		System.out.println("Enter Service Date(YYYY-MM-DD):");
		String datestr=sc.nextLine();
		Date date;
		try
		{
			date = new SimpleDateFormat("yyyy-MM-dd").parse(datestr);
		}
		catch(ParseException e)
		{
			throw new VehicleException("Invalid date format");
		}
		System.out.println("Enter service description:");
		String description=sc.nextLine();
		System.out.println("Enter service cost:");
		double cost = sc.nextDouble();
		ServiceRecord sr=new ServiceRecord(vehicle,date,description,cost);
		serviceRecords.add(sr);
		System.out.println("Service Record add sucessfully");
		
	}

	@Override
	public void displayServiceHistory() {
		System.out.println("Enter the vehicle id");
		int vid=sc.nextInt();
		Vehicle vehicle = vehicles.get(vid);
		if(vehicle==null)
		{
			System.out.println("Invalid vehicle Id");
			return;
		}
		System.out.println("Service History vehicle id"+vid+":");
		for(ServiceRecord sr:serviceRecords)
		{
			if(sr.getVehicle().equals(vehicle))
			{
				System.out.println("Date:"+sr.getDate()+"\n"+"Description:"+sr.getDescription()+"\n"+"Cost:"+sr.getCost());
				System.out.println("--------------------------");
			}
		}
		
	}

}
