package com.domain.some.rps;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import java.text.DecimalFormat;

public class ChoiceOfDestiny extends AppCompatActivity {

    ImageButton button2, button3, button4;
    Button buttonStopped, buttonPlaying;
    MediaPlayer mpRPS;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choice_of_destiny);

        button2 = (ImageButton) findViewById(R.id.btnRock);
        button3 = (ImageButton) findViewById(R.id.btnPaper);
        button4 = (ImageButton) findViewById(R.id.btnScissors);

        buttonStopped = (Button) findViewById(R.id.btnMusicPause);
        buttonPlaying = (Button) findViewById(R.id.btnMusic);

        button2.setOnClickListener(brock);
        button3.setOnClickListener(bpaper);
        button4.setOnClickListener(bscissors);

        buttonStopped.setOnClickListener(bPlay);
        buttonPlaying.setOnClickListener(bPause);

        buttonPlaying.setVisibility(View.INVISIBLE);
        buttonStopped.setVisibility(View.VISIBLE);
        mpRPS = new MediaPlayer();
        mpRPS = MediaPlayer.create(this, R.raw.rpsmusic);



        TextView welcometext = (TextView)findViewById(R.id.txtWelcome);

        welcometext.setText("Welcome, " + AndroidTutorialApp.userName);

    }


    @Override
    protected void onStart() {
        TextView winrate = (TextView)findViewById(R.id.txtWinRate);
        TextView textwins = (TextView)findViewById(R.id.txtWins);
        TextView textlosses = (TextView)findViewById(R.id.txtLosses);
        TextView textdraws = (TextView)findViewById(R.id.txtDraws);
        DecimalFormat df = new DecimalFormat("##.##");
        DecimalFormat flat = new DecimalFormat("#");

        super.onStart();

        double therate = AndroidTutorialApp.wins/(AndroidTutorialApp.wins + AndroidTutorialApp.draws + AndroidTutorialApp.losses);

        if(Double.isNaN(therate)) { therate = 0; }

        winrate.setText("Current Win Rate: " + df.format(therate*100) + "%");
        textwins.setText("Wins: " + flat.format(AndroidTutorialApp.wins));
        textlosses.setText("Losses: " + flat.format(AndroidTutorialApp.losses));
        textdraws.setText("Draws: " + flat.format(AndroidTutorialApp.draws));

        if(AndroidTutorialApp.isplaying) {
            buttonPlaying.setVisibility(View.VISIBLE);
            buttonStopped.setVisibility(View.INVISIBLE);
        } else {
            buttonPlaying.setVisibility(View.INVISIBLE);
            buttonStopped.setVisibility(View.VISIBLE);
        }

    }

    @Override
    protected void onStop() {
        super.onStop();
        mpRPS.pause();
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

    Button.OnClickListener bPlay = new Button.OnClickListener() {
        @Override
        public void onClick(View v) {

            if(mpRPS.isPlaying()) {

            } else {
                mpRPS.start();

            }
            buttonPlaying.setVisibility(View.VISIBLE);
            buttonStopped.setVisibility(View.INVISIBLE);
        }
    };

    Button.OnClickListener bPause = new Button.OnClickListener() {

        @Override
        public void onClick(View v) {
            if(mpRPS.isPlaying()) {
                mpRPS.pause();
            } else {
                mpRPS.start();
            }
            buttonStopped.setVisibility(View.VISIBLE);
            buttonPlaying.setVisibility(View.INVISIBLE);
        }
    };

}
