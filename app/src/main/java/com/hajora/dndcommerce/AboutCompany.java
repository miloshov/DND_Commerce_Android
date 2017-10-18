package com.hajora.dndcommerce;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.WindowManager;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ImageButton;
import android.widget.TextView;

/**
 * Created by nikol on 13-Jul-17.
 */

public class AboutCompany extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.about_company);
        final String data = "Kompanija DND Commerce je zastupnik i distributer najvećih svetskih firmi iz oblasti sterilizacije. Prodajni program obuhvata čitav spektar proizvoda za sterilizaciju – pakovni materijali za sterilizaciju, lepilice za rolne i kese, kompletan portfolio aparata za sterilizaciju, kompletan materijal za kontrolu sterilizacije, kompletan medicinski nameštaj za sterilizaciju. Svi proizvodi ispunjavaju zahteve međunarodnih standarda i regulativa i koriste se u preko 80 zemalja širom sveta. Osim najkvalitetnijih proizvoda, ono što nas izdvaja od drugih jeste da možete dobiti i adekvatno znanje za primenu istih. Konstantno ulažemo u obrazovanje kroz edukacije, radionice i seminare sa ciljem da podignemo svest o sterilizaciji u svim zdravstvenim ustanovama. Takođe, i naše prezentacije Vam pružaju mogućnost upoznavanja proizvoda i njihovu primenu uz dobijanje adekvatnih kataloga i uzoraka.  Skladištenje, prodaja i distribucija proizvoda sa jasno definisanim uslovima nabavke, kao i odgovorom na zahteve tržišta su karakteristika uspešnog poslovanja DND Commerce-a. Politika firme je stalna težnja ka unapređenju na svim poljima.";
        Typeface font = Typeface.createFromAsset(getAssets(), "fonts/poppins.ttf");
        WebView webView = (WebView) findViewById(R.id.webView1);
        String myData = "<html>\n<head>\n<style type=\"text/css\">\n@font-face {\nfont-family: MyFont;\nsrc: url(\"file:///android_asset/fonts/poppins.ttf\")\n}\nbody {\nfont-family: MyFont;\nfont-size: medium;\ntext-align: justify;\n}\n</style>\n</head>\n<body>";
        myData += data;
        myData += "</body></html>";
        webView.loadDataWithBaseURL("", myData,"text/html", "utf-8", null);
        // Passes flag images URL into ImageLoader.class
         ImageButton share = (ImageButton) findViewById(R.id.share_company);
        share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent sendIntent = new Intent();
                sendIntent.setAction(Intent.ACTION_SEND);
                sendIntent.putExtra(Intent.EXTRA_TEXT, "DND o nama\n"+data );
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