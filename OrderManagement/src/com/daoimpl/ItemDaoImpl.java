package com.daoimpl;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.connect.DBConnection;
import com.dao.ItemDao;
import com.entity.Customer;
import com.entity.Item;

public class ItemDaoImpl implements ItemDao{
	
	Connection con;
	Statement st;
	ResultSet rs;
	PreparedStatement pst;
	
	static Scanner sc= new Scanner(System.in);
	
	public ItemDaoImpl()
	{
		con= DBConnection.getConnect();
		System.out.println("Connection done..............");
		try {
			st= con.createStatement();
		} catch (SQLException e) {
			System.out.println(e);
		}
	}
	

	//@Override
	public void addItem() {
		
		System.out.println("Enter item id:");
		int iid= sc.nextInt();
		System.out.println("Enter item name:");
		String name= sc.next();
		System.out.println("Enter item cost:");
		float cost= sc.nextFloat();
		try
		{
			pst= con.prepareStatement("insert into item values(?,?,?)");
			pst.setInt(1, iid);
			pst.setString(2,name);
		    pst.setFloat(3, cost);
						
			int noOfRowsAdded= pst.executeUpdate();
			if(noOfRowsAdded>0)
			{
				System.out.println("Item added.............");
			}
			else
			{
				System.out.println("Error");
			}
		}
		
		catch(Exception e)
		{
			System.out.println(e);
		}
		
	}

	@Override
	public void deleteItem(int cid) {
		try
		{
			pst= con.prepareStatement("delete from customer where cid=?");
			pst.setInt(1, cid);
			
			int noOfRowsDeleted= pst.executeUpdate();
			if(noOfRowsDeleted>0)
			{
				System.out.println("Customer Deleted.........");
			}
			else
			{
				System.out.println("Error................");
			}
			
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
		
	}

	@Override
	public void updateItem(int cid) {
		 try
	     {
	    	 Customer c= new Customer();
	    	 c= getCustomerById(Cid);
	    	 if(c!=null)
	    	 {
	    	  System.out.println("Customer Old details are:...........................");	 
	         System.out.println(c);		
	         System.out.println(".....................................................");
	         System.out.println("Enter the new mobile number:");
	         long iname= sc.next();
	    	 pst= con.prepareStatement("update customer set name=? where cid=?");
	    	 pst.setLong(1, iname);
	    	 pst.setInt(2, cid);
	    	 
	    	 int noOfRowsUpdated= pst.executeUpdate();
	    	 if(noOfRowsUpdated>0)
	    	 {
	    		 System.out.println("Customer is updated........");
	    	 }
	    	 else
	    	 {
	    		 System.out.println("Error");
	    	 }
	    	
	    	 }
	    	 else
	    	 {
	    		 System.out.println("Customer id doesnot exist..................");
	    	 }
	    	 
	     }
	     catch(Exception e)
	     {
	    	 System.out.println(e);
	     }

   
	}

	@Override
	public Item getItemById(int cid) {
		return null;
	
		
	}

	@Override
	public void displayAllItem() {
		
	
	}
	

}


