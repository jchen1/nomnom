package com.example.nomnom;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class HistoryFragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, 
        Bundle savedInstanceState) {
    	
    	View v = inflater.inflate(R.layout.history_fragment, container, false);
        // Inflate the layout for this fragment

    	
        return v;   
    }
    
    
    
}
