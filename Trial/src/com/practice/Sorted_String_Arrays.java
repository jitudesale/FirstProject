package com.practice;
import java.util.*;
public class Sorted_String_Arrays {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String arr[] = { "c", "is", "good", "to", "learn" };
		for(int i=0;i<arr.length;i++)
		{
			for(int j=i+1;j<arr.length;j++)
			{
				if(arr[i].length()>arr[j].length())
				{
				String temp = arr[i];
				arr[i]=arr[j];
				arr[j]=temp;
				}
			}
		}System.out.println(Arrays.toString(arr));


	}

}
