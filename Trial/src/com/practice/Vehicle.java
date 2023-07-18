package com.practice;


	import java.util.*;

	// Custom exception class for vehicle-related exceptions
	class VehicleException extends Exception {
	    public VehicleException(String message) {
	        super(message);
	    }
	}

	// Vehicle class
	class Vehicle {
	    private int id;
	    private String make;
	    private String model;
	    private VehicleType type;
	    private int year;
	    private int mileage;

	    public Vehicle(int id, String make, String model, VehicleType type, int year, int mileage) {
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

	// VehicleType enum
	enum VehicleType {
	    CAR, TRUCK, MOTORCYCLE
	}

	// ServiceRecord class
	class ServiceRecord {
	    private Vehicle vehicle;
	    private Date date;
	    private String description;
	    private double cost;

	    public ServiceRecord(Vehicle vehicle, Date date, String description, double cost) {
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

	// VehicleServiceManager class
	class VehicleServiceManager {
	    private Map<Integer, Vehicle> vehicles;
	    private List<ServiceRecord> serviceRecords;

	    public VehicleServiceManager() {
	        vehicles = new HashMap<>();
	        serviceRecords = new ArrayList<>();
	    }

	    public void addVehicle(Vehicle vehicle) {
	        vehicles.put(vehicle.getId(), vehicle);
	        System.out.println("Vehicle added successfully!");
	    }

	    public void removeVehicle(Vehicle vehicle) {
	        vehicles.remove(vehicle.getId());
	        System.out.println("Vehicle removed successfully!");
	    }

	    public void displayAllVehicles() {
	        System.out.println("All Vehicles:");

	        for (Vehicle vehicle : vehicles.values()) {
	            System.out.println("ID: " + vehicle.getId());
	            System.out.println("Make: " + vehicle.getMake());
	            System.out.println("Model: " + vehicle.getModel());
	            System.out.println("Type: " + vehicle.getType());
	            System.out.println("Year: " + vehicle.getYear());
	            System.out.println("Mileage: " + vehicle.getMileage());
	            System.out.println("---------------------");
	        }
	    }

	    public List<Vehicle> searchByMake(String make) {
	        List<Vehicle> searchResults = new ArrayList<>();

	        for (Vehicle vehicle : vehicles.values()) {
	            if (vehicle.getMake().equalsIgnoreCase(make)) {
	                searchResults.add(vehicle);
	            }
	        }

	        return searchResults;
	    }

	    public List<Vehicle> searchByModel(String model) {
	        List<Vehicle> searchResults = new ArrayList<>();

	        for (Vehicle vehicle : vehicles.values()) {
	            if (vehicle.getModel().equalsIgnoreCase(model)) {
	                searchResults.add(vehicle);
	            }
	        }

	        return searchResults;
	    }

	    public List<Vehicle> searchByType(VehicleType type) {
	        List<Vehicle> searchResults = new ArrayList<>();

	        for (Vehicle vehicle : vehicles.values()) {
	            if (vehicle.getType().equals(type)) {
	                searchResults.add(vehicle);
	            }
	        }

	        return searchResults;
	    }

	    public void addServiceRecord(ServiceRecord serviceRecord) {
	        serviceRecords.add(serviceRecord);
	        System.out.println("Service record added successfully!");
	    }

	    public void displayServiceHistory(Vehicle vehicle) {
	        System.out.println("Service History for Vehicle ID: " + vehicle.getId());

	        for (ServiceRecord record : serviceRecords) {
	            if (record.getVehicle().equals(vehicle)) {
	                System.out.println("Date: " + record.getDate());
	                System.out.println("Description: " + record.getDescription());
	                System.out.println("Cost: " + record.getCost());
	                System.out.println("---------------------");
	            }
	        }
	    }
	}

	// Main class to run the vehicle service management system
	public class Vehicle { 
	    public static void main(String[] args) {
	        VehicleServiceManager manager = new VehicleServiceManager();
	        Scanner scanner = new Scanner(System.in);

	        while (true) {
	            System.out.println("Vehicle Service Management System");
	            System.out.println("1. Add Vehicle");
	            System.out.println("2. Remove Vehicle");
	            System.out.println("3. Display All Vehicles");
	            System.out.println("4. Search by Make");
	            System.out.println("5. Search by Model");
	            System.out.println("6. Search by Type");
	            System.out.println("7. Add Service Record");
	            System.out.println("8. Display Service History");
	            System.out.println("0. Exit");
	            System.out.print("Enter your choice: ");

	            int choice = scanner.nextInt();

	            try {
	                switch (choice) {
	                    case 1:
	                        manager.addVehicle(getVehicleInputFromUser(scanner));
	                        break;
	                    case 2:
	                        manager.removeVehicle(getVehicleInputFromUser(scanner));
	                        break;
	                    case 3:
	                        manager.displayAllVehicles();
	                        break;
	                    case 4:
	                        System.out.print("Enter the make: ");
	                        scanner.nextLine(); // Consume the newline character
	                        String make = scanner.nextLine();
	                        List<Vehicle> makeSearchResults = manager.searchByMake(make);
	                        displaySearchResults(makeSearchResults);
	                        break;
	                    case 5:
	                        System.out.print("Enter the model: ");
	                        scanner.nextLine(); // Consume the newline character
	                        String model = scanner.nextLine();
	                        List<Vehicle> modelSearchResults = manager.searchByModel(model);
	                        displaySearchResults(modelSearchResults);
	                        break;
	                    case 6:
	                        System.out.print("Enter the vehicle type (CAR, TRUCK, MOTORCYCLE): ");
	                        scanner.nextLine(); // Consume the newline character
	                        String typeInput = scanner.nextLine();
	                        VehicleType type = VehicleType.valueOf(typeInput.toUpperCase());
	                        List<Vehicle> typeSearchResults = manager.searchByType(type);
	                        displaySearchResults(typeSearchResults);
	                        break;
	                    case 7:
	                        Vehicle vehicle = getVehicleInputFromUser(scanner);
	                        System.out.print("Enter the service description: ");
	                        scanner.nextLine(); // Consume the newline character
	                        String description = scanner.nextLine();
	                        System.out.print("Enter the service cost: ");
	                        double cost = scanner.nextDouble();

	                        ServiceRecord serviceRecord = new ServiceRecord(vehicle, new Date(), description, cost);
	                        manager.addServiceRecord(serviceRecord);
	                        break;
	                    case 8:
	                        manager.displayServiceHistory(getVehicleInputFromUser(scanner));
	                        break;
	                    case 0:
	                        System.out.println("Exiting...");
	                        System.exit(0);
	                    default:
	                        System.out.println("Invalid choice!");
	                        break;
	                }
	            } catch (VehicleException e) {
	                System.out.println("Error: " + e.getMessage());
	            }

	            System.out.println();
	        }
	    }

	    // Helper method to get vehicle input from the user
	    private static Vehicle getVehicleInputFromUser(Scanner scanner) {
	        System.out.print("Enter the vehicle ID: ");
	        int id = scanner.nextInt();
	        scanner.nextLine(); // Consume the newline character

	        System.out.print("Enter the make: ");
	        String make = scanner.nextLine();

	        System.out.print("Enter the model: ");
	        String model = scanner.nextLine();

	        System.out.print("Enter the vehicle type (CAR, TRUCK, MOTORCYCLE): ");
	        String typeInput = scanner.nextLine();
	        VehicleType type = VehicleType.valueOf(typeInput.toUpperCase());

	        System.out.print("Enter the year: ");
	        int year = scanner.nextInt();

	        System.out.print("Enter the mileage: ");
	        int mileage = scanner.nextInt();

	        return new Vehicle(id, make, model, type, year, mileage);
	    }

	    // Helper method to display search results
	    private static void displaySearchResults(List<Vehicle> searchResults) {
	        System.out.println("Search Results:");

	        if (searchResults.isEmpty()) {
	            System.out.println("No results found.");
	        } else {
	            for (Vehicle vehicle : searchResults) {
	                System.out.println("ID: " + vehicle.getId());
	                System.out.println("Make: " + vehicle.getMake());
	                System.out.println("Model: " + vehicle.getModel());
	                System.out.println("Type: " + vehicle.getType());
	                System.out.println("Year: " + vehicle.getYear());
	                System.out.println("Mileage: " + vehicle.getMileage());
	                System.out.println("---------------------");
	            }
	        }
	    }
	}


