package edu.orangecoastcollege.cs273.vnguyen629.occlostandfound;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.Timer;
import java.util.TimerTask;

/**
 *
 */
public class SplashScreenActivity extends AppCompatActivity {

    /**
     *
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        TimerTask timerTask = new TimerTask() {
            /**
             *
             */
            @Override
            public void run() {
                finish();
                startActivity(new Intent(SplashScreenActivity.this, MainMenuActivity.class));
            }
        };

        Timer timer = new Timer();
        timer.schedule(timerTask, 3000);
    }
}