package com.example.nomnom;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Random;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

public class BalanceFragment extends ListFragment {

	String[] columnTags = new String[] {"Name", "Balance", "Description"};
	int[] columnIds = new int[] {R.id.col1, R.id.col2, R.id.descText};
	
	private ListView lv;
	ArrayList<BalanceHolder> testList;
	public ArrayList<BalanceHolder> newList;
	ArrayList<HashMap<String, String>> listData;
	HashMap<String, String> map;
	SimpleAdapter arrayAdapter;
	boolean constructed = false;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, 
        Bundle savedInstanceState) {
    	
    	View v = inflater.inflate(R.layout.balance_fragment, container, false);
        // Inflate the layout for this fragment
    	//TextView t = (TextView) v.findViewById(R.id.frag_balance);
    	//t.setText("aoeirgjaeoijaoeihjoaieth");
    	if (testList == null)
    		testList = new ArrayList<BalanceHolder>();
    	listData = new ArrayList<HashMap<String, String>>();
    	map = new HashMap<String, String>();
    	if (testList.size() == 0)
    	{
	    	Calendar c = Calendar.getInstance();
	    	c.setTimeInMillis(c.getTimeInMillis() - 4000);
	    	BalanceHolder bh = new BalanceHolder("Barack Obama", -100.0f, (Calendar) c.clone());
	    	bh.setDetails("Lost basketball");
	    	testList.add(bh);
	    	c.setTimeInMillis(c.getTimeInMillis() - 100000);
	    	bh = new BalanceHolder("George W. Bush", 150.0f, (Calendar) c.clone());
	    	bh.setDetails("Poker night");
	    	testList.add(bh);
	    	c.setTimeInMillis(c.getTimeInMillis() - 150000);
	    	bh = new BalanceHolder("Bill Clinton", 12.22f, (Calendar) c.clone());
	    	bh.setDetails("Monica's fee");
	    	testList.add(bh);
	    	c.setTimeInMillis(c.getTimeInMillis() - 175000);
	    	testList.add(new BalanceHolder("George H.W. Bush", -5155.54f, (Calendar) c.clone(), "those ears though"));
	    	c.setTimeInMillis(c.getTimeInMillis() - 1750000);
	    	testList.add(new BalanceHolder("Ronald Reagan", 0.01f, (Calendar) c.clone(), "california gurls"));
	    	c.setTimeInMillis(c.getTimeInMillis() - 17500000);
	    	testList.add(new BalanceHolder("Jimmy Carter", -58.3f, (Calendar) c.clone(), "jimmy no"));
	    	c.setTimeInMillis(c.getTimeInMillis() - 175000000);
	    	testList.add(new BalanceHolder("Gerald Ford", 145.4f, (Calendar) c.clone(), "i don't even know"));
	    	c.setTimeInMillis(c.getTimeInMillis() - 175000000);
	    	testList.add(new BalanceHolder("Richard Nixon", -1404f, (Calendar) c.clone(), "lost the watergate bet"));
	    	c.setTimeInMillis(c.getTimeInMillis() - 1750000000);
	    	testList.add(new BalanceHolder("Lyndon Johnson", 2464, (Calendar) c.clone(), "vietcong"));
	    	c.setTimeInMillis(c.getTimeInMillis() - 1750000000);
	    	testList.add(new BalanceHolder("John F. Kennedy", -45.5f, (Calendar) c.clone(), "2soon"));
	    	c.setTimeInMillis(c.getTimeInMillis() - 1750000000);
	    	testList.add(new BalanceHolder("Dwight Eisenhower", 3934.5, (Calendar) c.clone(), "last general"));
	    	c.setTimeInMillis(c.getTimeInMillis() - 1750000000);
	    	testList.add(new BalanceHolder("Harry Truman", 12.23, (Calendar) c.clone(), "idkman"));
	    	c.setTimeInMillis(c.getTimeInMillis() - 1750000000);
	    	testList.add(new BalanceHolder("Franklin Roosevelt", 2515, (Calendar) c.clone(), "16years"));
	    	c.setTimeInMillis(c.getTimeInMillis() - 1750000000);
	    	testList.add(new BalanceHolder("Herbert Hoover", -134.54, (Calendar) c.clone(), "depressed"));
	    	c.setTimeInMillis(c.getTimeInMillis() - 1750000000);
	    	testList.add(new BalanceHolder("Calvin Coolidge", -135, (Calendar) c.clone(), "???"));
	    	c.setTimeInMillis(c.getTimeInMillis() - 1750000000);
	    	testList.add(new BalanceHolder("Warren G. Harding", 136, (Calendar) c.clone(), "????????"));
	    	c.setTimeInMillis(c.getTimeInMillis() - 1750000000);
	    	testList.add(new BalanceHolder("Woodrow Wilson", -875, (Calendar) c.clone(), "ww1"));
	    	c.setTimeInMillis(c.getTimeInMillis() - 1750000000);
	    	testList.add(new BalanceHolder("William Taft", 22222, (Calendar) c.clone(), "fatso"));
	    	c.setTimeInMillis(c.getTimeInMillis() - 1750000000);
	    	testList.add(new BalanceHolder("Teddy Roosevelt", 113, (Calendar) c.clone(), "badass of the highest order"));
	    	c.setTimeInMillis(c.getTimeInMillis() - 1750000000);
	    	testList.add(new BalanceHolder("William McKinley", -57.53, (Calendar) c.clone(), "who"));
	    	c.setTimeInMillis(c.getTimeInMillis() - 1750000000);
	    	testList.add(new BalanceHolder("Grover Cleveland", 35.5, (Calendar) c.clone(), "nonconsecutive"));
	    	c.setTimeInMillis(c.getTimeInMillis() - 1750000000);
	    	testList.add(new BalanceHolder("Benjamin Harrison", 1, (Calendar) c.clone(), "lol"));
	    	c.setTimeInMillis(c.getTimeInMillis() - 1750000000);
	    	testList.add(new BalanceHolder("Grover Cleveland", 464, (Calendar) c.clone(), "idk what he did though"));
	    	c.setTimeInMillis(c.getTimeInMillis() - 1750000000);
	    	testList.add(new BalanceHolder("Chester Arthur", -55, (Calendar) c.clone(), "aa"));
	    	c.setTimeInMillis(c.getTimeInMillis() - 1750000000);
	    	testList.add(new BalanceHolder("James Garfield", 8, (Calendar) c.clone(), "the cat"));
	    	c.setTimeInMillis(c.getTimeInMillis() - 1750000000);
	    	testList.add(new BalanceHolder("Rutherford Hayes", 4.2, (Calendar) c.clone(), "nope"));
	    	c.setTimeInMillis(c.getTimeInMillis() - 1750000000);
	    	testList.add(new BalanceHolder("Ulysses S. Grant", 23, (Calendar) c.clone(), "war hero"));
	    	c.setTimeInMillis(c.getTimeInMillis() - 1750000000);
	    	testList.add(new BalanceHolder("Andrew Johnson", 52, (Calendar) c.clone(), "impeached"));
	    	c.setTimeInMillis(c.getTimeInMillis() - 1750000000);
	    	testList.add(new BalanceHolder("Abraham Lincoln", 5.9, (Calendar) c.clone(), "mr. no slaves"));
	    	c.setTimeInMillis(c.getTimeInMillis() - 1750000000);
	    	testList.add(new BalanceHolder("James Buchanan", 1, (Calendar) c.clone(), "idk"));
	    	c.setTimeInMillis(c.getTimeInMillis() - 1750000000);
	    	testList.add(new BalanceHolder("Franklin Pierce", -256, (Calendar) c.clone(), "not him either"));
	    	c.setTimeInMillis(c.getTimeInMillis() - 1750000000);
	    	testList.add(new BalanceHolder("Millard Fillmore", 512f, (Calendar) c.clone(), "sounds uncool"));
	    	c.setTimeInMillis(c.getTimeInMillis() - 1750000000);
	    	testList.add(new BalanceHolder("Zachary Taylor", 1024f, (Calendar) c.clone(), "double first name"));
	    	c.setTimeInMillis(c.getTimeInMillis() - 1750000000);
	    	testList.add(new BalanceHolder("James Polk", -2048f, (Calendar) c.clone(), "polk-a"));
	    	c.setTimeInMillis(c.getTimeInMillis() - 1750000000);
	    	testList.add(new BalanceHolder("John Tyler", 4096f, (Calendar) c.clone(), "double first name again"));
	    	c.setTimeInMillis(c.getTimeInMillis() - 1750000000);
	    	testList.add(new BalanceHolder("William Harrison", 8192f, (Calendar) c.clone(), "william henry harrison"));
	    	c.setTimeInMillis(c.getTimeInMillis() - 1750000000);
	    	testList.add(new BalanceHolder("Martin Van Buren", 16.384f, (Calendar) c.clone(), "vans"));
	    	c.setTimeInMillis(c.getTimeInMillis() - 1750000000);
	    	testList.add(new BalanceHolder("Andrew Jackson", -36.768f, (Calendar) c.clone(), "badass"));
	    	c.setTimeInMillis(c.getTimeInMillis() - 1750000000);
	    	testList.add(new BalanceHolder("John Quincy Adams", -655.35f, (Calendar) c.clone(), "lol quincy"));
	    	c.setTimeInMillis(c.getTimeInMillis() - 1750000000);
	    	testList.add(new BalanceHolder("James Monroe", 1f, (Calendar) c.clone(), "morose monroe"));
	    	c.setTimeInMillis(c.getTimeInMillis() - 1750000000);
	    	testList.add(new BalanceHolder("James Madison", 0.5f, (Calendar) c.clone(), "small dude"));
	    	c.setTimeInMillis(c.getTimeInMillis() - 1750000000);
	    	testList.add(new BalanceHolder("Thomas Jefferson", 2.5f, (Calendar) c.clone(), "farms"));
	    	c.setTimeInMillis(c.getTimeInMillis() - 1750000000);
	    	testList.add(new BalanceHolder("John Adams", -1.25f, (Calendar) c.clone(), "sedition"));
	    	c.setTimeInMillis(c.getTimeInMillis() - 1750000000);
	    	testList.add(new BalanceHolder("George Washington", -.675f, (Calendar) c.clone(), "washington, washington..."));
	    	c.setTimeInMillis(c.getTimeInMillis() - 1750000000);
    	}
    	lv = (ListView) v.findViewById(android.R.id.list);
    	lv.setItemsCanFocus(true);
    	//lv.setAdapter(new ArrayAdapter<Person>(getActivity(), android.R.layout.simple_list_item_2, testList));

    	
    	for (BalanceHolder p: testList)
    	{
    		map.clear();
    		map.put(columnTags[0], p.getName());
    		map.put(columnTags[1], p.getBalanceString());
    		map.put(columnTags[2], (p.getDetails() == "" ? p.timeSinceLastUpdate() : p.getDetails()));
    		listData.add((HashMap<String, String>) map.clone());
    		
    	}
    	arrayAdapter = new SimpleAdapter(getActivity(), listData, R.layout.row, columnTags, columnIds)
    	{
    		@Override
            public View getView(int position, View convertView,
                    ViewGroup parent) {
                View view = super.getView(position, convertView, parent);

                TextView textView=(TextView) view.findViewById(R.id.col2);

                /*YOUR CHOICE OF COLOR*/
                
                textView.setTextColor((textView.getText().charAt(0) == '-') ? Color.rgb(237, 32, 36) : Color.rgb(105, 189, 69));
                
                return view;
            }
    	};
    	lv.setAdapter(arrayAdapter);
    	
    	arrayAdapter.notifyDataSetChanged();
    	
        return v;   
    }
    
    public void updateList(BalanceHolder bh)
    {
    	map.clear();
		map.put(columnTags[0], bh.getName());
		map.put(columnTags[1], bh.getBalanceString());
		map.put(columnTags[2], (bh.getDetails() == "" ? bh.timeSinceLastUpdate() : bh.getDetails()));
		
    	for (BalanceHolder b : testList)
    	{
    		if (b.getName().equals(bh.getName()))
    		{
    			bh.updateBalance(b.getBalance());
    			//ArrayList<HashMap<String, String>> tmp = (ArrayList<HashMap<String, String>>) listData.clone();
    		
    			map.clear();
    			map.put(columnTags[0], bh.getName());
    			map.put(columnTags[1], bh.getBalanceString());
    			map.put(columnTags[2], (bh.getDetails() == "" ? bh.timeSinceLastUpdate() : bh.getDetails()));
    			
    			for (HashMap<String, String> m : listData)
    			{
    				if (m.get(columnTags[0]) == b.getName())
    				{
    					listData.remove(m);
    					listData.add(0, map);
    					
    					
    					testList.remove(b);
    					testList.add(0, bh);
    					
    					arrayAdapter.notifyDataSetChanged();
    					return;
    				}
    			}

    			return;
    		}
    	}
    	
    	map.clear();
		map.put(columnTags[0], bh.getName());
		map.put(columnTags[1], bh.getBalanceString());
		map.put(columnTags[2], (bh.getDetails() == "" ? bh.timeSinceLastUpdate() : bh.getDetails()));
		testList.add(0, bh);
		listData.add(0, (HashMap<String, String>) map.clone());
		//ArrayList<HashMap<String, String>> tmp = (ArrayList<HashMap<String, String>>) listData.clone();
		//listData.clear();
		//listData = (ArrayList<HashMap<String, String>>) tmp.clone();
		arrayAdapter.notifyDataSetChanged();
    }
    
    
}
