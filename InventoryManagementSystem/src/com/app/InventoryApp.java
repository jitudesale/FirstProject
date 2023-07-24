package com.app;
import java.util.Scanner;

import com.dao.InventoryException;
import com.implement.InventoryManager;
public class InventoryApp {

	public static void main(String[] args) throws InventoryException {
		InventoryManager iv = new InventoryManager();
		Scanner sc = new Scanner(System.in);
		char choice;
		do {
			System.out.println("Inventory Management Service");
			System.out.println("1. addProduct\2. removeProduct\3. updateInventory\4. displayInventory\5. displayTotalValue\6. searchByName\7. searchByCategory");
			System.out.println("Enter Index");
			int index = sc.nextInt();
			switch(index)
			{
			case 1:
				iv.addProduct();
				break;
			case 2:
				iv.removeProduct();
				break;
			case 3:
				iv.displayInventory();
				break;
			case 4:
				iv.diaplayTotalValue();
				break;
			case 5:
				iv.searchByName();
				break;
			case 6:
				iv.searchByCategory();
				break;
			case 0:
				System.out.println("Exist..........");
				System.exit(0);
				default:
					System.out.println("Enter valid choice");
					//break;
					
			}
			System.out.println("Do you want to continue if yes press Y or y");
			choice=sc.next().charAt(0);
		}while(choice=='Y'||choice=='y');

	}

}
