package com.vinit.gridimagesearch;

import android.os.Bundle;
import android.annotation.SuppressLint;
import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;




public class SettingsActivity extends Activity {
	
	EditText etSettingsAdvance;
	EditText etSettingsColor;
	EditText etSettingsImageType;
	EditText etSettingsSiteFilter;
	
	@SuppressLint("NewApi")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_settings);
		
		 etSettingsAdvance = (EditText) findViewById(R.id.et_settings_advance);
		 etSettingsColor = (EditText) findViewById(R.id.et_settings_color);
		 etSettingsImageType = (EditText) findViewById(R.id.et_settings_image_type);
		 etSettingsSiteFilter = (EditText) findViewById(R.id.et_settings_site_filter);
		
		
		ActionBar actionBar=getActionBar();
		actionBar.setHomeButtonEnabled(true);
	//	actionBar.setDisplayShowTitleEnabled(true);
		actionBar.setIcon(R.drawable.back_button);
	
		
		
	}

	
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.search, menu);
		
		return true;
	}

	
	
    public boolean onOptionsItemSelected(MenuItem item){
    	
	Toast.makeText(this,"something bad happened", Toast.LENGTH_SHORT).show();
	returnToSearch(0);
   		return true;
    }

    public void returnToSearch(int id){
    	
    	Intent i = new Intent();
    	switch (id){
    	//On Save Button
    	case 1: 	
    		Log.w("Something1","wow Y");
    		Toast.makeText(this,"Save Button Clicked", Toast.LENGTH_SHORT).show();
    		
    		if(etSettingsColor.getText() == null ||  etSettingsColor.getText().equals("")){
    			Log.w("Something1","wow 11");
           		i.putExtra("color", "");
    			
    		}else{
    			Log.w("Something1","wow 111"+etSettingsColor.getText());
    			i.putExtra("color", etSettingsColor.getText());
    			
    		}
    		
    		if(etSettingsAdvance.getText() == null ||  etSettingsAdvance.getText().equals("") ){
    			Log.w("Something1","wow 21");
           		i.putExtra("advance", "");
    			
    		}else{
    			Log.w("Something1","wow 211"+etSettingsAdvance.getText());
           		i.putExtra("advance", etSettingsAdvance.getText());
    			
    		}
       		//i.putExtra("etSettingsAdvance", etSettingsAdvance.getText());
       		
    		
    		if(etSettingsImageType.getText() == null || etSettingsImageType.getText().equals("")){
    			Log.w("Something1","wow 31");
           		i.putExtra("imagetype", "");
    			
           		
    		}else{
    			Log.w("Something1","wow 311"+etSettingsImageType.getText());
    			i.putExtra("imagetype", etSettingsImageType.getText());
    			
    		}
    		//i.putExtra("etSettingsImageType", etSettingsImageType.getText());
       		
    		if(etSettingsSiteFilter.getText() == null || etSettingsSiteFilter.getText().equals("")){
    			Log.w("Something1","wow 41");
           		i.putExtra("filter", "");
    			
    		}else{
    			Log.w("Something1","wow 411"+etSettingsSiteFilter.getText());
           		i.putExtra("filter", etSettingsSiteFilter.getText());
    			
    		}
    		//i.putExtra("etSettingsSiteFilter", etSettingsSiteFilter.getText());
    		i.putExtra("one", "Vinit");
       		setResult(RESULT_OK, i);
       		finish();
    		break;
    	//On Back Button and default
    	default:
    		Log.w("Something1","wow N");
    		Toast.makeText(this,"back Button Clicked", Toast.LENGTH_SHORT).show();
    		
       		
       		setResult(RESULT_CANCELED, i);
       		finish();
    		break;
    		
    		
    	}
    }
	
	public void onSave(View v){
	
		
	
		Toast.makeText(this, "clicked Save", Toast.LENGTH_SHORT).show();
		//Send data back
		// Good boy !!!
		returnToSearch(1);
	   	
	}

}
