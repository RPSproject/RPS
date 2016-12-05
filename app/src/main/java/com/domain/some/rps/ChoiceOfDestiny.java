package com.domain.some.rps;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ChoiceOfDestiny extends AppCompatActivity {

    Button button2, button3, button4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choice_of_destiny);

        button2 = (Button) findViewById(R.id.btnRock);
        button3 = (Button) findViewById(R.id.btnPaper);
        button4 = (Button) findViewById(R.id.btnScissors);
        button2.setOnClickListener(brock);
        button3.setOnClickListener(bpaper);
        button4.setOnClickListener(bscissors);

        TextView welcometext = (TextView)findViewById(R.id.txtWelcome);

        welcometext.setText("Welcome, " + AndroidTutorialApp.userName);

    }


    Button.OnClickListener brock = new Button.OnClickListener() {
        @Override
        public void onClick(View v) {
            AndroidTutorialApp.theirChoice = 1;
            //show ResultsPage
        }
    };

    Button.OnClickListener bpaper = new Button.OnClickListener() {
        @Override
        public void onClick(View v) {
            AndroidTutorialApp.theirChoice = 2;
            //show ResultsPage
        }
    };

    Button.OnClickListener bscissors = new Button.OnClickListener() {
        @Override
        public void onClick(View v) {
            AndroidTutorialApp.theirChoice = 3;
            //show ResultsPage
        }
    };

}
