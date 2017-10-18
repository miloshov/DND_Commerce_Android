package com.hajora.dndcommerce;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.webkit.WebView;
import android.widget.ImageButton;
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

		Typeface font = Typeface.createFromAsset(getAssets(), "fonts/poppins.ttf");
		txtname.setTypeface(font);
		txtdate.setTypeface(font);

		// Locate the ImageView in singleitemview.xml
		ImageView imgflag = (ImageView) findViewById(R.id.imagen);
		WebView webView = (WebView) findViewById(R.id.webView1);
		String myData = "<html>\n<head>\n<style type=\"text/css\">\n@font-face {\nfont-family: MyFont;\nsrc: url(\"file:///android_asset/fonts/poppins.ttf\")\n}\nbody {\nfont-family: MyFont;\nfont-size: medium;\ntext-align: justify;\n}\n</style>\n</head>\n<body>";
		myData += description;
		myData += "</body></html>";
		webView.loadDataWithBaseURL("", myData,"text/html", "utf-8", null);
		// Set results to the TextViews
        txtname.setText(name);
        txtdate.setText(date);

        final String desc = description;
        final String sharename = name;
        final String sharedate = date;
        // Capture position and set results to the ImageView
		// Passes flag images URL into ImageLoader.class
		imageLoader.DisplayImage(image, imgflag);
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