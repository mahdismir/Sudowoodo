package com.example.thinkpad.myfirstapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import com.example.thinkpad.myfirstapp.R;

public class WateringScheduleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_watering_schedule);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        Button WSbtnAddTemperate = (Button) findViewById(R.id.WStemperatebtn);
        WSbtnAddTemperate.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                Intent nextScreen = new Intent(getApplicationContext(), WaterTemperate.class);
                startActivity(nextScreen);

            }
        });

        Button WSbtnAddDesert = (Button) findViewById(R.id.WSdesertbtn);
        WSbtnAddDesert.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                Intent nextScreen = new Intent(getApplicationContext(), WaterDesert.class);
                startActivity(nextScreen);

            }
        });


        Button WSbtnAddCool = (Button) findViewById(R.id.WScoolbtn);
        WSbtnAddCool.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                Intent nextScreen = new Intent(getApplicationContext(), WaterCool.class);
                startActivity(nextScreen);

            }
        });


        Button WSbtnAddTropical = (Button) findViewById(R.id.WSTropicalbtn);
        WSbtnAddTropical.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                Intent nextScreen = new Intent(getApplicationContext(), WaterTropical.class);
                startActivity(nextScreen);

            }
        });
    }

}
