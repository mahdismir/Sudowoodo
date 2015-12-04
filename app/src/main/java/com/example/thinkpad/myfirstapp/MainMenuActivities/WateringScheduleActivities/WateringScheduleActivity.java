package com.example.thinkpad.myfirstapp.MainMenuActivities.WateringScheduleActivities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import com.example.thinkpad.myfirstapp.MainMenuActivities.WateringScheduleActivities.WaterCool;
import com.example.thinkpad.myfirstapp.MainMenuActivities.WateringScheduleActivities.WaterDesert;
import com.example.thinkpad.myfirstapp.MainMenuActivities.WateringScheduleActivities.WaterTemperate;
import com.example.thinkpad.myfirstapp.MainMenuActivities.WateringScheduleActivities.WaterTropical;
import com.example.thinkpad.myfirstapp.R;

public class WateringScheduleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_watering_schedule);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        // TEMPERATE BUTTON
        Button WSbtnAddTemperate = (Button) findViewById(R.id.WStemperatebtn);
        WSbtnAddTemperate.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
            Intent nextScreen = new Intent(getApplicationContext(), WaterTemperate.class);
            startActivity(nextScreen);
            }
        });

        // DESERT BUTTON
        Button WSbtnAddDesert = (Button) findViewById(R.id.WSdesertbtn);
        WSbtnAddDesert.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
            Intent nextScreen = new Intent(getApplicationContext(), WaterDesert.class);
            startActivity(nextScreen);
            }
        });

        // COOL BUTTON
        Button WSbtnAddCool = (Button) findViewById(R.id.WScoolbtn);
        WSbtnAddCool.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
            Intent nextScreen = new Intent(getApplicationContext(), WaterCool.class);
            startActivity(nextScreen);
            }
        });

        // TROPICAL BUTTON
        Button WSbtnAddTropical = (Button) findViewById(R.id.WSTropicalbtn);
        WSbtnAddTropical.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
            Intent nextScreen = new Intent(getApplicationContext(), WaterTropical.class);
            startActivity(nextScreen);
            }
        });
    }
}