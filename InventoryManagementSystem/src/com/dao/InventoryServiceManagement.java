package com.dao;

//Interface for Inventory Service Management
public interface InventoryServiceManagement {
	public void addProduct()throws InventoryException;
	public void removeProduct()throws InventoryException;
	public void updateInventory()throws InventoryException;
	public void displayInventory();
	public void diaplayTotalValue();
	public void searchByName();
	public void searchByCategory();

}
