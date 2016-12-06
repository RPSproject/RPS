package com.domain.some.rps;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class ChoiceOfDestiny extends AppCompatActivity {

    ImageButton button2, button3, button4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choice_of_destiny);

        button2 = (ImageButton) findViewById(R.id.btnRock);
        button3 = (ImageButton) findViewById(R.id.btnPaper);
        button4 = (ImageButton) findViewById(R.id.btnScissors);
        button2.setOnClickListener(brock);
        button3.setOnClickListener(bpaper);
        button4.setOnClickListener(bscissors);

        TextView welcometext = (TextView)findViewById(R.id.txtWelcome);

        welcometext.setText("Welcome, " + AndroidTutorialApp.userName);

    }

    // 1 for rock, 2 for paper, 3 for scissors
    Button.OnClickListener brock = new Button.OnClickListener() {
        @Override
        public void onClick(View v) {
            AndroidTutorialApp.theirChoice = 1;
            startActivity(new Intent(ChoiceOfDestiny.this, ResultsPage.class));
        }
    };

    Button.OnClickListener bpaper = new Button.OnClickListener() {
        @Override
        public void onClick(View v) {
            AndroidTutorialApp.theirChoice = 2;
            startActivity(new Intent(ChoiceOfDestiny.this, ResultsPage.class));
        }
    };

    Button.OnClickListener bscissors = new Button.OnClickListener() {
        @Override
        public void onClick(View v) {
            AndroidTutorialApp.theirChoice = 3;
            startActivity(new Intent(ChoiceOfDestiny.this, ResultsPage.class));
        }
    };

}
