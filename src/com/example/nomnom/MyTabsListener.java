package com.example.nomnom;

import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.app.ActionBar.Tab;

import android.annotation.TargetApi;
import android.app.ActionBar.TabListener;
import android.os.Build;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.widget.Toast;


class MyTabsListener implements ActionBar.TabListener {
	public Fragment fragment;
	 
	public MyTabsListener(Fragment fragment) {
		this.fragment = fragment;
	}

	@Override
	public void onTabSelected(Tab tab,
			FragmentTransaction ft) {
		// TODO Auto-generated method stub

		ft.replace(R.id.fragment_container, fragment);
	}

	@Override
	public void onTabUnselected(Tab tab,
			FragmentTransaction ft) {
		// TODO Auto-generated method stub
		ft.remove(fragment);
	}

	@Override
	public void onTabReselected(Tab tab,
			FragmentTransaction ft) {
		// TODO Auto-generated method stub
		
	}
 
}
