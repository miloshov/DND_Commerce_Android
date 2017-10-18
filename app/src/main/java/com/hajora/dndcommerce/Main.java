package com.hajora.dndcommerce;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Toast;

import com.google.firebase.messaging.FirebaseMessaging;

public class Main extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_screen);
        FirebaseMessaging.getInstance().subscribeToTopic("main");

    }

    private boolean isNetworkAvailable() {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }
     public void education(View v) {
         if (isNetworkAvailable()) {
             Intent education = new Intent(this, Education.class);
             startActivity(education);
         } else {
             Toast.makeText(this, "Proverite internet konekciju", Toast.LENGTH_LONG).show();
         }
     }
    public void about(View v){
        Intent about = new Intent(this, About.class);
        startActivity(about);
    }
    public void news(View v) {
        if (isNetworkAvailable()) {
            Intent news = new Intent(this, News.class);
            startActivity(news);
        } else {
            Toast.makeText(this, "Proverite internet konekciju", Toast.LENGTH_LONG).show();
        }
    }
    public void contact(View v){
        Intent contact = new Intent(this, Contact.class);
        startActivity(contact);
    }
    public void call(View v) {
        Intent call = new Intent(Intent.ACTION_DIAL);
        call.setData(Uri.parse("tel:0377778888"));
        startActivity(call);
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
