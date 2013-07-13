package com.example.nomnom;

import java.util.Scanner;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

public class AddTransFragment extends DialogFragment {

	MainActivity ma;
	
    public static AddTransFragment newInstance(MainActivity ma) {
    	AddTransFragment frag = new AddTransFragment();
        Bundle args = new Bundle();
        frag.ma = ma;
        frag.setArguments(args);
        return frag;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        // Get the layout inflater
        LayoutInflater inflater = getActivity().getLayoutInflater();
        final View inflator = inflater.inflate(R.layout.add_trans_alert, null);
        
        final EditText name;
		final EditText amount;
        name = (EditText)inflator.findViewById(R.id.username);
        amount = (EditText)inflator.findViewById(R.id.password);

        // Inflate and set the layout for the dialog
        // Pass null as the parent view because its going in the dialog layout
        builder.setView(inflator)
        // Add action buttons
               .setPositiveButton("Add", new DialogInterface.OnClickListener() {
                   @Override
                   public void onClick(DialogInterface dialog, int id) {
                	   //EditText name = (EditText)dialog.findViewById(R.id.username);
                	   String n = name.getText().toString();
                	   double a = new Scanner(amount.getText().toString()).nextDouble();
                	   ma.balanceFragment.updateList(new BalanceHolder(n, a));
                   }
               })
               .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                   public void onClick(DialogInterface dialog, int id) {
                       AddTransFragment.this.getDialog().cancel();
                   }
               });      
        return builder.create();
    }
}