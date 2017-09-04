package com.hajora.dndcommerce;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

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
        Intent call = new Intent(Intent.ACTION_CALL);
        call.setData(Uri.parse("tel:0377778888"));
        startActivity(call);
    }
}
