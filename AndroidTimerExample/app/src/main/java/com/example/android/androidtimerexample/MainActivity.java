package com.example.android.androidtimerexample;

import android.os.Handler;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button startButton;
    private Button pauseButton;

    private TextView timerValue;

    private long startTime = 0L;

    private Handler customHandler = new Handler();

    long timeInMillieSeconds = 0L;
    long timeSwapBuffer = 0L;
    long updatedTime = 0L;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        timerValue = findViewById(R.id.timerValue);

        startButton = findViewById(R.id.startButton);

        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startTime = SystemClock.uptimeMillis();
                customHandler.postDelayed(updateTimerThread, 0);
            }
        });

        pauseButton = findViewById(R.id.pauseButton);

        pauseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                timeSwapBuffer += timeInMillieSeconds;
                customHandler.removeCallbacks(updateTimerThread);
            }
        });

    }

    private  Runnable updateTimerThread = new Runnable() {
        @Override
        public void run() {

            timeInMillieSeconds = SystemClock.uptimeMillis() - startTime;

            updatedTime = timeSwapBuffer + timeInMillieSeconds;

            int secs = (int) (updatedTime / 1000);
            int mins = secs / 60;
            secs = secs % 60;
            int milliseconds = (int) (updatedTime % 1000);
            timerValue.setText("" + mins + ":"
                + String.format("%02d", secs)+ ":"
                + String.format("%03d", milliseconds));
            customHandler.postDelayed(this, 0);
        }
    };
}
