package com.appmilitia.beast.mmsa.beast;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class Splash extends Activity {
    private final int SPLASH_DISPLAY_LENGTH = 1000;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(1);
        setContentView(R.layout.activity_splash);
        new Handler().postDelayed(new Runnable() {
            public void run() {
                Splash.this.startActivity(new Intent(Splash.this, MainActivity.class));
                Splash.this.finish();
            }
        }, 1000);
    }
}
