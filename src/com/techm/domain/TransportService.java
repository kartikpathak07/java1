package com.techm.domain;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TransportService
{
	//Intialization
	List<Vendor> vendorList=new ArrayList<Vendor>();
	File f=null;
	FileOutputStream fos=null;
	DataOutputStream dos=null;

	//calculateCost() method : Used to calculate the cost depending on transport type and weight
	public float calculateCost(float weight, String transportType)
	{
		float cost=0;
		float totalCost=0;
		float freight=0;
		cost=weight*100;
		if(transportType.equalsIgnoreCase("Airways"))
		{
			freight=(30f/100)*cost;
		}
		else if(transportType.equalsIgnoreCase("Waterways"))
		{
			freight=(12.23f/100)*cost;
		}
		else if(transportType.equalsIgnoreCase("Roadways"))
		{
			freight=(8.46f/100)*cost;
		}
		else
		{
			System.err.println("Invalid transport type");
			return 0;
		}
		totalCost=cost+freight;
		return totalCost;
	}

	//addVendor() method : Used to add the vendor details in the ArrayList
	public void addVendor(Vendor obj, float weight, String transportType)
	{
		float totalCost=calculateCost(weight, transportType);
		//if((transportType.equalsIgnoreCase("Airways"))||(transportType.equalsIgnoreCase("Roadways"))||(transportType.equalsIgnoreCase("Waterways")))
		if(totalCost>0)
		{
			obj.setTotalCost(totalCost);
			vendorList.add(obj);
		}
		else
		{
			System.err.println("Cannot add to list as invalid transport type");
		}
	}

	//searchVendor() method : Used to search the mentioned vendor in the list and the saving his details to vendorDetails.txt file
	public void searchVendor(String vendorName)
	{
		boolean flag=false;
		if(vendorList.isEmpty())
		{
			System.err.println("No vendor available to be searched");
		}
		else
		{
			for(int i=0;i<vendorList.size();i++)
			{
				if(vendorList.get(i).getVendorName().equalsIgnoreCase(vendorName))
				{
					System.out.println("Vendor found and writing details to file");
					f=new File("vendorDetails.txt");
					if(!f.exists())
					{
						try 
						{
							f.createNewFile();
							System.out.println("File Created!!");
						}
						catch (IOException e)
						{
							e.printStackTrace();
						}
					}
					try 
					{
						fos=new FileOutputStream(f,true);
						dos=new DataOutputStream(fos);
						dos.writeBytes("Vendor Name : "+vendorList.get(i).getVendorName()+"\t\t");
						dos.writeBytes("Cost : "+vendorList.get(i).getTotalCost()+"\n");
						flag=true;
						fos.close();
						dos.close();
						System.out.println("Writing completed");
					}
					catch (FileNotFoundException e)
					{
						e.printStackTrace();
					}
					catch (IOException e)
					{
						e.printStackTrace();
					}
				}
			}
			if(flag==false)
			{
				System.err.println("Vendor does not exist");
			}
		}
	}
}
