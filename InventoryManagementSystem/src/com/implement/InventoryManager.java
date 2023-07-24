package com.implement;
import com.bean.*;
import com.dao.InventoryException;
import com.dao.InventoryServiceManagement;
import java.util.*;
import com.bean.*;
public class InventoryManager implements InventoryServiceManagement  {
	Scanner sc = new Scanner(System.in);
	List<Product>products = new ArrayList<>();
	List<Category>categoris = new ArrayList<>();
	Map<Product,InventoryItem>inventory=new HashMap<>();

	@Override
	public void addProduct()throws InventoryException {
		System.out.println("Enter Product detail");
		System.out.println("Enter Product ID");
		int id = sc.nextInt();
		sc.nextLine();
		System.out.println("Enter Product name");
		String name = sc.nextLine();
		System.out.println("Enter Product Price");
		double price = sc.nextDouble();
		sc.nextLine();
		System.out.println("Enter category Id");
		int categoryId = sc.nextInt();
		sc.nextLine();
		System.out.println("Enter Category Name");
		String categoryname = sc.next();
		Product product = new Product(id,name,new Category(categoryId,categoryname),price);
		products.add(product);
		System.out.println("Enter Inventory quantity");
		int quantity = sc.nextInt();
		InventoryItem inventories = new InventoryItem(product,quantity);
		inventory.put(product, inventories);
		System.out.println("Product Add Sucessfully");
		
	}

	

	@Override
	public void removeProduct() throws InventoryException {
		this.displayInventory();
		System.out.println("Enter the Id of the product to remove");
		int rid=sc.nextInt();
		if(!inventory.containsKey(rid))
		{
			throw new InventoryException ("Invalid Product Id");
		}
		inventory.remove(rid);
		System.out.println("Product Remove Sucessfully");
		
	}

	@Override
	public void updateInventory() throws InventoryException {
		this.displayInventory();
	    System.out.println("Enter the Id to update Inventory");
	    int pid = sc.nextInt();
	    if(!inventory.containsKey(pid))
	    {
	    	throw new InventoryException("Invalid product Id");
	    }
	    System.out.println("Enter new quantity");
	    int quantity = sc.nextInt();
	    InventoryItem inv = inventory.get(pid);
	    inv.setQuantity(quantity);
	    System.out.println("Sucessful update");
		
	}

	@Override
	public void displayInventory() {
		System.out.println("Inventory");
		for(InventoryItem item:inventory.values())
		{
			Product product = item.getProduct();
			Category category = product.getCategory();
			System.out.println("Product Id:"+product.getId()+"\n"+"Product Name:"+product.getName()+"\n"+"Category:"+category.getName()+"\n"+"Price:"+product.getPrice()+"\n"+"Quantity:"+item.getQuantity());
			System.out.println("--------------------------------------------");
			
		}
		
		
	}

	@Override
	public void diaplayTotalValue() {
		double totalvalue=0.0;
		for(InventoryItem item:inventory.values())
		{
			Product product = item.getProduct();
			double price = product.getPrice();
			int quantity = item.getQuantity();
			totalvalue+=(price*quantity);
		}
		System.out.println("Total Inventory Value:Rs"+totalvalue);
	}

	@Override
	public void searchByName() {
		System.out.println("Enter name for searching");
		String sname = sc.nextLine();
		
		for(Product product:products)
		{
			
			if(product.getName().equalsIgnoreCase(sname))
			{
				System.out.println("Product Id:"+product.getId()+"\n"+"Product Name:"+product.getName()+"\n"+"Category:"+product.getCategory().getName()+"\n"+"Price:"+product.getPrice());

			}
			System.out.println("Sucessful searching product to name");
		}
		
	}

	@Override
	public void searchByCategory() {
		System.out.println("Enter the category for search");
		String category = sc.nextLine();
		for(Product product:products)
		{
			if(product.getCategory().equals(category))
			{
				System.out.println("Product Id:"+product.getId()+"\n"+"Product Name:"+product.getName()+"\n"+"Category:"+product.getCategory().getName()+"\n"+"Price:"+product.getPrice());

			}
			System.out.println("Sucessful searching product to category");
		}
		
	}

}
