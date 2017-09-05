package com.hajora.dndcommerce;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.google.firebase.messaging.FirebaseMessaging;

public class Main extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_screen);
        FirebaseMessaging.getInstance().subscribeToTopic("main");

    }
     public void education(View v){
            Intent education = new Intent(Main.this, Education.class);
            startActivity(education);
        }
    public void about(View v){
        Intent about = new Intent(Main.this, About.class);
        startActivity(about);
    }
    public void news(View v){
        Intent news = new Intent(Main.this, News.class);
        startActivity(news);
    }
    public void contact(View v){
        Intent contact = new Intent(Main.this, Contact.class);
        startActivity(contact);
    }
    public void call(View v) {
        Intent call = new Intent(Intent.ACTION_DIAL);
        call.setData(Uri.parse("tel:0377778888"));
        startActivity(call);
    }


}
