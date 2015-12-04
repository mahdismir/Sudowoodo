package com.example.thinkpad.myfirstapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.thinkpad.myfirstapp.MainMenuActivities.AddPlantActivities.AddPlantMenu;
import com.example.thinkpad.myfirstapp.MainMenuActivities.PlantListActivity;
import com.example.thinkpad.myfirstapp.MainMenuActivities.WateringScheduleActivities.WateringScheduleActivity;
import com.example.thinkpad.myfirstapp.MainMenuActivities.WeatherActivity;

public class MainMenuActivity extends AppCompatActivity {

    // Add a plant flag for testing.
    boolean addPlantButtonFlag;


    // Accessor method.
    public boolean getAddPlantFlag(){
        return addPlantButtonFlag;
    }


    // Helper function for testing.
    public void callOnCreate(){
        Bundle test = new Bundle();
        this.onCreate(test);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_message);

        /************************************/
        /********** WEATHER BUTTON **********/
        /************************************/
        Button btnWeatherScreen = (Button) findViewById(R.id.btnWeatherScreen);
        btnWeatherScreen.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
            Intent nextScreen = new Intent(getApplicationContext(), WeatherActivity.class);
            startActivity(nextScreen);
            }
        });


        /****************************************/
        /********** ADD A PLANT BUTTON **********/
        /****************************************/
        Button btnAddPlant = (Button) findViewById(R.id.btnAddPlant);
        btnAddPlant.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {

            // Setting the flag to true for testing.
            addPlantButtonFlag = true;

            // Starting a new Intent.
            Intent nextScreen = new Intent(getApplicationContext(), AddPlantMenu.class);
            startActivity(nextScreen);
            }
        });


        /**********************************************/
        /********** WATERING SCHEDULE BUTTON **********/
        /**********************************************/
        Button btnWateringScheduleActivity = (Button) findViewById(R.id.wateringSchedule);
        btnWateringScheduleActivity.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
            Intent nextScreen = new Intent(getApplicationContext(), WateringScheduleActivity.class);
            startActivity(nextScreen);
            }
        });


        /***************************************/
        /********** PLANT LIST BUTTON **********/
        /***************************************/
        Button btnPlantListActivity = (Button) findViewById(R.id.plantList);
        btnPlantListActivity.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
            Intent nextScreen = new Intent(getApplicationContext(), PlantListActivity.class);
            startActivity(nextScreen);
            }
        });


        /*********************************/
        /********** TEST BUTTON **********/
        /*********************************/
        Button btnTest = (Button) findViewById(R.id.test);
        btnTest.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {

                testAddCoolScenario testingAddCoolObj = new testAddCoolScenario();
                testingAddCoolObj.testAddCoolValid();

                // If all tests pass, the result will be true. Inform the user they passed test.
                if(testingAddCoolObj.getResult()) {
                    Intent nextScreen1 = new Intent(getApplicationContext(), testResult1.class);
                    startActivity(nextScreen1);
                }
                else { // Else they are informed they didn't pass the test.
                    Intent nextScreen2 = new Intent(getApplicationContext(), testResult2.class);
                    startActivity(nextScreen2);
                }
            }
        });
    }

    public void sendMessage1(View view) {}
    public void sendMessage2(View view) {}
    public void sendMessage3(View view) {}
    public void sendMessage4(View view) {}
    public void sendMessage5(View view) {}
}