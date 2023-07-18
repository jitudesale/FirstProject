package com.practice;
import java.util.*;
public class Palimdrom {
	public static void palimdrom(int num)
	{
		int temp=num;
		int sum = 0;
		while(num>0)
		{
			int digit=num%10;
			sum=sum*10+digit;
			num=num/10;
		}
		if(sum==temp)
		{
			System.out.println("is palimdrom");
		}
		else
		{
			System.out.println("is not palimdrom");
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter num");
		int num = sc.nextInt();
		int temp = num;
		int sum=0;
		for(int i=0;i<=num;i++)
		{
			int digit=num%10;
			sum=sum*10+digit;
			num = num/10;
		}
		if(temp==sum)
		{
			System.out.println("is palimdrom");
		}
		else
		{
			System.out.println("is not palimdrom");
		}
		Palimdrom.palimdrom(num);

	}

}
