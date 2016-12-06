package com.domain.some.rps;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class ResultsPage extends AppCompatActivity {
    ImageView userResult, cpuResult;
    TextView rulingtext, rulingoutcometext, userchoicetext;
    Button button1;
    int randomCPUResult;
    private String[] choices = {"", "Rock", "Paper", "Scissors"};
    int rock = 1; int paper = 2; int scissors = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results_page);

        rulingtext = (TextView) findViewById(R.id.txtRuling);
        rulingoutcometext = (TextView) findViewById(R.id.txtRulingOutcome);
        userchoicetext = (TextView) findViewById(R.id.txtUserChoice);
        userchoicetext.setText(AndroidTutorialApp.userName + "'s choice");

        //set button listener
        button1 = (Button) findViewById(R.id.btnPlayAgain);
        Button.OnClickListener bgoback = new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ResultsPage.this, ChoiceOfDestiny.class));
            }
        };
        button1.setOnClickListener(bgoback);
    }

    @Override
    protected void onStart() {
        super.onStart();
        randomCPUResult = randInt(1,3);

        /*
        Toast.makeText(ResultsPage.this, "user chose: " + choices[AndroidTutorialApp.theirChoice] + ", and CPU chose: " + choices[randomCPUResult],
                Toast.LENGTH_LONG).show(); //toast for debugging purposes
        */

        userResult = (ImageView) findViewById(R.id.imgUserChoice);
        cpuResult = (ImageView) findViewById(R.id.imgCpuChoice);

        //set the appropriate image for the user's choice
        switch(AndroidTutorialApp.theirChoice) {
            case 1: // user chooses rock
                userResult.setImageResource(R.drawable.rock3);
                getOutcome(paper, scissors, rock);
                break;
            case 2: // user chooses paper
                userResult.setImageResource(R.drawable.paper3);
                getOutcome(scissors, rock, paper);
                break;
            case 3: // user chooses scissors
                userResult.setImageResource(R.drawable.scissors3);
                getOutcome(rock, paper, scissors);
                break;
            default: //toast catch error
                break;
        }

        //set the appropriate image for the CPU's choice
        switch(randomCPUResult) {
            case 1: // user chooses rock
                cpuResult.setImageResource(R.drawable.rock3);
                break;
            case 2: // user chooses paper
                cpuResult.setImageResource(R.drawable.paper3);
                break;
            case 3: // user chooses scissors
                cpuResult.setImageResource(R.drawable.scissors3);
                break;
            default: //toast catch error
                break;
        }

    }


    /**
     * Will determine the outcome of the game and
     * set TextViews to inform the user of the outcome
     * and updates the win/loss/draw global variables
     *
     * @param winningOutcome the number required for the cpu to win
     * @param losingOutcome the number required for the cpu to lose
     * @param drawOutcome the number required for the cpu to draw
     */
    public void getOutcome(int winningOutcome, int losingOutcome, int drawOutcome) {
        if(randomCPUResult == winningOutcome) {
            //computer wins, user loses
            rulingtext.setText(choices[winningOutcome] + " beats " + choices[drawOutcome]);
            rulingoutcometext.setText("CPU Wins!");
            AndroidTutorialApp.losses++;

        } else if (randomCPUResult == losingOutcome) {
            //computer loses, user wins
            rulingtext.setText(choices[drawOutcome] + " beats " + choices[losingOutcome]);
            rulingoutcometext.setText( AndroidTutorialApp.userName + " Wins!");
            AndroidTutorialApp.wins++;

        } else if (randomCPUResult == drawOutcome) {
            //draw
            rulingtext.setText(AndroidTutorialApp.userName + " and CPU both chose " + choices[drawOutcome]);
            rulingoutcometext.setText( "Draw!");
            AndroidTutorialApp.draws++;
        }
    }

    /**
     * Returns a pseudo-random number between min and max, inclusive.
     * The difference between min and max can be at most
     * <code>Integer.MAX_VALUE - 1</code>.
     *
     * @param min Minimum value
     * @param max Maximum value.  Must be greater than min.
     * @return Integer between min and max, inclusive.
     * @see java.util.Random#nextInt(int)
     */
    public static int randInt(int min, int max) {

        // NOTE: This will (intentionally) not run as written so that folks
        // copy-pasting have to think about how to initialize their
        // Random instance.  Initialization of the Random instance is outside
        // the main scope of the question, but some decent options are to have
        // a field that is initialized once and then re-used as needed or to
        // use ThreadLocalRandom (if using at least Java 1.7).
        Random randomnumberr = new Random();

        // nextInt is normally exclusive of the top value,
        // so add 1 to make it inclusive
        int randomNum = randomnumberr.nextInt((max - min) + 1) + min;

        return randomNum;
    }
}
