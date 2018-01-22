package com.example.micha.funwithfragments;

import android.app.Fragment;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

public class TimerActivity extends BaseActivity {

    private Timer stopWatch;
    private TextView time;
    private Button pauseTimer;
    private Button startTimer;
    private TimerTask timerTask;
    private int timePassed;
    private Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ViewGroup view = findViewById(R.id.content);
        getLayoutInflater().inflate(R.layout.activity_timer, view);

        Fragment clock = getFragmentManager().findFragmentById(R.id.clockView);
        Fragment buttons = getFragmentManager().findFragmentById(R.id.btnView);
        startTimer = buttons.getView().findViewById(R.id.timerStart);
        pauseTimer = buttons.getView().findViewById(R.id.timerStop);
        time = clock.getView().findViewById(R.id.timerClock);
        time.setText("00:00");
        timePassed = 0;
        handler = new Handler();

        startTimer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                stopWatch = new Timer();
                makeTimer();
                stopWatch.schedule(timerTask,0,1000);

            }
        });

        pauseTimer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(stopWatch != null){
                    stopWatch.cancel();
                    stopWatch = null;
                    timePassed = 0;
                    time.setText("00:00");
                }

            }
        });

    }

    private void makeTimer() {

        timerTask = new TimerTask() {
            @Override
            public void run() {
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        timePassed++;
                        time.setText(String.format("%02d:%02d",timePassed/60,timePassed%60));
                        Log.d("Doesn't Matter", "run: "+timePassed);
                    }
                });
            }
        };
    }

}
