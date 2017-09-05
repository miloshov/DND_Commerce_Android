package com.hajora.dndcommerce;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class SingleItemViewNews extends Activity {
	// Declare Variables
	String name;
	String date;
	String description;
	String image;

	ImageLoader imageLoader = new ImageLoader(this);


	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// Get the view from singleitemview.xml
		setContentView(R.layout.singleitemview_news);

		final Intent i = getIntent();
		// Get the result of rank
		name = i.getStringExtra("name");
		// Get the result of country
		date = i.getStringExtra("date");
		// Get the result of population
		description = i.getStringExtra("details");
		// Get the result of flag
		image = i.getStringExtra("image");


		// Locate the TextViews in singleitemview.xml
        TextView txtname = (TextView) findViewById(R.id.namen);
		TextView txtdate = (TextView) findViewById(R.id.daten);
		TextView txtdescription = (TextView) findViewById(R.id.descriptionn);

		// Locate the ImageView in singleitemview.xml
		ImageView imgflag = (ImageView) findViewById(R.id.imagen);

		// Set results to the TextViews
        txtname.setText(name);
        txtdate.setText(date);
        txtdescription.setText(description);
        // Capture position and set results to the ImageView
		// Passes flag images URL into ImageLoader.class
		imageLoader.DisplayImage(image, imgflag);

	}

}