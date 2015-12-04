package com.example.thinkpad.myfirstapp.MainMenuActivities.AddPlantActivities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import com.example.thinkpad.myfirstapp.MainMenuActivities.AddPlantActivities.PlantCategories.AddCool;
import com.example.thinkpad.myfirstapp.MainMenuActivities.AddPlantActivities.PlantCategories.AddDesert;
import com.example.thinkpad.myfirstapp.MainMenuActivities.AddPlantActivities.PlantCategories.AddTemperate;
import com.example.thinkpad.myfirstapp.MainMenuActivities.AddPlantActivities.PlantCategories.AddTropical;
import com.example.thinkpad.myfirstapp.R;

public class AddPlantMenu extends AppCompatActivity {

    boolean addCoolPlantFlag;

    // Accessor Method
    public boolean getAddCoolPlantFlag(){
        return addCoolPlantFlag;
    }


    // Helper function for testing.
    public void callOnCreate(){
        Bundle test = new Bundle();
        this.onCreate(test);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_button_add_a_new_plant);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        // TEMPERATE BUTTON
        Button btnAddTemperate = (Button) findViewById(R.id.temperatebtn);
        btnAddTemperate.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
            Intent nextScreen = new Intent(getApplicationContext(), AddTemperate.class);
            startActivity(nextScreen);
            }
        });

        // DESSERT BUTTON
        Button btnAddDesert = (Button) findViewById(R.id.desertbtn);
        btnAddDesert.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
             Intent nextScreen = new Intent(getApplicationContext(), AddDesert.class);
             startActivity(nextScreen);
            }
        });

        // COOL BUTTON
        Button btnAddCool = (Button) findViewById(R.id.coolbtn);
        btnAddCool.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {

            //Setting the flag to true for testing.
            addCoolPlantFlag = true;

            //Starting a new Intent
            Intent nextScreen = new Intent(getApplicationContext(), AddCool.class);
            startActivity(nextScreen);
            }
        });

        // TROPICAL BUTTON
        Button btnAddTropical = (Button) findViewById(R.id.Tropicalbtn);
        btnAddTropical.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
            Intent nextScreen = new Intent(getApplicationContext(), AddTropical.class);
            startActivity(nextScreen);
            }
        });
    }
}