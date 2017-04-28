package com.techm.domain;

import com.techm.exceptions.IllegalDestination;

public class Vendor 
{
	//Attributes of vendors
	private String vendorName;
	private String vendorAddress;
	private String sourceLoc;
	private String destinationLoc;
	private float totalCost;

	//Constructors to set values of vendors from main
	public Vendor(String vendorName, String vendorAddress, String sourceLoc,
			String destinationLoc) throws IllegalDestination 
	{
		if(sourceLoc.equalsIgnoreCase(destinationLoc))
		{
			throw new IllegalDestination("Source and destination cannot be same");
		}
		else
		{
			this.vendorName = vendorName;
			this.vendorAddress = vendorAddress;
			this.sourceLoc = sourceLoc;
			this.destinationLoc = destinationLoc;
		}
	}

	//Getter and setter needed for the methods used
	public void setTotalCost(float totalCost)
	{
		this.totalCost = totalCost;
	}

	public float getTotalCost() {
		return totalCost;
	}

	public String getVendorName() {
		return vendorName;
	}

	//toString() method is overriden
	@Override
	public String toString() 
	{
		if(totalCost>0)
		{
			return "Vendor Name : "+vendorName+"\nAddress : "+vendorAddress+"\nSource Location : "+sourceLoc
					+"\nDestination Location : "+destinationLoc+"\nTotal Cost is : "+totalCost;
		}
		else
		{
			return "Invalid data";
		}
	}
}
