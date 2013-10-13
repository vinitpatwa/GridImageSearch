package com.vinit.gridimagesearch;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by vpatwa on 10/11/13.
 */
public class ImageResult implements Serializable{

	private static final long serialVersionUID = 1813407868127791548L;
	private String fullURL;
    private String thumbURL;


    public ImageResult(JSONObject json){

        try{
            this.fullURL = json.getString("url");
            this.thumbURL = json.getString("tbUrl");

        }catch (JSONException e){
            this.fullURL = null;
            this.thumbURL = null;

        }
    }

    public static ArrayList<ImageResult> fromJSONArray(JSONArray imageJsonResults){
        ArrayList<ImageResult> results = new ArrayList<ImageResult>();
        Log.d("Something", " 4");


        for(int i=0;i<imageJsonResults.length();i++){
            try{
              //  Log.d("Something", " 5");

                results.add(new ImageResult(imageJsonResults.getJSONObject(i)));
            }catch (JSONException e){
                e.printStackTrace();
            }
        }
        Log.d("Something", " 6");

        return results;
    }


    public String getFullURL() {
        return fullURL;
    }

    public void setFullURL(String fullURL) {
        this.fullURL = fullURL;
    }

    public String getThumbURL() {
        return thumbURL;
    }
    
    public void setThumbURL(String thumbURL) {
        this.thumbURL = thumbURL;
    }

    public String toString() {
        return  this.thumbURL;
    }


}