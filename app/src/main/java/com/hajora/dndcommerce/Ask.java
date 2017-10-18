package com.hajora.dndcommerce;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;


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
            Typeface font = Typeface.createFromAsset(getAssets(), "fonts/poppins.ttf");
            name.setTypeface(font);
            email.setTypeface(font);
            text.setTypeface(font);
            Intent emailIntent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts("mailto", "info@dndcommerce.rs" , null));
            emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Kontakt:"+name.getText().toString());
            emailIntent.putExtra(Intent.EXTRA_TEXT, text.getText().toString()+"\n"+email.getText().toString());

            startActivity(Intent.createChooser(emailIntent, "Pošalji..."));
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