package com.hajora.dndcommerce;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

/**
 * Created by nikol on 11-Jul-17.
 */

public class Contact extends Activity {
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Get the view from contact.xml
        setContentView(R.layout.contact);

    }
    public void call(View v){
        Intent call = new Intent(Intent.ACTION_DIAL);
        call.setData(Uri.parse("tel:0377778888"));
        startActivity(call);
    }
}
