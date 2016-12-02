package com.domain.some.rps;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


public class EnterInfo extends AppCompatActivity {

    Button button1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter_info);

        button1 = (Button) findViewById(R.id.btnStart);
        button1.setOnClickListener(bukulele);

    }

    Button.OnClickListener bukulele = new Button.OnClickListener() {
        @Override
        public void onClick(View v) {
            AndroidTutorialApp.somevalue = "ok we edited";
            button1.setText(AndroidTutorialApp.somevalue);
        }
    };
}
