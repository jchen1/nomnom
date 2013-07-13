package com.example.nomnom;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.Menu;
import android.view.MenuInflater;

public class MainActivity extends Activity {
public static Context appContext;
 
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
 
       //ActionBar gets initiated
        ActionBar actionbar = getActionBar();
      //Tell the ActionBar we want to use Tabs.
        actionbar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
      //initiating both tabs and set text to it.
        ActionBar.Tab BalanceTab = actionbar.newTab().setText("Balances");
        ActionBar.Tab HistoryTab = actionbar.newTab().setText("History");
        ActionBar.Tab AddTransTab = actionbar.newTab().setIcon(R.drawable.ic_add);
 
     //create the two fragments we want to use for display content
        android.app.Fragment balanceFragment = new BalanceFragment();
        android.app.Fragment historyFragment = new HistoryFragment();
        android.app.Fragment addTransFragment = new AddTransFragment();
 
    //set the Tab listener. Now we can listen for clicks.
        BalanceTab.setTabListener(new MyTabsListener(balanceFragment));
        HistoryTab.setTabListener(new MyTabsListener(historyFragment));
        AddTransTab.setTabListener(new MyTabsListener(addTransFragment));
        
   //add the two tabs to the actionbar
        actionbar.addTab(BalanceTab);
        actionbar.addTab(HistoryTab);
        actionbar.addTab(AddTransTab);
        
        actionbar.setDisplayShowHomeEnabled(false);
        actionbar.setDisplayShowTitleEnabled(false);
    }

}