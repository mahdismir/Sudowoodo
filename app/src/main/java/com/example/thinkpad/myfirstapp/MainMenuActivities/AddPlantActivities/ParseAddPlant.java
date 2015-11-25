package com.example.thinkpad.myfirstapp.MainMenuActivities.AddPlantActivities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.thinkpad.myfirstapp.data.Plant;
import com.parse.ParseObject;
import com.parse.ParseUser;

public class ParseAddPlant extends AppCompatActivity {
    Plant newPlant;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_test_add_aplant);
        // Get the current username
        ParseUser currentUser = ParseUser.getCurrentUser();
        String username = currentUser.getString("username");

        //get the nickname from the last activity
        Intent previous = getIntent();
        String nickname = previous.getExtras().getString("plantNickname");
        String type = previous.getExtras().getString("plantType");

        //associate the plant with the current user
        newPlant = new Plant(3, 3, type, nickname, username);

        ParseObject testPlant = new ParseObject(username + "_Plants");



        testPlant.put("Owner", username);
        testPlant.put("Nickname", newPlant.getNickname());
        testPlant.put("Type", newPlant.getType());
        testPlant.put("wateringInterval", newPlant.getWateringInterval());
        testPlant.put("lastWatered", newPlant.getLastWatered());
        testPlant.saveInBackground();

        // Go back to the main menu
        this.finish();
        //Intent mainMenu = new Intent(getApplicationContext(), MainMenuActivity.class);
        //startActivity(mainMenu);

    }

}
