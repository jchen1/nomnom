package com.example.nomnom;

import java.util.ArrayList;
import java.util.Date;

public class Transaction {
	
	private Date date;
	private ArrayList<Person> people;
	private double totalAmount; //totalAmount = sum(amounts)
	
	
	private class Person {
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
	}
	
	private String details;
	
	public Transaction()
	{
		this(new Date());
	}
	
	public Transaction(Date date)
	{
		this(date, 0);
	}
	
	public Transaction(Date date, double totalAmount)
	{
		this(date, totalAmount, "Default details");
	}
	
	public Transaction(Date date, double totalAmount, String details)
	{
		this(date, totalAmount, details, new ArrayList<Person>());
	}
	
	public Transaction(Date date, double totalAmount, String details, ArrayList<Person> people)
	{
		if (people.size() == 0)
		{
			people.add(new Person("Default name", totalAmount));
		}
			
		this.date = date;
		this.totalAmount = totalAmount;
		this.details = details;
		this.people = people;
	}
	
	public Date getDate() {
		return date;
	}

	public ArrayList<String> getNames() {
		ArrayList<String> names = new ArrayList<String>();
		for (Person p : people)
		{
			names.add(p.getName());
		}
		
		return names;
	}

	public ArrayList<Double> getAmounts() {
		ArrayList<Double> amounts = new ArrayList<Double>();
		for (Person p : people)
		{
			amounts.add(p.getAmount());
		}
		
		return amounts;
	}

	public double getTotalAmount() {
		return totalAmount;
	}

	public String getDetails() {
		return details;
	}
	
	public void addName(String name) {
		if (!getNames().contains(name))
		{
			double autoAmount = totalAmount;
			int autoPeople = people.size();
			for (Person p : people)
			{
				if (p.hasModifiedAmount() == true)
				{
					autoAmount -= p.getAmount();
					autoPeople--;
				}
			}
			double indAmount = totalAmount / autoPeople;
			for (Person p : people)
			{
				if (p.hasModifiedAmount() == false)
				{
					p.setAutoAmount(indAmount);
				}
			}
			people.add(new Person(name, indAmount));
		}
	}

	public Transaction(Date date, double totalAmount, String details, ArrayList<String> names, ArrayList<Double> amounts)
	{
		this.date = date;
		this.totalAmount = totalAmount;
		this.details = details;
		people = new ArrayList<Person>();
		for (int i = 0; i < Math.min(names.size(), amounts.size()); i++)
		{
			people.add(new Person(names.get(i), amounts.get(i)));
		}
	}

}
