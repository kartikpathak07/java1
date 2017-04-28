package com.techm.ui;

import java.util.Scanner;

import com.techm.domain.TransportService;
import com.techm.domain.Vendor;
import com.techm.exceptions.IllegalDestination;

public class CubicApp 
{

	public static void main(String[] args) 
	{
		boolean flag=true;
		Scanner sc=new Scanner(System.in);

		//Number of vendors needed to be serviced
		System.out.print("How many vendors do you need to service : ");
		int no_of_vendors=sc.nextInt();
		TransportService ts=new TransportService();

		//Details of all the vendors
		try 
		{
			Vendor v[]=new Vendor[no_of_vendors];
			for (int i=0;i<v.length;i++) 
			{
				System.out.print("Enter the name of vendor "+(i+1)+" : ");
				String name=sc.next();
				System.out.print("Enter address of vendor : "+(i+1)+" : ");
				String address=sc.next();
				System.out.print("Enter source location : ");
				String sourceLoc=sc.next();
				System.out.print("Enter destination location : ");
				String destinationLoc=sc.next();

				//Vendor details created
				v[i]=new Vendor(name, address, sourceLoc, destinationLoc);

				System.out.print("Enter the weight of goods : ");
				float weight=sc.nextFloat();
				System.out.print("Enter the type of transport : ");
				String transportType=sc.next();

				//Adding vendor to array list
				ts.addVendor(v[i], weight, transportType);

				//Displaying details of vendor
				if(v[i].toString().equalsIgnoreCase("Invalid data"))
				{
					System.err.println("Invalid data");
				}
				else
				{
					System.out.println("Details of vendor "+(i+1));
					System.out.println(v[i]);
				}
			}
		}

		//Exceptions being handled
		catch (IllegalDestination e)
		{
			System.err.println(e.getMessage());
			System.err.println("Terminating program!!");
			flag=false;
		}

		//Searching for the vendors in the list
		if(flag)
		{
			System.out.print("Enter the name of vendor to be searched : ");
			String searchname=sc.next();
			ts.searchVendor(searchname);
		}
	}
}
