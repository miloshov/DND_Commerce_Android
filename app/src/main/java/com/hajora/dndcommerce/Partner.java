package com.hajora.dndcommerce;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;


/**
 * Created by nikol on 06-Sep-17.
 */

public class Partner extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.partner);

        String partner = getIntent().getStringExtra("partner");
        String tekst = getIntent().getStringExtra("tekst");
        String logo = getIntent().getStringExtra("logo");
        final String link = getIntent().getStringExtra("link");

        TextView par = (TextView) findViewById(R.id.par);

        ImageView img = (ImageView) findViewById(R.id.imageViewPartner);
        final TextView lin = (TextView) findViewById(R.id.web);
        WebView webView = (WebView) findViewById(R.id.webView1);
        String myData = "<html>\n<head>\n<style type=\"text/css\">\n@font-face {\nfont-family: MyFont;\nsrc: url(\"file:///android_asset/fonts/poppins.ttf\")\n}\nbody {\nfont-family: MyFont;\nfont-size: medium;\ntext-align: justify;\n}\n</style>\n</head>\n<body>";
        myData += tekst;
        myData += "</body></html>";
        webView.loadDataWithBaseURL("", myData,"text/html", "utf-8", null);
        lin.setText(link);

        par.setText(partner);
        switch (logo) {
            case "1":
                img.setImageResource(R.drawable.amcor);
                break;
            case "2":
                img.setImageResource(R.drawable.belintra);
                break;
            case "3":
                img.setImageResource(R.drawable.sterimed);
                break;
            case "4":
                img.setImageResource(R.drawable.soltec);
                break;
            case "5":
                img.setImageResource(R.drawable.steelco);
                break;
            case "6":
                img.setImageResource(R.drawable.hawo);
                break;
            case "7":
                img.setImageResource(R.drawable.printex);
                break;
            case "8":
                img.setImageResource(R.drawable.cbm);
                break;

        }
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



/*        Button imageLogo = (Button)findViewById(R.id.lin);
        imageLogo.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                String url = "http://"+link;

                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
            }
        });*/
    }
}