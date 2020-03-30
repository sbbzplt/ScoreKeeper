package com.sabarife.scorekeeper;

import androidx.appcompat.app.AppCompatActivity;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Integer baskets1 = 0;
    private int score1 = 0;

    private int baskets2 = 0;
    private int score2 = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

        final TextView team1BasketsTextView = findViewById(R.id.team_1_baskets_textview);
        final TextView team1ScoreTextView = findViewById(R.id.team_1_score_textview);
        final TextView team2BasketsTextView = findViewById(R.id.team_2_baskets_textview);
        final TextView team2ScoreTextView = findViewById(R.id.team_2_score_textview);

        team1BasketsTextView.setText(baskets1+"");
        team1ScoreTextView.setText(score1+"");
        team2BasketsTextView.setText(baskets2+"");
        team2ScoreTextView.setText(score2+"");

        Button team1Plus1Button = findViewById(R.id.team1_plus_one_button);
        Button team1Plus3Button = findViewById(R.id.team1_plus_three_button);
        Button team1ResetButton = findViewById(R.id.team1_reset_button);
        Button team2Plus1Button = findViewById(R.id.team2_plus_one_button);
        Button team2Plus3Button = findViewById(R.id.team2_plus_three_button);
        Button team2ResetButton = findViewById(R.id.team2_reset_button);

        team1Plus1Button.setOnClickListener(
                new View.OnClickListener(){
                    @Override
                    public void onClick(View v) {
                        score1 = addOne(score1, team1ScoreTextView);
                        baskets1 = addOne(baskets1, team1BasketsTextView);

                    }
                }
        );

        team1Plus3Button.setOnClickListener(
                new View.OnClickListener(){
                    @Override
                    public void onClick(View v) {
                        score1 = addThree(score1, team1ScoreTextView);
                        baskets1 = addOne(baskets1, team1BasketsTextView);

                    }
                }
        );

        team1ResetButton.setOnClickListener(
                new View.OnClickListener(){
                    @Override
                    public void onClick(View v) {
                        score1 = reset(score1, team1ScoreTextView);
                        baskets1 = reset(baskets1, team1BasketsTextView);

                    }
                }
        );


        team2Plus1Button.setOnClickListener(
                new View.OnClickListener(){
                    @Override
                    public void onClick(View v) {
                        score2 = addOne(score2, team2ScoreTextView);
                        baskets2 = addOne(baskets2, team2BasketsTextView);

                    }
                }
        );

        team2Plus3Button.setOnClickListener(
                new View.OnClickListener(){
                    @Override
                    public void onClick(View v) {
                        score2 = addThree(score2, team2ScoreTextView);
                        baskets2 = addOne(baskets2, team2BasketsTextView);

                    }
                }
        );

        team2ResetButton.setOnClickListener(
                new View.OnClickListener(){
                    @Override
                    public void onClick(View v) {
                        score2 = reset(score2, team2ScoreTextView);
                        baskets2 = reset(baskets2, team2BasketsTextView);

                    }
                }
        );



    }

    private int addOne(int score, TextView textView){
        score += 1;
        textView.setText(score + "");
        return score;
    }

    private int addThree(int score, TextView textView){
        score += 3;
        textView.setText(score + "");
        return score;
    }

    private int reset(int score, TextView textView){
        score = 0;
        textView.setText(score + "");
        return score;
    }
}
