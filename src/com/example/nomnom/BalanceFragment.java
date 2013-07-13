package com.example.nomnom;

import java.util.ArrayList;

import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.support.v4.app.LoaderManager.LoaderCallbacks;
import android.support.v4.content.CursorLoader;
import android.support.v4.widget.SimpleCursorAdapter;

public class BalanceFragment extends android.app.ListFragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, 
        Bundle savedInstanceState) {
    	
    	View v = inflater.inflate(R.layout.balance_fragment, container, false);
        // Inflate the layout for this fragment
    	//TextView t = (TextView) v.findViewById(R.id.frag_balance);
    	//t.setText("aoeirgjaeoijaoeihjoaieth");
    	ArrayList<String> testList = new ArrayList<String>();
    	testList.add("aefoawirgwr");
    	testList.add("2");
    	ListView lv = (ListView) v.findViewById(R.id.frag_balance);
    	lv.setAdapter(new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, testList));
    	
        return v;   
    }
    
    
}
