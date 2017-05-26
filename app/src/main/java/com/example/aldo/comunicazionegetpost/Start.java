package com.example.aldo.comunicazionegetpost;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by play9 on 23/05/2017.
 */

public class Start extends AppCompatActivity {
    int timeout = 2000;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splashscreenwithloading);

        new Handler().postDelayed(new Runnable()
        {
            @Override
            public void run()
            {
                Intent i = new Intent(Start.this, LoginActivity.class);
                startActivity(i);
                finish();
            }
        }, timeout);
    }
}