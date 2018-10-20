package com.example.android.scorekeeperapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    protected int teamAScoreValue = 0;
    protected int teamBScoreValue = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button teamAGoal        = findViewById(R.id.addGoalButtonTeamA);
        Button teamAPenaltyKick    = findViewById(R.id.addPenaltyKickButtonTeamA);

        teamAGoal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                increaseTeamAScore();
            }
        });

        teamAPenaltyKick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                increaseTeamAScore();
            }
        });

        Button teamBGoal = findViewById(R.id.addGoalButtonTeamB);
        Button teamBPenaltyKick = findViewById(R.id.addPenaltyKickButtonTeamB);

        teamBGoal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                increaseTeamBScore();
            }
        });

        teamBPenaltyKick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                increaseTeamBScore();
            }
        });
    }

    public void increaseTeamAScore(){
        TextView teamAScore = findViewById(R.id.teamAscoreView);
        teamAScore.setText("" + ++teamAScoreValue);
    }

    public void increaseTeamBScore(){
        TextView teamAScore = findViewById(R.id.teamBscoreView);
        teamAScore.setText("" + ++teamBScoreValue);
    }

}
