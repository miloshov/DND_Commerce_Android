package com.hajora.dndcommerce;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
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
        final String link = getIntent().getStringExtra("link");

        TextView par = (TextView) findViewById(R.id.par);
        TextView tex = (TextView) findViewById(R.id.tex);
        final TextView lin = (TextView) findViewById(R.id.lin);

        par.setText(partner);
        tex.setText(tekst);
        lin.setText("WWW");

        Button imageLogo = (Button)findViewById(R.id.lin);
        imageLogo.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                String url = "http://"+link;

                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
            }
        });
    }
}