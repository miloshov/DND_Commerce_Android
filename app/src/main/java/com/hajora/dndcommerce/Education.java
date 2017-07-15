package com.hajora.dndcommerce;

import android.app.Activity;
import android.app.ProgressDialog;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.widget.SwipeRefreshLayout;
import android.util.Log;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

public class Education extends Activity implements SwipeRefreshLayout.OnRefreshListener {
	// Declare Variables
	JSONObject jsonobject;
	JSONArray jsonarray;
	ListView listview;
	ListViewAdapterEducation adapter;
	ProgressDialog mProgressDialog;
	ArrayList<HashMap<String, String>> arraylist;
	static String NAME = "naziv";
	static String DATE = "datum";
	static String DESCRIPTION = "opis";
	static String IMAGE = "slika";
	static String ADDRESS = "adresa";
    static String CITY = "grad";
	static String LAT = "lat";
	static String LON = "lon";
	private SwipeRefreshLayout swipeLayout;
	@Override
	public void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		// Get the view from listview_main.xml
		setContentView(R.layout.listview_main);

		SwipeRefreshLayout swipeLayout = (SwipeRefreshLayout) findViewById(R.id.swipe_container);
		swipeLayout.setOnRefreshListener(this);
		swipeLayout.setColorSchemeColors(Color.BLUE,Color.RED,Color.GREEN);

		// Execute DownloadJSON AsyncTask
		new DownloadJSON().execute();
	}



	@Override public void onRefresh() {
		new Handler().postDelayed(new Runnable() {
			@Override public void run() {
				new DownloadJSON().execute();
                SwipeRefreshLayout swipeLayout = (SwipeRefreshLayout) findViewById(R.id.swipe_container);
				swipeLayout.setRefreshing(false);
			}
		}, 1000);
	}


	// DownloadJSON AsyncTask
	private class DownloadJSON extends AsyncTask<Void, Void, Void> {

		@Override
		protected void onPreExecute() {
			super.onPreExecute();
			// Create a progressdialog
			mProgressDialog = new ProgressDialog(Education.this);
			// Set progressdialog title
			mProgressDialog.setTitle("Media app");
			// Set progressdialog message
			mProgressDialog.setMessage("Učitavanje u toku");
			mProgressDialog.setIndeterminate(false);
			// Show progressdialog
			mProgressDialog.show();
		}

		@Override
		protected Void doInBackground(Void... params) {
			// Create an array
			arraylist = new ArrayList<HashMap<String, String>>();
			// Retrieve JSON Objects from the given URL address
			jsonobject = JSONfunctions
					.getJSONfromURL("http://gdecemo.byethost33.com/MediaApp/edukacije.php");

			try {
				// Locate the array name in JSON
				jsonarray = jsonobject.getJSONArray("Edukacije");

				for (int i = 0; i < jsonarray.length(); i++) {
					HashMap<String, String> map = new HashMap<String, String>();
					jsonobject = jsonarray.getJSONObject(i);
					// Retrive JSON Objects
					map.put("naziv", jsonobject.getString("naziv"));
					map.put("datum", jsonobject.getString("datum"));
					map.put("opis", jsonobject.getString("opis"));
					map.put("slika", jsonobject.getString("slika"));
					map.put("adresa", jsonobject.getString("adresa"));
                    map.put("grad", jsonobject.getString("grad"));
					map.put("lat", jsonobject.getString("lat"));
					map.put("lon", jsonobject.getString("lon"));
					// Set the JSON Objects into the array
					arraylist.add(map);
				}
			} catch (JSONException e) {
				Log.e("Error", e.getMessage());
				e.printStackTrace();
			}
			return null;
		}

		@Override
		protected void onPostExecute(Void args) {
			// Locate the listview in listview_main.xml
			listview = (ListView) findViewById(R.id.listview);
			// Pass the results into ListViewAdapter.java
			adapter = new ListViewAdapterEducation(Education.this, arraylist);
			// Set the adapter to the ListView
			listview.setAdapter(adapter);
			// Close the progressdialog
			mProgressDialog.dismiss();
		}
	}
}