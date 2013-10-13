package com.vinit.gridimagesearch;

import android.net.Uri;
import android.os.Bundle;
import android.annotation.SuppressLint;
import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.Toast;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

public class SearchActivity extends Activity {

    EditText etSearch;
    Button btSearch;
    GridView gvSearchImages;
    ArrayList<ImageResult> imageResults = new ArrayList<ImageResult>();
    ImageResultArrayAdapter imageAdapter;
    public static final int SOME_INTEGER_ID = 12345;
    public static String etSettingsAdvance = "";
    public static String etSettingsColor = "";
    public static String etSettingsImageType = "";
    public static String etSettingsSiteFilter = "";

    @SuppressLint("NewApi") @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        
        ActionBar actionBar=getActionBar();
        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayShowTitleEnabled(true);
        actionBar.setTitle("Image Search");
        
        setupView();

        imageAdapter = new ImageResultArrayAdapter(this, imageResults);
        gvSearchImages.setAdapter(imageAdapter);
        
      gvSearchImages.setOnItemClickListener(new AdapterView.OnItemClickListener() {
      @Override
      public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
           Intent intent = new Intent(getApplicationContext(), ImageDisplayActivity.class);
          ImageResult curImageResult = imageResults.get(position);
          intent.putExtra("result", curImageResult);
          startActivity(intent);

      }
  });



    }
    
    public boolean onOptionsItemSelected(MenuItem item){
    	
    	switch (item.getItemId()){
    	case R.id.action_settings:
    		Toast.makeText(this,"Clicked on settings", Toast.LENGTH_SHORT).show();
    		
    		startActivityForResult(new Intent(this, SettingsActivity.class), SOME_INTEGER_ID);
    		return true;

    	default:
    		Toast.makeText(this,"something bad happened", Toast.LENGTH_SHORT).show();
    		return true;
    	}
    	
    }
    
    
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
    	Log.w("Something1", "wow");
    	if(requestCode == SOME_INTEGER_ID){
    		Log.w("Something1", "wow1");
    		if(resultCode == RESULT_OK){
    			Log.w("Something1", "wow2");
//    			EditText etSettingsAdvance;
//    			EditText etSettingsColor;
//    			EditText etSettingsImageType;
//    			EditText etSettingsSiteFilter;
    			//Log.w("Something1", data.getStringExtra("etSettingsAdvance"));
    		//	Log.w("Something1", data.getStringExtra("etSettingsColor"));
//    			Log.w("Something1", data.getStringExtra("etSettingsImageType"));
//    			Log.w("Something1", data.getStringExtra("etSettingsSiteFilter"));
    			Log.w("Something1", "wowx"+data.getStringExtra("one"));
    			
    			
//    			
//    			if(data.hasExtra("advance")) {
//    				Log.w("Something1", "1000");
//        			    				
//    			if(  data.getStringExtra("advance") == null || data.getStringExtra("advance").equals("")){
//    				Log.w("Something1", "11000");
//    			}else{
//    				Log.w("Something1", "wow3");
//    				etSettingsAdvance = data.getStringExtra("advance");
//    			}
//    			}
    			
    			   Bundle bundle = data.getExtras();
    			    if (bundle != null) {
    			        Set<String> keys = bundle.keySet();
    			        Iterator<String> it = keys.iterator();
    			        Log.w("Something1","Dumping Intent start");
    			        
    			        while (it.hasNext()) {
    			            String key = it.next();
    			            Log.w("Something1","[" + key + "=" + bundle.get(key)+"]");
    			        }
    			        
    			        if(bundle.get("color") != null){
    			        	Log.w("Something1","[color1=" + bundle.get("color")+"]");
    	    			        	
    			        	etSettingsColor= bundle.get("color").toString();
    			        }

    			        if(bundle.get("advance") != null){
    			        	Log.w("Something1","[advance1=" + bundle.get("advance")+"]");
    	    			        	
    			        	etSettingsAdvance= bundle.get("advance").toString();
    			        }
    			        if(bundle.get("imagetype") != null){
    			        	Log.w("Something1","[imagetype1=" + bundle.get("imagetype")+"]");
    	    			        	
    			        	etSettingsImageType= bundle.get("imagetype").toString();
    			        }
    			        if(bundle.get("filter") != null){
    			        	Log.w("Something1","[filter1=" + bundle.get("filter")+"]");
    	    			        	
    			        	etSettingsSiteFilter= bundle.get("filter").toString();
    			        }
 
    			        
    			        
    			        Log.w("Something1","Dumping Intent end");
    			    }
    					
//    			if(data.hasExtra("color")) {
//    				Log.w("Something1", "2000"+data.getStringExtra("color"));
//    			if( data.getStringExtra("color") == null || data.getStringExtra("color").equals("")){
//    				Log.w("Something1", "22000");
//    			}else{
//    				Log.w("Something1", "wow4");
//    				etSettingsColor = data.getStringExtra("color");
//    			}
//    			}
//    			
//    			if(data.hasExtra("imagetype")) {
//    				Log.w("Something1", "3000");
//    			if( data.getStringExtra("imagetype") == null || data.getStringExtra("imagetype").equals("")){
//    				Log.w("Something1", "33000");
//    			}else{
//    				Log.w("Something1", "wow5");
//    				etSettingsImageType = data.getStringExtra("imagetype");
//    			}
//    			}
//    			
//    			if(data.hasExtra("filter")) {
//    				Log.w("Something1", "4000");
//    			if( data.getStringExtra("filter") == null || data.getStringExtra("filter").equals("")){
//    				Log.w("Something1", "44000");
//    			}else{
//    				Log.w("Something1", "wow6");
//    				etSettingsSiteFilter = data.getStringExtra("filter");
//    			}
//    			}
    		}
    	}
    }

    
    public static String getApiUrl(){
    	//"https://ajax.googleapis.com/ajax/services/search/images?v=1.0&rsz=8&start="+0+"&q="+ Uri.encode(query),
        //         client.get("https://ajax.googleapis.com/ajax/services/search/images?v=1.0&q=Vinit",
    	String url = "https://ajax.googleapis.com/ajax/services/search/images?v=1.0&rsz=8";
    	
    	if( !(etSettingsSiteFilter == null || etSettingsSiteFilter.equals(""))){
    		url=url.concat("&as_sitesearch="+etSettingsSiteFilter);
    		Log.w("Something",url);
    	}
    	if( !(etSettingsImageType == null || etSettingsImageType.equals(""))){
    		url=url.concat("&imgtype="+etSettingsImageType);
    		Log.w("Something",url);
    	}    		
    	if( !(etSettingsColor == null || etSettingsColor.equals(""))){
    		url=url.concat("&imgcolor="+etSettingsColor);
    		Log.w("Something",url);
    	}
    	if( !(etSettingsAdvance == null || etSettingsAdvance.equals(""))){
    		url=url.concat("&imgsz="+etSettingsAdvance);
    		Log.w("Something",url);
    	}
    
    	url = url.concat("&start=");
    	
    	return url;
    }
    
    
    public void setupView(){
        etSearch = (EditText) findViewById(R.id.et_search);
        btSearch = (Button) findViewById(R.id.btSearch);
        gvSearchImages = (GridView) findViewById(R.id.gvSearchImages);


    }
    
    
    public void onImageSearch(View v){

        String query = etSearch.getText().toString();
        Log.d("Something", query);
        Toast.makeText(this, "Searching for "+query, Toast.LENGTH_SHORT).show();

        AsyncHttpClient client = new AsyncHttpClient();
        Log.d("Something", "0");
//         https://ajax.googleapis.com/ajax/services/search/images?v=1.0&q=Vinit
////        client.get("https://ajax.googleapis.com/ajax/services/search/images?v=1.0&rsz=8&start="+0+"&q="+ Uri.encode(query),
       //         client.get("https://ajax.googleapis.com/ajax/services/search/images?v=1.0&q=Vinit",
		//////client.get(getApiUrl().concat(Integer.toString(this.getSearchStartIndex(v)))+"&q="+ Uri.encode(query),
        client.get(getApiUrl()+0+"&q="+ Uri.encode(query),

        		new JsonHttpResponseHandler(){
                    @Override
                    public void onSuccess(JSONObject response){
                        JSONArray imageJsonResults = null;
                        try{
                            Log.d("Something", " 1");
                            imageJsonResults = response.getJSONObject("responseData").getJSONArray("results");
                            Log.d("Something", " 2");

//                           
//                       	 if(getCurrentFocus().getId() == R.id.btSearch){
//
//                             imageResults.clear();
//                           }else if(getCurrentFocus().getId() == R.id.btLoadMoreImages){
//                    		//  searchStartIndex = imageAdapter.getCount()+1;
//                    	 }
                            imageResults.clear();
                            
                            Log.d("Something", " 3");

                            imageAdapter.addAll(ImageResult.fromJSONArray(imageJsonResults));
                            Log.d("Something", imageResults.toString());

                        }catch (JSONException e){
                            e.printStackTrace();
                        }



                    }

                });




    }


    public int getSearchStartIndex(View v){
    	 int searchStartIndex=0;
    	 if(v.getId() == R.id.btSearch){
    		 //Not changing the id
    	 }else if(v.getId() == R.id.btLoadMoreImages){
    		  searchStartIndex = imageAdapter.getCount()+1;
    	 }else{
    		 //Do Nothing
    	 }
    	 
    	 return searchStartIndex;
    }
    
    public void onLoadMoreImages(View v){

        String query = etSearch.getText().toString();
        int searchStartIndex=0;
        Log.d("Something", query);
        Toast.makeText(this, "Searching for "+query, Toast.LENGTH_SHORT).show();
        
        searchStartIndex = imageAdapter.getCount()+1;
        
        Log.d("Something", "current image count"+Integer.toString(imageAdapter.getCount()));
        Log.d("Something", "current image count"+Integer.toString(searchStartIndex));
         

        AsyncHttpClient client = new AsyncHttpClient();
        Log.d("Something", "0");
//         https://ajax.googleapis.com/ajax/services/search/images?v=1.0&q=Vinit
////        client.get("https://ajax.googleapis.com/ajax/services/search/images?v=1.0&rsz=8&start="+searchStartIndex+"&q="+ Uri.encode(query),
       //         client.get("https://ajax.googleapis.com/ajax/services/search/images?v=1.0&q=Vinit",
        		 client.get(getApiUrl()+searchStartIndex+"&q="+ Uri.encode(query),

        		new JsonHttpResponseHandler(){
                    @Override
                    public void onSuccess(JSONObject response){
                        JSONArray imageJsonResults = null;
                        try{
                            Log.d("Something", " 1");
                            imageJsonResults = response.getJSONObject("responseData").getJSONArray("results");
                            Log.d("Something", " 2");

                           // imageResults.clear();
                            Log.d("Something", " 3");

                            imageAdapter.addAll(ImageResult.fromJSONArray(imageJsonResults));
                            Log.d("Something", imageResults.toString());

                        }catch (JSONException e){
                            e.printStackTrace();
                        }



                    }

                });




    }
    
    
    
    
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.settings, menu);
        return true;
    }

}