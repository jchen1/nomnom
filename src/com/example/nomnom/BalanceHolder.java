package com.example.nomnom;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class BalanceHolder {
	private String name, details = "";
	private double balance;
	private Calendar lastModified;
	
	public BalanceHolder(String name, double initialBalance)
	{
		this(name, initialBalance, Calendar.getInstance());
	}
	
	public BalanceHolder(String name, double initialBalance, Calendar date)
	{
		this.name = name;
		this.balance = initialBalance;
		this.lastModified = date;
	}
	
	public BalanceHolder(String name, double initialBalance, Calendar date, String details)
	{
		this.name = name;
		this.balance = initialBalance;
		this.lastModified = date;
		this.details = details;
	}
	
	public BalanceHolder(String encoded)
	{
		Scanner scanner = new Scanner(encoded);
		scanner.useDelimiter("&");
		this.name = scanner.next();
		this.balance = scanner.nextDouble();
		try {
			this.lastModified.setTime(new SimpleDateFormat().parse(scanner.next()));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//Adds balanceModifier to balance
	public void updateBalance(double balanceModifier)
	{
		balance += balanceModifier;
		lastModified = Calendar.getInstance();
	}
	
	public void forceBalance(double balance)
	{
		this.balance = balance;
		lastModified = Calendar.getInstance();
	}
	
	public double getBalance()
	{
		return balance;
	}
	
	public String getBalanceString()
	{
		return String.format("%s$%.2f", balance >= 0 ? "" : "-", Math.abs(balance));
	}
	
	public Calendar getLastModified()
	{
		return lastModified;
	}
	
	public void touch()
	{
		lastModified = Calendar.getInstance();
	}
	
	public String timeSinceLastUpdate()
	{
		long millis = Calendar.getInstance().getTime().getTime() - lastModified.getTime().getTime();
		
		if (millis < 1000)
		{
			return "Just now";
		}
		if (millis < 60 * 1000)
		{
			return String.format("%d second%s ago", millis / 1000, (millis / 1000 == 1) ? "" : "s");
		}
		else if (millis < 60 * 60 * 1000)
		{
			return String.format("%d minute%s ago", millis / (1000 * 60), (millis / (1000 * 60) == 1) ? "" : "s");
		}
		else if (millis < 60 * 60 * 24 * 1000)
		{
			return String.format("%d hour%s ago", millis / (1000 * 60 * 60), (millis / (1000 * 60 * 60) == 1) ? "" : "s");
		}
		else
		{
			return String.format("%d day%s ago", millis / (1000 * 60 * 60 * 24), (millis / (1000 * 60 * 60 * 24) == 1) ? "" : "s");
		}
	}
	
	public String getName()
	{
		return name;
	}
	
	public void setDetails(String details)
	{
		this.details = details;
	}
	
	public String getDetails()
	{
		return details;
	}
	
	public boolean isEquals(BalanceHolder other)
	{
		return (name.equals(other));
	}
	
	public String toString()
	{
		return String.format("%s&%s&%s", name, ((Double)balance).toString(), lastModified.getTime().toString());
	}
}
