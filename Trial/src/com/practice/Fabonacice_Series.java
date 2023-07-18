package com.practice;
import java.util.Scanner;
public class Fabonacice_Series {

	public static void main(String[] args) {
		
		
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter number");
		int n=sc.nextInt();
		int a=1;
		int b=2;
		System.out.print(a+","+b+",");
		for(int i=0;i<(n/2)-1;i++)
		{
			int temp=b;
			b=a+b;
			System.out.print(a+","+b+",");
			a=temp;
		}

	}

}
