package com.hajora.dndcommerce;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import static android.R.attr.text;

/**
 * Created by nikol on 05-Sep-17.
 */

public class Ask extends Activity {
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



/*        getWindow().getDecorView().setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);*/

        // Get the view from contact.xml
        setContentView(R.layout.ask);
    Button send = (Button) findViewById(R.id.send_ask);
    send.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            TextView name = (TextView) findViewById(R.id.name_ask);
            TextView email = (TextView) findViewById(R.id.email_ask);
             TextView text = (TextView) findViewById(R.id.text_ask);
            Intent emailIntent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts("mailto", email.getText().toString() , null));
            emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Kontakt:"+name.getText().toString());
            emailIntent.putExtra(Intent.EXTRA_TEXT, text.getText().toString() );
            startActivity(Intent.createChooser(emailIntent, "Pošalji..."));
        }
    });
        ImageButton share = (ImageButton) findViewById(R.id.share);
        share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView text = (TextView) findViewById(R.id.text_ask);
                Intent sendIntent = new Intent();
                sendIntent.setAction(Intent.ACTION_SEND);
                sendIntent.putExtra(Intent.EXTRA_TEXT, text.getText().toString());
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