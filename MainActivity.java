package com.example.stopwatch;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;

public class MainActivity extends AppCompatActivity {
    boolean isrunning=false;
    long pauseoffset=0;
    Chronometer c;
    Button b1, b2, b3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        c = (Chronometer) findViewById(R.id.custom_chronometer);
        b1=(Button) findViewById(R.id.button);
        b2=(Button) findViewById(R.id.button2);
        b3=(Button) findViewById(R.id.button3);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!isrunning){
                    c.setBase(SystemClock.elapsedRealtime() - pauseoffset);
                    c.start();
                    isrunning=true;
                }
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isrunning){
                    c.stop();
                    pauseoffset = SystemClock.elapsedRealtime() - c.getBase();
                    isrunning=false;
                }
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                c.setBase(SystemClock.elapsedRealtime());
                c.stop();
                pauseoffset = 0;
                isrunning=false;
            }
        });
    }
}
