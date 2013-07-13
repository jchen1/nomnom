package com.example.nomnom;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.app.ActionBar.Tab;
import com.actionbarsherlock.app.SherlockActivity;
import com.actionbarsherlock.app.SherlockFragmentActivity;
import com.actionbarsherlock.internal.app.ActionBarImpl;
import com.actionbarsherlock.internal.app.ActionBarWrapper;
import com.actionbarsherlock.view.Menu;

//import android.app.ActionBar;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.MenuInflater;

public class MainActivity extends SherlockFragmentActivity {
public static Context appContext;
 
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
 
       //ActionBar gets initiated
        ActionBar actionbar = getSupportActionBar();
        
      //Tell the ActionBar we want to use Tabs.
        actionbar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
        actionbar.setDisplayShowHomeEnabled(false);
        actionbar.setDisplayShowTitleEnabled(false);
        
      //initiating both tabs and set text to it.
        ActionBar.Tab BalanceTab = actionbar.newTab().setText("Balances");
        ActionBar.Tab HistoryTab = actionbar.newTab().setText("History");
        
 
     //create the two fragments we want to use for display content
        BalanceFragment balanceFragment = new BalanceFragment();
        HistoryFragment historyFragment = new HistoryFragment();
 
    //set the Tab listener. Now we can listen for clicks.
        BalanceTab.setTabListener(new MyTabsListener(balanceFragment));
        HistoryTab.setTabListener(new MyTabsListener(historyFragment));
        
   //add the two tabs to the actionbar
        
        actionbar.addTab(BalanceTab);
        actionbar.addTab(HistoryTab);
        
        actionbar.setLogo(R.drawable.ic_icon);
        if (actionbar instanceof ActionBarWrapper) {
            try {
                Field actionBarField = actionbar.getClass().getDeclaredField("mActionBar");
                actionBarField.setAccessible(true);
                enableEmbeddedTabs(actionBarField.get(actionbar));
            } catch (Exception e) {
               
            }
        }


    }
    
    //helper method
    private void enableEmbeddedTabs(Object actionBar) {
        try {
            Method setHasEmbeddedTabsMethod = actionBar.getClass().getDeclaredMethod("setHasEmbeddedTabs", boolean.class);
            setHasEmbeddedTabsMethod.setAccessible(true);
            setHasEmbeddedTabsMethod.invoke(actionBar, true);
        } catch (Exception e) {
           
        }
    }
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getSupportMenuInflater().inflate(R.menu.mymenu, menu);
        return true;
    }
    

}