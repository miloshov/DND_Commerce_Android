package com.hajora.dndcommerce;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by nikol on 05-Sep-17.
 */

public class Ask extends Activity {
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
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
    }

}