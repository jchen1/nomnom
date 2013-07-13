package com.example.nomnom;

import java.util.Date;

public class Person {
	private String name;
	private double amount;
	private boolean bModifiedAmount;
	
	public Person(String name, double amount)
	{
		this.name = name;
		this.amount = amount;
		this.bModifiedAmount = false;
	}
	
	public double getAmount()
	{
		return amount;
	}
	
	public String getName()
	{
		return name;
	}
	
	public void setAmount(double newAmount)
	{
		this.amount = newAmount;
		bModifiedAmount = true;
	}
	
	public void setAutoAmount(double newAmount)
	{
		this.amount = newAmount;
		bModifiedAmount = false;
	}
	
	public boolean hasModifiedAmount()
	{
		return bModifiedAmount;
	}
	
	public boolean isEquals(Person other)
	{
		return (other.name == this.name);
	}

	public Date getDate() {
		// TODO Auto-generated method stub
		return new Date();
	}
}