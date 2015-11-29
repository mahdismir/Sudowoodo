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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_button_add_a_new_plant);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Button btnAddTemperate = (Button) findViewById(R.id.temperatebtn);
        btnAddTemperate.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                //Starting a new Intent
                Intent nextScreen = new Intent(getApplicationContext(), AddTemperate.class);
                startActivity(nextScreen);

            }
        });


        Button btnAddDesert = (Button) findViewById(R.id.desertbtn);
        btnAddDesert.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                //Starting a new Intent
                Intent nextScreen = new Intent(getApplicationContext(), AddDesert.class);
                startActivity(nextScreen);

            }
        });



        Button btnAddCool = (Button) findViewById(R.id.coolbtn);
        btnAddCool.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                //Starting a new Intent
                Intent nextScreen = new Intent(getApplicationContext(), AddCool.class);
                startActivity(nextScreen);

            }
        });



        Button btnAddTropical = (Button) findViewById(R.id.Tropicalbtn);
        btnAddTropical.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                //Starting a new Intent
                Intent nextScreen = new Intent(getApplicationContext(), AddTropical.class);
                startActivity(nextScreen);

            }
        });


    }

}
