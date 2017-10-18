package com.hajora.dndcommerce;

import android.app.Activity;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by nikol on 07-Jul-17.
 */

public class Submit extends Activity {
    String mname;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.submit);

        final EditText name = (EditText) findViewById(R.id.name);
        final EditText surname = (EditText) findViewById(R.id.surname);
        final EditText license = (EditText) findViewById(R.id.license);
        final EditText institution = (EditText) findViewById(R.id.institution);
        final EditText phone = (EditText) findViewById(R.id.phone);
        final EditText email = (EditText) findViewById(R.id.email);
        Bundle bundle = null;
        bundle = this.getIntent().getExtras();
        final String myString = bundle.getString("submitName");
        Typeface font = Typeface.createFromAsset(getAssets(), "fonts/poppins.ttf");
        name.setTypeface(font);
        surname.setTypeface(font);
        license.setTypeface(font);
        institution.setTypeface(font);
        phone.setTypeface(font);
        email.setTypeface(font);

        final Button send = (Button) this.findViewById(R.id.evSubmit);

        send.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Mail m = new Mail("dndadmin@hajora.com", "_NKTD]W7uIC(");
                String mname = name.getText().toString();
                String msurname = surname.getText().toString();
                String mlicense = license.getText().toString();
                String minstitution = institution.getText().toString();
                String mphone = phone.getText().toString();
                String memail = email.getText().toString();
                StrictMode.ThreadPolicy policy = null;
                if( name.getText().toString().length() == 0 )
                    name.setError( "Ime je obavezno!" );
                if( surname.getText().toString().length() == 0 )
                    surname.setError( "Prezime  je obavezno!" );
                if( phone.getText().toString().length() == 0 )
                    phone.setError( "Telefon je obavezan!" );
                if( email.getText().toString().length() == 0 )
                    email.setError( "Email je obavezan!" );

                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.GINGERBREAD) {
                    policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
                StrictMode.setThreadPolicy(policy);}
                String[] toArr = {"info@dndcommerce.rs",memail};

                m.setTo(toArr);
                m.setFrom("dndadmin@hajora.com");
                m.setSubject("Prijava za edukaciju");
                m.setBody("Prijava za događaj:"+myString+"\nPodaci o korisniku:\nIme: "+mname+"\nPrezime: " +msurname+"\nBroj licence: "+mlicense+"\nUstanova: "+minstitution+"\nTelefon: "+mphone+"\nEmail: "+memail);

                try {
                    /*m.addAttachment("/sdcard/filelocation");*/

                    if(m.send()) {
                        Toast.makeText(Submit.this, "Uspešno ste se prijavili.", Toast.LENGTH_LONG).show();
                        finish();
                    } else {
                        Toast.makeText(Submit.this, "Prijava nije uspešna.", Toast.LENGTH_LONG).show();
                    }
                } catch(Exception e) {
                    //Toast.makeText(MailApp.this, "There was a problem sending the email.", Toast.LENGTH_LONG).show();
                    Log.e("MailApp", "Could not send email", e);
                }
            }
        });
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

