package com.hajora.dndcommerce;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.WindowManager;
import android.webkit.WebView;
import android.widget.ImageButton;
import android.widget.TextView;

/**
 * Created by nikol on 13-Jul-17.
 */

public class AboutHistory extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.about_history);
        final String data = "Kompanija DND Commerce je osnovana 1992. godine, i opstala je u vremenima koja su iza nas, kako dobrim, tako i lošim. DND Commerce je napredovao punih 20 godina, čime je stekao status kompanije sa tradicijom u koju su uloženi znanje, trud, rad, kapital i energija, kao osnovni preduslovi za uspešnost i dugo trajanje. Daljim napredovanjem trudićemo se da opravdamo ukazano poverenje svih naših kupaca, kako sadašnjih, tako i budućih.";
        Typeface font = Typeface.createFromAsset(getAssets(), "fonts/poppins.ttf");
        WebView webView = (WebView) findViewById(R.id.webView1);
        String myData = "<html>\n<head>\n<style type=\"text/css\">\n@font-face {\nfont-family: MyFont;\nsrc: url(\"file:///android_asset/fonts/poppins.ttf\")\n}\nbody {\nfont-family: MyFont;\nfont-size: medium;\ntext-align: justify;\n}\n</style>\n</head>\n<body>";
        myData += data;
        myData += "</body></html>";
        webView.loadDataWithBaseURL("", myData,"text/html", "utf-8", null);
        // Passes flag images URL into ImageLoader.class
        ImageButton share = (ImageButton) findViewById(R.id.share_history);
        share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent sendIntent = new Intent();
                sendIntent.setAction(Intent.ACTION_SEND);
                sendIntent.putExtra(Intent.EXTRA_TEXT, "DND istorijat\n" + data);
                sendIntent.setType("text/plain");
                startActivity(sendIntent);
            }
        });
        TextView textfont = (TextView) findViewById(R.id.textView);
        textfont.setTypeface(font);
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
