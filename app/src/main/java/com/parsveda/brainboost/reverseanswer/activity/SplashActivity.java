package com.parsveda.brainboost.reverseanswer.activity;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.parsveda.brainboost.reverseanswer.R;
import com.parsveda.brainboost.reverseanswer.base.Globals;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);


        TextView txtCompany = (TextView) findViewById(R.id.txtCompany);
        //Typeface face = Typeface.createFromAsset(getAssets(), "fonts/Reckoner.ttf");

        txtCompany.setTypeface(Globals.ReckonerFace, Typeface.BOLD);



        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashActivity.this, MenuActivity.class);
                startActivity(intent);
                finish();
            }
        }, 3000);


    }



}
