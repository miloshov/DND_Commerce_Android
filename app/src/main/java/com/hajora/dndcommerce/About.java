package com.hajora.dndcommerce;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.WindowManager;

/**
 * Created by nikol on 13-Jul-17.
 */

public class About extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.about);
    }
    public void company(View v){
        Intent company = new Intent(About.this, AboutCompany.class);
        startActivity(company);
    }
    public void history(View v){
        Intent history = new Intent(About.this, AboutHistory.class);
        startActivity(history);
    }
    public void partners(View v){
        Intent partners = new Intent(About.this, AboutPartners.class);
        startActivity(partners);
    }
    public void vision(View v){
        Intent vision = new Intent(About.this, AboutVision.class);
        startActivity(vision);
    }
    public void call(View v){
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
