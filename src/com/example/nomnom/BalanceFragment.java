package com.example.nomnom;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Random;

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
    	Calendar c = Calendar.getInstance();
    	c.setTimeInMillis(c.getTimeInMillis() - 4000);
    	testList.add(new BalanceHolder("Barack Obama", -100.0f, (Calendar) c.clone()));
    	c.setTimeInMillis(c.getTimeInMillis() - 100000);
    	testList.add(new BalanceHolder("George W. Bush", 150.0f, (Calendar) c.clone()));
    	c.setTimeInMillis(c.getTimeInMillis() - 150000);
    	testList.add(new BalanceHolder("Bill Clinton", 12.22f, (Calendar) c.clone()));
    	c.setTimeInMillis(c.getTimeInMillis() - 175000);
    	testList.add(new BalanceHolder("George H.W. Bush", -5155.54f, (Calendar) c.clone()));
    	c.setTimeInMillis(c.getTimeInMillis() - 1750000);
    	testList.add(new BalanceHolder("Ronald Reagan", 0.01f, (Calendar) c.clone()));
    	c.setTimeInMillis(c.getTimeInMillis() - 17500000);
    	testList.add(new BalanceHolder("Jimmy Carter", -58.3f, (Calendar) c.clone()));
    	c.setTimeInMillis(c.getTimeInMillis() - 175000000);
    	testList.add(new BalanceHolder("Gerald Ford", 145.4f, (Calendar) c.clone()));
    	c.setTimeInMillis(c.getTimeInMillis() - 175000000);
    	testList.add(new BalanceHolder("Richard Nixon", -1404f, (Calendar) c.clone()));
    	c.setTimeInMillis(c.getTimeInMillis() - 1750000000);
    	lv = (ListView) v.findViewById(android.R.id.list);
    	lv.setItemsCanFocus(true);
    	//lv.setAdapter(new ArrayAdapter<Person>(getActivity(), android.R.layout.simple_list_item_2, testList));

    	
    	for (BalanceHolder p: testList)
    	{
    		map.clear();
    		map.put(columnTags[0], p.getName());
    		map.put(columnTags[1], p.getBalanceString());
    		map.put(columnTags[2], p.timeSinceLastUpdate());
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
		map.put(columnTags[2], bh.timeSinceLastUpdate());
		testList.add(0, bh);
		listData.add(0, (HashMap<String, String>) map.clone());
		arrayAdapter.notifyDataSetChanged();
    }
    
    
}
