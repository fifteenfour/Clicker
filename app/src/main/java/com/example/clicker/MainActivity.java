package com.example.clicker;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Formatter;
import java.util.Timer;
import java.util.TimerTask;

import android.graphics.Point;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
Button butt;
int count, time;
int maxX, maxY;
int buttonHeight, buttonWight;
Timer objectTimer;
    void rand(){

        //спизженный код
        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        maxX = size.x;
        maxY = size.y;
        //

        buttonHeight = butt.getHeight();
        buttonWight = butt.getWidth();
        butt.setX((int)(Math.random() * (maxX - buttonWight)));
        butt.setY((int)(Math.random() * (maxY - buttonHeight-150)));
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        butt = findViewById(R.id.butt);
        buttonHeight = butt.getHeight();
        buttonWight = butt.getWidth();

        objectTimer = new Timer();
        objectTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                time++;
                if (time == 10){
                    rand();
                    time = 0;
                }
            }
        }, 0, 300);
        butt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rand();
                count++;
                time = 0;
            }
        });
    }
}