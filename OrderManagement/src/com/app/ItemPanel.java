package com.app;
import java.util.Scanner;

import com.dao.ItemDao;
import com.daoimpl.ItemDaoImpl;
import com.entity.Item;

public class ItemPanel {
	
	static Scanner sc= new Scanner(System.in);
	
	public static void main(String[] args) {
		
		int ch;
		do
		{
			System.out.println("-------------Item Panel------------------------");
			System.out.println("1. Add Item");
			System.out.println("2. Delete Item");
			System.out.println("3. Update Item cost");
			System.out.println("4. Display all items");
			System.out.println("5. Search item by id");
			System.out.println("6. Exit Item Panel");
		    
			ItemDao iobj= new ItemDaoImpl();
			Item i= new Item();
			ch= sc.nextInt();
		
			switch(ch)
			{
			case 1: iobj.addItem();
			        break;
			        
			case 6: MyApp.main(null); 
			       break;
			 default: System.out.println("error....");      
			
			}
			
		}while(ch!=6);
		
		
		
	}
	

}


