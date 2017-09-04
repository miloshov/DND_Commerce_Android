package com.hajora.dndcommerce;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Locale;

public class SingleItemViewEducation extends Activity {
	// Declare Variables
	String name;
	String date;
	String description;
	String image;
	String address;
    String city;
	String lat;
	String lon;
	ImageLoader imageLoader = new ImageLoader(this);

    String submitName;
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// Get the view from singleitemview.xml
		setContentView(R.layout.singleitemview_education);

		final Intent i = getIntent();
		// Get the result of rank
		name = i.getStringExtra("name");
		// Get the result of country
		date = i.getStringExtra("date");
		// Get the result of population
		description = i.getStringExtra("description");
		// Get the result of flag
		image = i.getStringExtra("image");
		// Get the result of address
        address = i.getStringExtra("address");
        // Get the result of address
        city = i.getStringExtra("city");
		// Get the result of lat
        lat = i.getStringExtra("lat");
		// Get the result of lon
        lon = i.getStringExtra("lon");

		// Locate the TextViews in singleitemview.xml
        TextView txtname = (TextView) findViewById(R.id.name);
		TextView txtdate = (TextView) findViewById(R.id.date);
		TextView txtdescription = (TextView) findViewById(R.id.description);
        Button btn = (Button) findViewById(R.id.register);
        Button location = (Button) findViewById(R.id.location);
		// Locate the ImageView in singleitemview.xml
		ImageView imgflag = (ImageView) findViewById(R.id.image);

		// Set results to the TextViews
        txtname.setText(name);
        txtdate.setText(date);
        txtdescription.setText(description);
        submitName = txtname.getText().toString();

        final String addressmap = address;
        final String citymap = city;
        location.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String uri = String.format(Locale.ENGLISH, "geo:0,0?q=%s, %s", addressmap,citymap);
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
                intent.setPackage("com.google.android.apps.maps");
                startActivity(intent);
            }
        });



                btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Create the bundle
                Bundle bundle = new Bundle();
                //Add your data from getFactualResults method to bundle
                bundle.putString("submitName", submitName);
                //Add the bundle to the intent
                i.setClass(SingleItemViewEducation.this, Submit.class);
                i.putExtras(bundle);
                startActivity(i);
            }
        });

		// Capture position and set results to the ImageView
		// Passes flag images URL into ImageLoader.class
		imageLoader.DisplayImage(image, imgflag);

	}

}