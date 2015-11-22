package com.example.thinkpad.myfirstapp.test;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.example.thinkpad.myfirstapp.Plant;
import com.example.thinkpad.myfirstapp.R;
import com.parse.ParseObject;

public class TestAddAPlant extends AppCompatActivity {
    Plant newPlant;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_add_aplant);

        newPlant = new Plant(3, "Desert", 3, "Mitch");

        ParseObject testPlant = new ParseObject("testPlantTag");

        testPlant.put("Nickname", newPlant.getNickname());
        testPlant.put("Type", newPlant.getType());
        testPlant.put("wateringInterval", newPlant.getWateringInterval());
        testPlant.put("lastWatered", newPlant.getLastWatered());
        testPlant.saveInBackground();


    }

}
