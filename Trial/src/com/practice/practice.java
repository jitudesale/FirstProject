package com.practice;
import java.util.*;
public class practice {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String []str= {"i","am","vary","smart"};
		String str2=String.join("", str);//join method use to convert String Array to String
		System.out.println(str2);
		System.out.println("Enter split index");
		int n=sc.nextInt();
		String[] str3 = new String[str.length];
		int j=0;
		
		for(int i=0;i<str2.length();i++)
		{
			if(i%n==0)
			
			    System.out.print("\n");
			    System.out.print(+str2.charAt(i));
			   // j++;
			
			
				
				//str3[j]=str3[j]+str2.charAt(i);
				
		}
		//System.out.println(Arrays.toString(str3));

	}

}
