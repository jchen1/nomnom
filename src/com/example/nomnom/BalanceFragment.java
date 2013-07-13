package com.example.nomnom;

import java.util.ArrayList;
import java.util.HashMap;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.SimpleAdapter;

public class BalanceFragment extends android.app.ListFragment {

	String[] columnTags = new String[] {"Name", "Balance"};
	int[] columnIds = new int[] {R.id.col1, R.id.col2};
	ArrayList<HashMap<String, String>> listData = new ArrayList<HashMap<String, String>>();
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, 
        Bundle savedInstanceState) {
    	
    	View v = inflater.inflate(R.layout.balance_fragment, container, false);
        // Inflate the layout for this fragment
    	//TextView t = (TextView) v.findViewById(R.id.frag_balance);
    	//t.setText("aoeirgjaeoijaoeihjoaieth");
    	ArrayList<Person> testList = new ArrayList<Person>();
    	HashMap<String, String> map = new HashMap<String, String>();
    	testList.add(new Person("aefoawirgwr", 25));
    	testList.add(new Person("2", 10));
    	testList.add(new Person("fjj", 100149));
    	for (Integer i = 0; i < 100; i++)
    	{
    		testList.add(new Person(i.toString(), i));
    	}
    	ListView lv = (ListView) v.findViewById(android.R.id.list);
    	//lv.setAdapter(new ArrayAdapter<Person>(getActivity(), android.R.layout.simple_list_item_2, testList));

    	
    	for (Person p: testList)
    	{
    		map.clear();
    		map.put(columnTags[0], p.getName());
    		map.put(columnTags[1], p.getDollarAmount());
    		listData.add((HashMap<String, String>) map.clone());
    		
    	}
    	SimpleAdapter arrayAdapter = new SimpleAdapter(getActivity(), listData, R.layout.row, columnTags, columnIds);
    	lv.setAdapter(arrayAdapter);
    	
        return v;   
    }
    
    
}
