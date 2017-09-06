package com.hajora.dndcommerce;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

/**
 * Created by nikol on 13-Jul-17.
 */

public class AboutPartners extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.about_partners);

        Button p1 = (Button) findViewById(R.id.part1);
        p1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(), Partner.class);
                intent.putExtra("partner", "test partner");
                intent.putExtra("tekst", "test tekst");
                intent.putExtra("link", "www.google.com");
                startActivity(intent);
            }
        });

        Button belintra = (Button) findViewById(R.id.belintra);
        belintra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(), Partner.class);
                intent.putExtra("partner", "Belintra");
                intent.putExtra("tekst", "An optimal organization of logistics is of primordial importance in healthcare services. Belintra is a leading European provider of hospital logistics solutions. We are much more than a supplier of equipment. We develop the necessary infrastructure, enable organizational and logistical processes, and implement workable solutions." +
                        "\n" +
                        "Thanks to efficient storage and transportation solutions, every healthcare organization can improve time and means invested in their patients’ well-being. This applies to all different departments: Nursery ward, Sterilization & OR, Pharmacy, Emergency & ICU. Also cross-department accessories are in scope." +
                        "\n" +
                        "During 40 years Belintra has developed a wealth of experience in logistics and has thus become a real expert. Different product lines have been developed to serve the needs of specific departments, as well as (storage and transportation) solutions which can be used across different departments." +
                        "\n" +
                        "Many of our products have a modular approach to fit a diverse range of needs. And if the standard modular structures don’t suffice, we have all the competencies to deliver tailor-made solutions based on your facility’s specific requirements.");
                intent.putExtra("link", "www.belintra.com/");
                startActivity(intent);
            }
        });



    }
        @Override
        public void onWindowFocusChanged ( boolean hasFocus){
            super.onWindowFocusChanged(hasFocus);
            getWindow().setFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION, WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
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
