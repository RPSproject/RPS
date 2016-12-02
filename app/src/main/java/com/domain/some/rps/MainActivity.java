package com.domain.some.rps;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toast.makeText(MainActivity.this, AndroidTutorialApp.somevalue, Toast.LENGTH_LONG).show();

        TimerTask task = new TimerTask() {

            @Override
            public void run() {
                finish();
                startActivity(new Intent(MainActivity.this, EnterInfo.class));

            }
        };
        Timer opening = new Timer();
        opening.schedule(task,5000);

    }
}
