package com.practice;
import java.util.*;
public class Xtel {

	public static void main(String[] args) {
		int arr[]= {5,6,10,17,2,8,1};
		int sum=0;
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter choice");
		int choice=sc.nextInt();
		for(int i=0;i<arr.length;i++)
		{
			for(int j=i+1;j<arr.length;j++)
			{
				sum=arr[i]+arr[j];
				if(sum==choice)
				{
					System.out.println((arr[i]+" "+arr[j])+" "+sum);
				}
			}
			
		}

	}

}
