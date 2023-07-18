package com.practice;

public class Prac {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		for(int i=100;i<=200;i++)
		{
			
			if(i%3==0&&i%5==0)
			{
				continue;
			}
			else
			{
				System.out.println(i);
				
			}
		}

	}

}
