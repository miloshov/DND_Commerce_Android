package com.hajora.dndcommerce;

import android.app.Activity;
import android.content.Intent;
import android.graphics.PixelFormat;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;
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
        TextView txtaddress = (TextView) findViewById(R.id.address);
		TextView txtdescription = (TextView) findViewById(R.id.description);
        Button btn = (Button) findViewById(R.id.register);
        Button location = (Button) findViewById(R.id.location);
		// Locate the ImageView in singleitemview.xml
		ImageView imgflag = (ImageView) findViewById(R.id.image);

		// Set results to the TextViews
        txtname.setText(name);
        txtdate.setText(date);
        txtaddress.setText(address);
        txtdescription.setText(description);
        submitName = txtname.getText().toString();

        final String addressmap = address;
        final String citymap = city;
        final String desc = description;
        final String sharename = name;
        final String sharedate = date;
        location.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String uri = String.format(Locale.ENGLISH, "geo:0,0?q=%s, %s", addressmap,citymap);
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
                intent.setPackage("com.google.android.apps.maps");
                startActivity(intent);
            }
        });
        ImageButton share = (ImageButton) findViewById(R.id.share);
        share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView text = (TextView) findViewById(R.id.text_ask);
                Intent sendIntent = new Intent();
                sendIntent.setAction(Intent.ACTION_SEND);
                sendIntent.putExtra(Intent.EXTRA_TEXT, sharename + "\n" + sharedate +"\n" + desc);
                sendIntent.setType("text/plain");
                startActivity(sendIntent);
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
        getWindow().setFormat(PixelFormat.RGBA_8888);
		// Capture position and set results to the ImageView
		// Passes flag images URL into ImageLoader.class
        imageLoader.DisplayImage(image, imgflag);


	}
    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION,WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        if (hasFocus) {
            getWindow().getDecorView().setSystemUiVisibility(
                    View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                            | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                            | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                            | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                            | View.SYSTEM_UI_FLAG_FULLSCREEN
                            | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
        }
    }

}